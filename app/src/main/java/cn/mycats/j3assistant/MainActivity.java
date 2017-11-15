package cn.mycats.j3assistant;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private BottomNavigationBar navigationBar;
    private PetFragment petFragment;
    private MeetingFragment meetingFragment;
    private ExamFragment examFragment;
    private BaikeFragment baikeFragment;
    private PeiZhuangFragment peiZhuangFragment;
    private IndexFragment indexFragment;
    private List<Fragment> fragmentList;
    private PagerAdapter pagerAdapter;
    private Intent serverIntent;
    public static ListeningServer.MyBinder binder;
    public Connection connection;
    private SP sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = SP.getInstance(this);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        navigationBar = (BottomNavigationBar) findViewById(R.id.navigation);
        fragmentList = new ArrayList<>();
        petFragment = new PetFragment();
        meetingFragment = new MeetingFragment();
        examFragment = new ExamFragment();
        baikeFragment = new BaikeFragment();
        peiZhuangFragment = new PeiZhuangFragment();
        indexFragment = new IndexFragment();

        fragmentList.add(indexFragment);
        fragmentList.add(petFragment);
        fragmentList.add(meetingFragment);
        fragmentList.add(examFragment);
        fragmentList.add(baikeFragment);

        fragmentList.add(peiZhuangFragment);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(this);
        viewPager.setPageTransformer(true,new ZoomOutPageTransformer());

        navigationBar.setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBarBackgroundColor(R.color.colorPrimary)
                .setInActiveColor(R.color.colorGray)
                .setActiveColor(R.color.colorWhite)
                .addItem(new BottomNavigationItem(R.mipmap.icon_hone, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_cat, "宠物"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_star, "奇遇"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_exam, "科举"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_baike, "成就"))
                .addItem(new BottomNavigationItem(R.mipmap.icon_pei, "配装"))
                .initialise();

        navigationBar.setTabSelectedListener(this);

        connection = new Connection();
        serverIntent = new Intent(this,ListeningServer.class);
        startService(serverIntent);
        bindService(serverIntent, connection, BIND_AUTO_CREATE);

    }

    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public void onBackPressed() {
        if (sp.getBoolean("voice",false) || sp.getBoolean("vibrate",false)){
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("检测到正在监控开服")
                    .setContentText("你想要怎样？")
                    .setConfirmText("退出应用")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            unbindService(connection);
                            stopService(serverIntent);
                            sp.putBoolean("voice",false);
                            sp.putBoolean("vibrate",false);
                            finish();
                        }
                    })
                    .setCancelText("后台执行")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            finish();
                        }
                    })
                    .show();
        }else {
            unbindService(connection);
            stopService(serverIntent);
            sp.putBoolean("voice",false);
            sp.putBoolean("vibrate",false);
            finish();
        }

    }

    class Connection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (ListeningServer.MyBinder) service;
            if (binder != null) {

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

}

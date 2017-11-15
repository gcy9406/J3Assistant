package cn.mycats.j3assistant;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static cn.mycats.j3assistant.MainActivity.binder;


/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {


    private TextView bigWar, bigWarTomorrow,publicDayTomorrow;
    private TextView war, warTomorrow,publicDay;
    private Retrofit retrofit;
    private API api;
    private Activity activity;
    private Switch listenVoice,listenVibrate;
    private SwipeRefreshLayout swipeRefresh;
    private SP sp;
    public IndexFragment() {
        // Required empty public constructor
    }

    private View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
        sp = SP.getInstance(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_index, container, false);

        bigWar = (TextView) view.findViewById(R.id.big_war);
        war = (TextView) view.findViewById(R.id.war);
        publicDay = (TextView) view.findViewById(R.id.public_day);
        bigWarTomorrow = (TextView) view.findViewById(R.id.big_war_tomorrow);
        warTomorrow = (TextView) view.findViewById(R.id.war_tomorrow);
        publicDayTomorrow = (TextView) view.findViewById(R.id.public_day_tomorrow);
        listenVoice = (Switch) view.findViewById(R.id.listen_voice);
        listenVibrate = (Switch) view.findViewById(R.id.listen_vibrate);
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);

        swipeRefresh.setOnRefreshListener(this);
        listenVoice.setOnClickListener(this);
        listenVibrate.setOnClickListener(this);

        retrofit = new Retrofit.Builder().baseUrl("https://haiman.io")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);

        getDailys();

        listenVoice.setChecked(sp.getBoolean("voice",false));
        listenVibrate.setChecked(sp.getBoolean("vibrate",false));
        return view;
    }

    private void getDailys() {
        api.getDaily()
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String str = response.body().string();
                            int bigWarIndex = str.indexOf("大战！");
                            int warIndex = str.indexOf("战场：");
                            int publicIndex = str.indexOf("公共日常：");

                            String tempBigWar = str.substring(bigWarIndex, bigWarIndex + 100);
                            int bigWarIndexEnd = tempBigWar.indexOf("<");
                            bigWar.setText(tempBigWar.substring(0, bigWarIndexEnd));

                            String tempWar = str.substring(warIndex, warIndex + 100);
                            int warIndexEnd = tempWar.indexOf("<");
                            war.setText(tempWar.substring(0, warIndexEnd));

                            String temPublic = str.substring(publicIndex, publicIndex + 100);
                            int publicIndexEnd = temPublic.indexOf("<");
                            publicDay.setText(temPublic.substring(0, publicIndexEnd));

                            swipeRefresh.setRefreshing(false);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

        api.getDailyTomorroy("tomorrow")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String str = response.body().string();
                            int bigWarIndex = str.indexOf("大战！");
                            int warIndex = str.indexOf("战场：");
                            int publicIndex = str.indexOf("公共日常：");


                            String tempBigWar = str.substring(bigWarIndex, bigWarIndex + 100);
                            int bigWarIndexEnd = tempBigWar.indexOf("<");
                            bigWarTomorrow.setText(tempBigWar.substring(0, bigWarIndexEnd));

                            String tempWar = str.substring(warIndex, warIndex + 100);
                            int warIndexEnd = tempWar.indexOf("<");
                            warTomorrow.setText(tempWar.substring(0, warIndexEnd));

                            String temPublic = str.substring(publicIndex, publicIndex + 100);
                            int publicIndexEnd = temPublic.indexOf("<");
                            publicDayTomorrow.setText(temPublic.substring(0, publicIndexEnd));

                            swipeRefresh.setRefreshing(false);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.listen_voice:
                sp.putBoolean("voice",listenVoice.isChecked());
                break;
            case R.id.listen_vibrate:
                sp.putBoolean("vibrate",listenVibrate.isChecked());
                break;
        }

        if (listenVoice.isChecked() || listenVibrate.isChecked()){
            binder.startListener();
        }else if (!listenVoice.isChecked() && !listenVibrate.isChecked()){
            binder.stopListener();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRefresh() {
        swipeRefresh.setRefreshing(true);
        getDailys();
    }
}

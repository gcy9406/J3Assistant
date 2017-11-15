package cn.mycats.j3assistant;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, TextWatcher {

    private Retrofit retrofit;
    private API api;
    private Activity activity;
    private RecyclerView petList;
    private PetAdapter petAdapter;
    private SwipeRefreshLayout refreshLayout;
    private EditText petName;
    private Button search;
    private List<PetResult> petData;
    private SP sp;

    public PetFragment() {
        // Required empty public constructor
    }
    private View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pet, container, false);
        petData = new ArrayList<>();
        sp = SP.getInstance(activity);
        petList = view.findViewById(R.id.pet_list);
        petName = view.findViewById(R.id.pet_name);
        petName.setText(sp.getString("name",""));
        petName.addTextChangedListener(this);
        search = view.findViewById(R.id.search);
        search.setOnClickListener(this);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setRefreshing(true);
        petList.setLayoutManager(new LinearLayoutManager(activity));
        petAdapter = new PetAdapter();
        petList.setAdapter(petAdapter);
        retrofit = new Retrofit.Builder().baseUrl("http://106.14.212.183/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);

        getPet();
        return view;
    }

    private void getPet() {
        api.getPets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PetResult>>() {
                    @Override
                    public void accept(List<PetResult> petResult) throws Exception {
                        petData = petResult;

                        List<PetResult> fliterResult = new ArrayList<PetResult>();
                        String name = petName.getText().toString()+"";
                        if (name.equals("")){
                            petAdapter.setData(petResult);
                        }else {
                            for (int i = 0; i < petResult.size(); i++) {
                                if (petResult.get(i).getPet().contains(name) || petResult.get(i).getName().contains(name)){
                                    fliterResult.add(petResult.get(i));
                                }
                            }
                            petAdapter.setData(fliterResult);
                        }

                        refreshLayout.setRefreshing(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(activity, "请求失败,刷新试试", Toast.LENGTH_SHORT).show();
                        refreshLayout.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(true);
        getPet();
    }

    @Override
    public void onClick(View v) {
        List<PetResult> fliterResult = new ArrayList<>();
        String name = petName.getText().toString()+"";
        if (name.equals("")){
            petAdapter.setData(petData);
        }else {
            for (int i = 0; i < petData.size(); i++) {
                if (petData.get(i).getPet().contains(name) || petData.get(i).getName().contains(name)){
                    fliterResult.add(petData.get(i));
                }
            }
            petAdapter.setData(fliterResult);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        sp.putString("name",s.toString());
    }
}

package cn.mycats.j3assistant;


import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Xavier on 2017/11/5.
 */

public interface API {
    @Headers({"Authorization:Token token=29ae9ef6480388a26190b65d8de7b335"})
    @GET("servers/21/all_in_cd")
    Observable<List<PetResult>> getPets();

    @Headers({"Authorization:Token token=29ae9ef6480388a26190b65d8de7b335"})
    @GET("servers")
    Observable<List<ServersBeans>> getServers();

    @GET("/jx3/daily")
    Call<ResponseBody> getDaily();

    @GET("/jx3/daily")
    Call<ResponseBody> getDailyTomorroy(@Query("day") String day);
}

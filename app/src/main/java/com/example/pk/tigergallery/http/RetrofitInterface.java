package com.example.pk.tigergallery.http;

import com.example.pk.tigergallery.model.JSONResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by PK on 11.08.2017.
 */

public interface RetrofitInterface {

    String apiBaseURL = "https://api.flickr.com/services/feeds/";

    @GET("photos_public.gne?format=json&nojsoncallback=1")
    Call<JSONResult> getEverything();


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(apiBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}

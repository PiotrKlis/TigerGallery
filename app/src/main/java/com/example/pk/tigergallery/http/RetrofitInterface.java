package com.example.pk.tigergallery.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PK on 11.08.2017.
 */

public class RetrofitInterface {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.flickr.com/services/feeds/photos_public.gne")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}

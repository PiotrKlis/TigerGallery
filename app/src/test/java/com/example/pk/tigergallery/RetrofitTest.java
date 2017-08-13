package com.example.pk.tigergallery;

import android.os.AsyncTask;

import com.example.pk.tigergallery.http.RetrofitInterface;
import com.example.pk.tigergallery.model.FlickrFeed;
import com.example.pk.tigergallery.model.ParcelableImageElement;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RetrofitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void isFlickrSendingDataUsingRetrofit() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                RetrofitInterface jsonService = RetrofitInterface.retrofit.create(RetrofitInterface.class);
                Call<FlickrFeed> call = jsonService.getWholeMessage();
                final ArrayList<ParcelableImageElement> urlArray = new ArrayList<>();

                call.enqueue(new Callback<FlickrFeed>() {
                    @Override
                    public void onResponse(Call<FlickrFeed> call, Response<FlickrFeed> response) {

                        Assert.assertNotNull(response.body());

                    }

                    @Override
                    public void onFailure(Call<FlickrFeed> call, Throwable t) {
                    }
                });
            }
        });

    }




}
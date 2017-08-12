package com.example.pk.tigergallery;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.pk.tigergallery.adapter.RecyclerViewAdapter;
import com.example.pk.tigergallery.http.ImageDownloader;
import com.example.pk.tigergallery.http.RetrofitInterface;
import com.example.pk.tigergallery.model.JSONResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    // Flickr key 43ceb1fbc432d1d53687c2d1b9a7a2d8

    String TAG = "MainActivity";
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitInterface jsonService = RetrofitInterface.retrofit.create(RetrofitInterface.class);
        Call<JSONResult> call = jsonService.getEverything();
        final ArrayList<Bitmap> imgBitmapArray = new ArrayList<>();

        call.enqueue(new Callback<JSONResult>() {
            @Override
            public void onResponse(Call<JSONResult> call, Response<JSONResult> response) {

                for (int i = 0; i < response.body().getItems().size(); i++) {

                    String urlString = response.body().getItems().get(i).getMedia().getM();
                    //AsyncTask<String, Void, Bitmap> imgElement = new ImageDownloader(MainActivity.this).execute(urlString);
                    try {
                        imgBitmapArray.add(new ImageDownloader(MainActivity.this).execute(urlString).get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                showGridWithImages(imgBitmapArray);
            }

            @Override
            public void onFailure(Call<JSONResult> call, Throwable t) {
                Log.d(TAG, call.request().toString());
            }
        });
    }

        public void showGridWithImages(ArrayList<Bitmap> imgBitmapArray) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerViewAdapter = new RecyclerViewAdapter(this, imgBitmapArray);
        recyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapter);

        }

    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, "You clicked position " + position);
    }
}

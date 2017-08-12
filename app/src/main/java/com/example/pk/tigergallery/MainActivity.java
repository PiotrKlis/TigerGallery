package com.example.pk.tigergallery;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.pk.tigergallery.adapter.RecyclerViewAdapter;
import com.example.pk.tigergallery.http.ImageDownloader;
import com.example.pk.tigergallery.http.RetrofitInterface;
import com.example.pk.tigergallery.model.ImageElement;
import com.example.pk.tigergallery.model.JSONResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    // Flickr key 43ceb1fbc432d1d53687c2d1b9a7a2d8

    String TAG = "MainActivity";
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                RetrofitInterface jsonService = RetrofitInterface.retrofit.create(RetrofitInterface.class);
                Call<JSONResult> call = jsonService.getEverything();
                final ArrayList<ImageElement> urlArray = new ArrayList<>();

                call.enqueue(new Callback<JSONResult>() {
                    @Override
                    public void onResponse(Call<JSONResult> call, Response<JSONResult> response) {

                        for (int i = 0; i < response.body().getItems().size(); i++) {

                            String urlString = response.body().getItems().get(i).getMedia().getM();
                            String title = response.body().getItems().get(i).getTitle();
                            String link = response.body().getItems().get(i).getLink();
                            String date_taken = response.body().getItems().get(i).getDateTaken();
                            String description = response.body().getItems().get(i).getDescription();
                            String published = response.body().getItems().get(i).getPublished();
                            String author = response.body().getItems().get(i).getAuthor();
                            String author_id = response.body().getItems().get(i).getAuthorId();
                            String tags = response.body().getItems().get(i).getTags();

                            urlArray.add(new ImageElement(urlString, title, link, date_taken,
                                    description,published,author, author_id,tags));

                        }
                        ImageElement [] imageElementsList = urlArray.toArray(new ImageElement[urlArray.size()]);
                        showGridWithImages(imageElementsList);
                    }

                    @Override
                    public void onFailure(Call<JSONResult> call, Throwable t) {
                        Log.d(TAG, call.request().toString());
                    }
                });
            }
        });
    }

        public void showGridWithImages(ImageElement[] imgArray) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerViewAdapter = new RecyclerViewAdapter(this, imgArray);
        recyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapter);

        }

    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, "You clicked position " + position);
    }
}
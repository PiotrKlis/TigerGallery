package com.example.pk.tigergallery;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.pk.tigergallery.adapter.RecyclerViewAdapter;
import com.example.pk.tigergallery.http.RetrofitInterface;
import com.example.pk.tigergallery.model.ParcelableImageElement;
import com.example.pk.tigergallery.model.FlickrFeed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    String TAG = "MainActivity";
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // download json data using retrofit

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                RetrofitInterface jsonService = RetrofitInterface.retrofit.create(RetrofitInterface.class);
                Call<FlickrFeed> call = jsonService.getWholeMessage();
                final ArrayList<ParcelableImageElement> urlArray = new ArrayList<>();

                call.enqueue(new Callback<FlickrFeed>() {
                    @Override
                    public void onResponse(Call<FlickrFeed> call, Response<FlickrFeed> response) {

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

                            urlArray.add(new ParcelableImageElement(urlString, title, link, date_taken,
                                    description,published,author, author_id, tags));

                        }

                        // parse ArrayList into Array
                        ParcelableImageElement[] parcelableImageElementsList = urlArray.toArray(new ParcelableImageElement[urlArray.size()]);

                        showGridWithImages(parcelableImageElementsList);
                    }

                    @Override
                    public void onFailure(Call<FlickrFeed> call, Throwable t) {
                        Log.d(TAG, call.request().toString());
                    }
                });
            }
        });
    }

    /**
     * Method shows grid using recycler view, filled with images
     * @param imgArray array with images data
     */

        public void showGridWithImages(ParcelableImageElement[] imgArray) {

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
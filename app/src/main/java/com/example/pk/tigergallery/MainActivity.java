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
import com.example.pk.tigergallery.model.ImageElement;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    String TAG = "MainActivity";
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bitmap[] data = {};

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerViewAdapter = new RecyclerViewAdapter(this, data);
        recyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapter);

       // new ImageDownloader(MainActivity.this).execute(URL);


    }


    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, "You clicked position " + position);
    }
}

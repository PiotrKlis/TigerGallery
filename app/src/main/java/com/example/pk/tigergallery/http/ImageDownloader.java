package com.example.pk.tigergallery.http;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.pk.tigergallery.MainActivity;
import com.example.pk.tigergallery.model.ImageElement;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * Created by PK on 11.08.2017.
 */

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

    private ProgressBar mProgressBar;

    public ImageDownloader(Activity activity) {
        mProgressBar = new ProgressBar(activity);
    }

    @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];
            Bitmap bitmap = null;

            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Close progressdialog
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

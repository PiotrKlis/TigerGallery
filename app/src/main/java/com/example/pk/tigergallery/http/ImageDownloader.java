package com.example.pk.tigergallery.http;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.example.pk.tigergallery.MainActivity;
import com.example.pk.tigergallery.model.ImageElement;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Created by PK on 11.08.2017.
 */

    public class ImageDownloader extends AsyncTask<String, Void, ImageElement> {

    private ProgressBar mProgressBar;

    public ImageDownloader(Activity activity) {
        mProgressBar = new ProgressBar(activity);
    }

    @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected ImageElement doInBackground(String... URL) {

            String imageURL = URL[0];
            Bitmap bitmap = null;
            String metaDataString = "";

            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);

                // Metadata Download
                BufferedInputStream bis = new BufferedInputStream(input);
                Metadata metadata = ImageMetadataReader.readMetadata(bis);

                for (Directory directory : metadata.getDirectories()) {
                    for (Tag tag : directory.getTags()) {
                        metaDataString = String.valueOf(tag);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ImageElement(bitmap, metaDataString);
        }

        @Override
        protected void onPostExecute(ImageElement result) {
            // Close progressdialog
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

package com.example.pk.tigergallery;

/**
 * Created by PK on 12.08.2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.pk.tigergallery.model.ParcelableImageElement;

public class DetailActivity extends AppCompatActivity {

    public static final String IMAGE_ELEMENT = "IMAGE_ELEMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        TextView txtTitle = (TextView) findViewById(R.id.txt_title);
        TextView txtLink = (TextView) findViewById(R.id.txt_link);
        TextView txtMedia = (TextView) findViewById(R.id.txt_media);
        TextView txtDateTaken = (TextView) findViewById(R.id.txt_date_taken);
        TextView txtDescription = (TextView) findViewById(R.id.txt_description);
        TextView txtPublished = (TextView) findViewById(R.id.txt_published);
        TextView txtAuthor = (TextView) findViewById(R.id.txt_author);
        TextView txtAuthorId = (TextView) findViewById(R.id.txt_author_id);
        TextView txtTags = (TextView) findViewById(R.id.txt_tags);
        ImageView mImageView = (ImageView) findViewById(R.id.image);

        ParcelableImageElement parcelableImageElement = getIntent().getParcelableExtra(IMAGE_ELEMENT);

        txtTitle.setText(parcelableImageElement.getmTitle());
        txtLink.setText(parcelableImageElement.getmLink());
        txtDescription.setText(parcelableImageElement.getmDescription());
        txtDateTaken.setText(parcelableImageElement.getmDate_taken());
        txtMedia.setText(parcelableImageElement.getmUrl());
        txtPublished.setText(parcelableImageElement.getmPublished());
        txtAuthor.setText(parcelableImageElement.getmAuthor());
        txtAuthorId.setText(parcelableImageElement.getmAuthor_id());
        txtTags.setText(parcelableImageElement.getmTags());


        Glide.with(this)
                .load(parcelableImageElement.getmUrl())
                .asBitmap()
                .error(R.drawable.error_icon)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }
}
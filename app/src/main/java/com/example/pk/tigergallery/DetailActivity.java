package com.example.pk.tigergallery;

/**
 * Created by PK on 12.08.2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pk.tigergallery.model.ImageElement;

public class DetailActivity extends AppCompatActivity {

    public static final String IMAGE_ELEMENT = "IMAGE_ELEMENT";

    private ImageView mImageView;

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

        ImageElement imageElement = getIntent().getParcelableExtra(IMAGE_ELEMENT);

        txtTitle.setText(imageElement.getmTitle());
        txtLink.setText(imageElement.getmLink());
        txtDescription.setText(imageElement.getmDescription());
        txtDateTaken.setText(imageElement.getmDate_taken());
        txtMedia.setText(imageElement.getmUrl());
        txtPublished.setText(imageElement.getmPublished());
        txtAuthor.setText(imageElement.getmAuthor());
        txtAuthorId.setText(imageElement.getmAuthor_id());
        txtTags.setText(imageElement.getmTags());


        Glide.with(this)
                .load(imageElement.getmUrl())
                .asBitmap()
                .error(R.drawable.error_icon)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }
}
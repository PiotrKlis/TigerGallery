package com.example.pk.tigergallery.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.pk.tigergallery.DetailActivity;
import com.example.pk.tigergallery.R;
import com.example.pk.tigergallery.model.ImageElement;

/**
 * Created by PK on 11.08.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ImageElement[] mImageElements;
    private Context mContext;
    ProgressBar progressBar;

    public RecyclerViewAdapter(Context context, ImageElement[] data) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mImageElements = data;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.ryceclerview_item, parent, false);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        ImageElement imageElement = mImageElements[position];
        ImageView imageView = holder.imageView;

        Glide.with(mContext)
                .load(imageElement.getmUrl())
                .thumbnail(0.5f)
                .dontAnimate()
                .error(R.drawable.error_icon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .error(R.drawable.draw_image)
                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return mImageElements.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION) {
                ImageElement imageElement = mImageElements[position];
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(DetailActivity.IMAGE_ELEMENT, imageElement);
                mContext.startActivity(intent);
            }
        }
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
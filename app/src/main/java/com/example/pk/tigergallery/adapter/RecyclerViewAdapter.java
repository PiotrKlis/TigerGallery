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
import com.example.pk.tigergallery.model.ParcelableImageElement;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ParcelableImageElement[] mParcelableImageElements;
    private Context mContext;
    private ProgressBar progressBar;

    public RecyclerViewAdapter(Context context, ParcelableImageElement[] data) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mParcelableImageElements = data;
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

        ParcelableImageElement parcelableImageElement = mParcelableImageElements[position];
        ImageView imageView = holder.imageView;

        Glide.with(mContext)
                .load(parcelableImageElement.getmUrl())
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
                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return mParcelableImageElements.length;
    }


    // stores and recycles views as they are scrolled off screen
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION) {
                ParcelableImageElement parcelableImageElement = mParcelableImageElements[position];
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(DetailActivity.IMAGE_ELEMENT, parcelableImageElement);
                mContext.startActivity(intent);
            }
        }
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    // parent activity implements this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
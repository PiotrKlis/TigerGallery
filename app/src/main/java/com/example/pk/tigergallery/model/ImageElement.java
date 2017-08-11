package com.example.pk.tigergallery.model;

import android.graphics.Bitmap;

/**
 * Created by PK on 11.08.2017.
 */

public class ImageElement {

    private Bitmap bitmap;
    private String metaDataResult;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getMetaDataResult() {
        return metaDataResult;
    }

    public void setMetaDataResult(String metaDataResult) {
        this.metaDataResult = metaDataResult;
    }

    public ImageElement(Bitmap bitmap, String metaDataResult) {
        this.bitmap = bitmap;
        this.metaDataResult = metaDataResult;
    }
}

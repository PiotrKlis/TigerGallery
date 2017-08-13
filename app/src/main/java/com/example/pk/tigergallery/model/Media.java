package com.example.pk.tigergallery.model;

/**
 * Created by PK on 12.08.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("m")
    @Expose
    private String m;

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public Media() {
    }
}

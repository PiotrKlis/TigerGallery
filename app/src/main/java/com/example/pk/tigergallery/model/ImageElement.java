package com.example.pk.tigergallery.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageElement implements Parcelable {

    private String mUrl;
    private String mTitle;
    private String mLink;
    private String mDate_taken;
    private String mDescription;
    private String mPublished;
    private String mAuthor;
    private String mAuthor_id;
    private String mTags;

    public ImageElement(String mUrl, String mTitle, String mLink, String mDate_taken, String mDescription, String mPublished, String mAuthor, String mAuthor_id, String mTags) {
        this.mUrl = mUrl;
        this.mTitle = mTitle;
        this.mLink = mLink;
        this.mDate_taken = mDate_taken;
        this.mDescription = mDescription;
        this.mPublished = mPublished;
        this.mAuthor = mAuthor;
        this.mAuthor_id = mAuthor_id;
        this.mTags = mTags;
    }

    protected ImageElement(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
        mLink = in.readString();
        mDate_taken = in.readString();
        mDescription = in.readString();
        mPublished = in.readString();
        mAuthor = in.readString();
        mAuthor_id = in.readString();
        mTags = in.readString();

    }

    public static final Creator<ImageElement> CREATOR = new Creator<ImageElement>() {
        @Override
        public ImageElement createFromParcel(Parcel in) {
            return new ImageElement(in);
        }

        @Override
        public ImageElement[] newArray(int size) {
            return new ImageElement[size];
        }
    };

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDate_taken() {
        return mDate_taken;
    }

    public void setmDate_taken(String mDate_taken) {
        this.mDate_taken = mDate_taken;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPublished() {
        return mPublished;
    }

    public void setmPublished(String mPublished) {
        this.mPublished = mPublished;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmAuthor_id() {
        return mAuthor_id;
    }

    public void setmAuthor_id(String mAuthor_id) {
        this.mAuthor_id = mAuthor_id;
    }

    public String getmTags() {
        return mTags;
    }

    public void setmTags(String mTags) {
        this.mTags = mTags;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
        parcel.writeString(mLink);
        parcel.writeString(mDescription);
        parcel.writeString(mDate_taken);
        parcel.writeString(mDescription);
        parcel.writeString(mPublished);
        parcel.writeString(mAuthor);
        parcel.writeString(mAuthor_id);
        parcel.writeString(mTags);
    }
}
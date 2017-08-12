package com.example.pk.tigergallery.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableImageElement implements Parcelable {

    private String mUrl;
    private String mTitle;
    private String mLink;
    private String mDate_taken;
    private String mDescription;
    private String mPublished;
    private String mAuthor;
    private String mAuthor_id;
    private String mTags;

    public ParcelableImageElement(String mUrl, String mTitle, String mLink, String mDate_taken,
                                  String mDescription, String mPublished, String mAuthor,
                                  String mAuthor_id, String mTags) {
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

    private ParcelableImageElement(Parcel in) {
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

    public static final Creator<ParcelableImageElement> CREATOR = new Creator<ParcelableImageElement>() {
        @Override
        public ParcelableImageElement createFromParcel(Parcel in) {
            return new ParcelableImageElement(in);
        }

        @Override
        public ParcelableImageElement[] newArray(int size) {
            return new ParcelableImageElement[size];
        }
    };

    public String getmLink() {
        return mLink;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDate_taken() {
        return mDate_taken;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmPublished() {
        return mPublished;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmAuthor_id() {
        return mAuthor_id;
    }

    public String getmTags() {
        return mTags;
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
        parcel.writeString(mDate_taken);
        parcel.writeString(mDescription);
        parcel.writeString(mPublished);
        parcel.writeString(mAuthor);
        parcel.writeString(mAuthor_id);
        parcel.writeString(mTags);
    }
}
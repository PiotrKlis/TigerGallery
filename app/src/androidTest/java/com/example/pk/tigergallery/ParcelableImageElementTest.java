package com.example.pk.tigergallery;

import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;

import com.example.pk.tigergallery.model.ParcelableImageElement;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
@RunWith(AndroidJUnit4.class)

public class ParcelableImageElementTest {

    @Test
    public void isParcelable() {

        ParcelableImageElement element = new ParcelableImageElement("url", "title",
                "link", "date_taken", "description", "published", "author", "author_id",
                "tags");

        Parcel parcel = Parcel.obtain();
        element.writeToParcel(parcel, element.describeContents());
        parcel.setDataPosition(0);

        ParcelableImageElement createdFromParcel = ParcelableImageElement.CREATOR.createFromParcel(parcel);
        Assert.assertEquals(createdFromParcel.getmUrl(), "url");
        Assert.assertEquals(createdFromParcel.getmTitle(), "title");
        Assert.assertEquals(createdFromParcel.getmLink(), "link");
        Assert.assertEquals(createdFromParcel.getmDate_taken(), "date_taken");
        Assert.assertEquals(createdFromParcel.getmDescription(), "description");
        Assert.assertEquals(createdFromParcel.getmPublished(), "published");
        Assert.assertEquals(createdFromParcel.getmAuthor(), "author");
        Assert.assertEquals(createdFromParcel.getmAuthor_id(), "author_id");
        Assert.assertEquals(createdFromParcel.getmTags(), "tags");

    }

}

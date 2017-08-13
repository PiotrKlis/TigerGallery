package com.example.pk.tigergallery;

import com.example.pk.tigergallery.model.FlickrFeed;
import com.example.pk.tigergallery.model.ImageItem;
import com.example.pk.tigergallery.model.Media;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by PK on 13.08.2017.
 */

public class FlickrFeedTest extends TestCase{

    private FlickrFeed flickrFeed;

    protected void setUp() throws Exception {
        super.setUp();
        flickrFeed = new FlickrFeed();
    }

   public void testGetTitle() {

       String expected = RandomStringGenerator.random();
       flickrFeed.setTitle(expected);
       String actual = flickrFeed.getTitle();
       Assert.assertEquals(expected, actual);

   }

    public void testGetLink() {

        String expected = RandomStringGenerator.random();
        flickrFeed.setLink(expected);
        String actual = flickrFeed.getLink();
        Assert.assertEquals(expected, actual);

    }

    public void testGetDescription() {

        String expected = RandomStringGenerator.random();
        flickrFeed.setDescription(expected);
        String actual = flickrFeed.getDescription();
        Assert.assertEquals(expected, actual);

    }

    public void testGetModified() {

        String expected = RandomStringGenerator.random();
        flickrFeed.setModified(expected);
        String actual = flickrFeed.getModified();
        Assert.assertEquals(expected, actual);

    }

    public void testGetGenerator() {

        String expected = RandomStringGenerator.random();
        flickrFeed.setGenerator(expected);
        String actual = flickrFeed.getGenerator();
        Assert.assertEquals(expected, actual);

    }
}

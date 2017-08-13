package com.example.pk.tigergallery;

import com.example.pk.tigergallery.model.ImageItem;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by PK on 13.08.2017.
 */

public class ImageItemTest extends TestCase {

    private ImageItem imageItem;

    protected void setUp() throws Exception {
        super.setUp();
        imageItem = new ImageItem();
    }

    public void testTitle() {

        String expected = RandomStringGenerator.random();
        imageItem.setTitle(expected);
        String actual = imageItem.getTitle();
        Assert.assertEquals(expected, actual);

    }

    public void testLink() {

        String expected = RandomStringGenerator.random();
        imageItem.setLink(expected);
        String actual = imageItem.getLink();
        Assert.assertEquals(expected, actual);

    }

    public void testDateTaken() {

        String expected = RandomStringGenerator.random();
        imageItem.setDateTaken(expected);
        String actual = imageItem.getDateTaken();
        Assert.assertEquals(expected, actual);

    }

    public void testDescription() {

        String expected = RandomStringGenerator.random();
        imageItem.setDescription(expected);
        String actual = imageItem.getDescription();
        Assert.assertEquals(expected, actual);

    }

    public void testPublished() {

        String expected = RandomStringGenerator.random();
        imageItem.setPublished(expected);
        String actual = imageItem.getPublished();
        Assert.assertEquals(expected, actual);

    }

    public void testAuthor() {

        String expected = RandomStringGenerator.random();
        imageItem.setAuthor(expected);
        String actual = imageItem.getAuthor();
        Assert.assertEquals(expected, actual);

    }

    public void testAuthorId() {

        String expected = RandomStringGenerator.random();
        imageItem.setAuthorId(expected);
        String actual = imageItem.getAuthorId();
        Assert.assertEquals(expected, actual);

    }

    public void testTags() {

        String expected = RandomStringGenerator.random();
        imageItem.setTags(expected);
        String actual = imageItem.getTags();
        Assert.assertEquals(expected, actual);

    }
}

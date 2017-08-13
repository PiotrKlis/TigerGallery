package com.example.pk.tigergallery;


import com.example.pk.tigergallery.model.Media;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by PK on 13.08.2017.
 */

public class MediaTest extends TestCase{

    private Media media;

    protected void setUp() throws Exception {
        super.setUp();
        media = new Media();
    }

    public void testMedia() {
        String expected = RandomStringGenerator.random();
        media.setM(expected);
        String actual = media.getM();
        Assert.assertEquals(expected, actual);
    }

}

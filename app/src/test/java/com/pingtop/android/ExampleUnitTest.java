package com.pingtop.android;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getPath(){
        String path = File.separator + "data" + File.separator +  File.separator + "databases";
        System.out.println(path);
    }

}
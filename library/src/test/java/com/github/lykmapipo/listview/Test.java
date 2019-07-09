package com.github.lykmapipo.listview;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class Test {
    Context context;

    @Before
    public void setup() {
        context = ApplicationProvider.getApplicationContext();
    }

    @org.junit.Test
    public void testShouldProvideValuePicker() {
        assertNotNull("Should provide value picker", 1l);
    }

    @After
    public void cleanup() {
        context = null;
    }

}
package com.beamon.hackathongrinda2015;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 19, constants = BuildConfig.class, manifest = "src/main/AndroidManifest.xml")
public class ApplicationTest {

    public ApplicationTest() {
    }

    @Test
    public void testSomething(){
        Activity activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();
    }
}
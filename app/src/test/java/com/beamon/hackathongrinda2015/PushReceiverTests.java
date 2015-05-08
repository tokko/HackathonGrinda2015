package com.beamon.hackathongrinda2015;

import android.content.Context;
import android.content.Intent;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = Config.NONE, emulateSdk = 19)
public class PushReceiverTests {

    public void testReceive(){
        Context context = ShadowApplication.getInstance().getApplicationContext();
        Intent intent = new Intent(context, PushReceiver.class);
        new PushReceiver().onReceive(ShadowApplication.getInstance().getApplicationContext(), intent);
    }
}

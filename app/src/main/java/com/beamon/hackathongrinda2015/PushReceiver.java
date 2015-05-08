package com.beamon.hackathongrinda2015;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by andre_000 on 2015-05-08.
 */
public class PushReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        builder.setContentTitle("PUSH NOTIFICATION RECEIVED!!!!11111onelen");
        builder.setContentText("");
    }
}

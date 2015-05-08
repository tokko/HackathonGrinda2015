package com.beamon.hackathongrinda2015;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created by andre_000 on 2015-05-08.
 */
public class PushReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {  // has effect of unparcelling Bundle
            /*
             * Filter messages based on message type. Since it is likely that GCM
             * will be extended in the future with new message types, just ignore
             * any message types you're not interested in, or that you don't
             * recognize.
             */
            if (GoogleCloudMessaging.
                    MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                //sendNotification("Send error: " + extras.toString());
            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_DELETED.equals(messageType)) {
              //  sendNotification("Deleted messages on server: " +
             //           extras.toString());
                // If it's a regular GCM message, do some work.
            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                // This loop represents the service doing some work.
                Notification.Builder builder = new Notification.Builder(context);
                builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
                builder.setContentTitle("PUSH NOTIFICATION RECEIVED!!!!11111onelen");
                builder.setContentText(extras.toString());
                Intent cuddleIntent = new Intent(context.getApplicationContext(), CuddleActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent cuddlePendingIntent = PendingIntent.getActivity(context.getApplicationContext(), 0, cuddleIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(cuddlePendingIntent);
                Log.i("Receiver", "Received: " + extras.toString());
                Notification m = builder.build();
                ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, m);
            }
        }
        // Release the wake lock provided by the WakefulBroadcastReceiver.
    }


}


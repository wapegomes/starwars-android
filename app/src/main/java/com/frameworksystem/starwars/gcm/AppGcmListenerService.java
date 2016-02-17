package com.frameworksystem.starwars.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.Droid;
import com.frameworksystem.starwars.ui.activity.DroidDetailActivity;
import com.frameworksystem.starwars.ui.activity.MainActivity;
import com.google.android.gms.gcm.GcmListenerService;
import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by felipe.arimateia on 12/8/2015.
 */
public class AppGcmListenerService extends GcmListenerService {


    private static final String TAG = "MyGcmListenerService";

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs.
     *             For Set of keys use data.keySet().
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(String from, Bundle data) {
        String content = data.getString("content");
        String type = data.getString("type");

        Log.d(TAG, "From: " + from);
        Log.d(TAG, "Content: " + content);

        Serializable object = paserJson(type, content);

        Intent intent = null;
        String message = "";

        if (object instanceof Droid) {
            Droid droid = (Droid)object;
            message = "O droid " + droid.getName() + " foi cadastrado.";
            intent = new Intent(this, DroidDetailActivity.class);
        }
        else {
            intent = new Intent(this, MainActivity.class);
        }

        intent.putExtra(type, object);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        sendNotification(type, message, intent);

        // [END_EXCLUDE]
    }

    // [END receive_message]

    /**
     * Create and show a simple notification containing the received GCM message.
     *
     * @param message GCM message received.
     */
    private void sendNotification(String type, String message, Intent intent) {

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }


    private Serializable paserJson(String type, String json) {
        Gson gson = new Gson();

        switch (type) {
            case "droid":
                return gson.fromJson(json, Droid.class);
        }

        return null;
    }
}

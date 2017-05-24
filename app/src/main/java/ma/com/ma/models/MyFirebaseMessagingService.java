package ma.com.ma.models;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Steph on 23/05/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{
     public static final String TAG = "Noticias";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
       super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje de: " + from);
        if(remoteMessage.getNotification() != null){
            Log.d(TAG, "notificacion: " + remoteMessage.getNotification().getBody());
        }
    }
}

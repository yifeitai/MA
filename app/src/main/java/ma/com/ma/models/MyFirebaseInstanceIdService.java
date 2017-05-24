package ma.com.ma.models;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Steph on 23/05/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {
      super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();

        Log.d(MyFirebaseMessagingService.TAG, "token: " + token);

    }
}

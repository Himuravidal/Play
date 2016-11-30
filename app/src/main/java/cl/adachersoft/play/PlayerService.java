package cl.adachersoft.play;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class PlayerService extends Service {

    private final IBinder binder = new LocalBinder();

    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return binder;
    }


    public class LocalBinder extends Binder {
        public PlayerService getService() {
            return PlayerService.this;
        }
    }


    public void setSongs(){

        for (int i = 0; i <100 ; i++) {

            Log.d("SONGS",String.valueOf(i));


        }


    }


}

package cl.adachersoft.play;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    private PlayerService playerService;
    private ServiceConnection serviceConnection;
    private boolean isBound = false;
    private TextView tittleHolder;

    private void bindToPlayer() {
        Intent intent = new Intent(this, PlayerService.class);
        serviceConnection = getServiceConnection();
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection getServiceConnection() {
        return new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                PlayerService.LocalBinder binder = (PlayerService.LocalBinder) service;
                playerService = binder.getService();
                playerService.setSongs();
                isBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound = false;
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindToPlayer();
        tittleHolder = (TextView) findViewById(R.id.songNameTv);

    }


    public void ClickPlays(View view) {


    }


}

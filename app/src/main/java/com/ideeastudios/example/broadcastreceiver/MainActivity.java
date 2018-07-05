package com.ideeastudios.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConnectivityChangeReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate the Broadcast Receiver here.
        receiver = new ConnectivityChangeReceiver();

        //register the Broadcast Receiver on application onCreate.
        registerReceiver(receiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        Toast.makeText(this, "Broadcast Receiver registered!", Toast.LENGTH_LONG).show();
        Log.i("BROADCAST", "Broadcast Receiver registered!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregister the Broadcast Receiver when the app is destroyed.
        unregisterReceiver(receiver);
        Toast.makeText(this, "Broadcast Receiver unregistered!", Toast.LENGTH_LONG).show();
        Log.i("BROADCAST", "Broadcast Receiver unregistered!");
    }

}

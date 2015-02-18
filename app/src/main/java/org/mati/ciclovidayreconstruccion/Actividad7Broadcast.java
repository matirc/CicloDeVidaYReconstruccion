package org.mati.ciclovidayreconstruccion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Actividad7Broadcast extends BroadcastReceiver {

    public Actividad7Broadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,intent.getStringExtra("message"),
        Toast.LENGTH_LONG).show();
    }
}

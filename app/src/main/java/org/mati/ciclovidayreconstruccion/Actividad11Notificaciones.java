package org.mati.ciclovidayreconstruccion;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import java.util.Timer;
import java.util.TimerTask;


public class Actividad11Notificaciones extends Activity {

    private final int NOTIFICATION_ID = 1010;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad11_notificaciones);
        boton = (Button)findViewById(R.id.button1);

        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        notificacion();
                    }
                };
                timer.schedule(timerTask, 1000);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad11_notificaciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void notificacion(){

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.ic_launcher, "Notificacion!", System.currentTimeMillis());

        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.activity_actividad11_notificacion);
        contentView.setImageViewResource(R.id.img_notification, R.drawable.ic_launcher);
        contentView.setTextViewText(R.id.txt_notification, "Mensaje de la notificacion!");

        notification.contentView = contentView;

        Intent notificationIntent = new Intent(this, Actividad11Notificacion.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        notification.contentIntent = contentIntent;

        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}



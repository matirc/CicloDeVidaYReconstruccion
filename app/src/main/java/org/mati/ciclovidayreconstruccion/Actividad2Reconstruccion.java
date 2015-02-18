package org.mati.ciclovidayreconstruccion;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Actividad2Reconstruccion extends Activity {

    int numero, numVeces;
    Button BotonPulsame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            numero = savedInstanceState.getInt("numVeces");
        } else {
            numVeces = 0;
            numero = 0;
        }

        setContentView(R.layout.activity_pulsame);

        BotonPulsame = (Button)findViewById(R.id.BotonPulsame);
        BotonPulsame.setText(getResources().getQuantityString(R.plurals.VecesPulsado, numero, numero));

        BotonPulsame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero++;
                BotonPulsame.setText(v.getResources().getQuantityString(R.plurals.VecesPulsado, numero, numero));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pulsame, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("numVeces", numero);
        super.onSaveInstanceState(savedInstanceState);
    }
}

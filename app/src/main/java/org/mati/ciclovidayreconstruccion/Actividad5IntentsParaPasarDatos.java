package org.mati.ciclovidayreconstruccion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Actividad5IntentsParaPasarDatos extends Activity {

    String str2 = "";
    int int2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad5_intents_para_pasar_datos);

        //Bundle b = getIntent().getExtras();

        //if (b.getString("str2")!=null){
        //    str2 = b.getString(str2);
        //    Toast.makeText(getApplicationContext(), str2, Toast.LENGTH_LONG).show();
        //}

        //if (b.getInt("int1")!=0){
        //    int2 = b.getInt("int1");
        //    Toast.makeText(getApplicationContext(), int2, Toast.LENGTH_LONG).show();
        //}

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad5_intents_para_pasar_datos, menu);
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

    public void Pulsame(View view) {

        Intent intent = new Intent(this, Actividad5IntentsParaPasarDatos_b.class);
        intent.putExtra("str1", "Hola, vengo de la actividad5 principal");
        intent.putExtra("num1", 0);
        startActivity(intent);
    }
}

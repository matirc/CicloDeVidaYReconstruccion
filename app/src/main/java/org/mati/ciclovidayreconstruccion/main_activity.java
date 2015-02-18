package org.mati.ciclovidayreconstruccion;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class main_activity extends ListActivity {

    private String practicas[] = {
            "Actividad1CicloDeVida",
            "Actividad2Reconstruccion",
            "Actividad3Intents",
            "Actividad4DevolverResultadosIntents",
            "Actividad5IntentsParaPasarDatos",
            "Actividad6IntentsImplicitos",
            "Actividad7BroadcastReceiver",
            "PublicacionBlogListActivity",
            "Actividad9Fragments",
            "Actividad10VentanaProggresBar",
            "Actividad11Notificaciones"};

    final static String TAG = main_activity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, practicas);

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView lista, View vista, int posicion, long id){
        super.onListItemClick(lista, vista, posicion, id);
        // guardamos el nombre de la actividad seleccionada
        String nombrePractica = practicas[posicion];
        try{
            Class<?> clase = Class.forName("org.pat.ciclodevidayreconstruccion." + nombrePractica);
            Intent intent = new Intent(this,clase);
            startActivity(intent);
        }
        catch(ClassNotFoundException e){
            Log.e(TAG,"Actividad no creada: ",e);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }
}

package org.mati.ciclovidayreconstruccion;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Actividad6IntentsImplicitos extends Activity {

    Intent intent;
    final float latitud = 40.3736f;
    final float longitud = -3.919848f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6_intents_implicitos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad6_intents_implicitos, menu);
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

    public void WebBrowser(View view) {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uem.es/"));
        startActivity(intent);
    }

    public void Call(View view) {
        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:902232350"));
        startActivity(intent);
    }

    public void ShowMap(View view) {
        String url = String.format("geo:%f, %f", latitud, longitud);
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}

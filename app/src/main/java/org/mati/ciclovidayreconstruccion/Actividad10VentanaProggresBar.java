package org.mati.ciclovidayreconstruccion;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;


public class Actividad10VentanaProggresBar extends Activity {

    ProgressDialog progressDialog;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad10_ventana_proggres_bar);

        // Barra de progreso instanciada
        spinner = (ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
    }

    //  Muestro o no la Progress Bar Circular de id progressBar
    public void load(View button) {
        if(spinner.getVisibility()== View.VISIBLE)
            spinner.setVisibility(View.INVISIBLE);
        else
            spinner.setVisibility(View.VISIBLE);
    }

    // Cuadro de dialogo con Proggres Bar Circular
    public void progressDialog(View button) {
        final ProgressDialog dialog = ProgressDialog.show(this, "Haciendo algo", "Por favor espere...", true);
        new Thread(new Runnable() {
            public void run() {
                try {
                    // Espero 5 segundos
                    Thread.sleep(5000);
                    // Cierro el cuadro de dialogo
                    dialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    // Cuadro de dialogo con barra de progreso horizontal, Ok y Cancel
    public void openProgressDialog(View button) {
        progressDialog = createProgressDialog();
        progressDialog.show();
        progressDialog.setProgress(0);
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    try {
                        // Espero 1 segundo
                        Thread.sleep(1000);
                        // E incremento la barra
                        progressDialog.incrementProgressBy((int) (100 / 15));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Cierro el cuadro de dialogo
                progressDialog.dismiss();
            }
        }).start();
    }


    // Clase customizada
    ProgressDialog createProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.drawable.ic_launcher);
        progressDialog.setTitle("Bajando ficheros...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        // Botones y Listeners para mostrar un toast indicando que se ha pulsado
        // Boton OK
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(android.R.string.ok),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Ok pulsado!", Toast.LENGTH_SHORT).show();
                    }
                });

        // Boton Cancel
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(android.R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel pulsado!", Toast.LENGTH_SHORT).show();
                    }
                });

        return progressDialog;
    }
}

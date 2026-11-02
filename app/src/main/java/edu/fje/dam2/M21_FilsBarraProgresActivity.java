package edu.fje.dam2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que hereta de la classe Activity i que treballa amb Fils
 * El layout XML conté una barra de progrès. La IU s'executa en un fil
 * i el mètode onStart és invocat per aquesta per actualitzar els
 * components que mostra.
 * Handler és una classe que té l'API d'Android per a gestionar de manera
 * senzilla fils (1 per activitat)
 * @author sergi.grau@fje.edu
 * @version 1.0, 29/11/2012
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M21_FilsBarraProgresActivity extends AppCompatActivity {

    ProgressBar barraProgress;
    boolean isExecutant = false;
    Handler handler = new Handler(Looper.getMainLooper()) {
    /**
     * Mètode que es crida cada vegada que Handler rep un missatge
     */
        @Override
        public void handleMessage(Message msg) {
            barraProgress.incrementProgressBy(5);
          
        }
    };

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.m21_fils_barra_progres);
        barraProgress = findViewById(R.id.barraProgres);
    }
    
    @Override
    public void onStart() {
        super.onStart();
        barraProgress.setProgress(0);

        Thread background = new Thread(() -> {
            try {
                for (int i = 0; i < 20 && isExecutant; i++) {
                    Thread.sleep(1000);
                    //posa un missatge a la cua. obtainMessage obté un
                    //obj de classe Message per a poder-ho enviar com
                    //a missatge
                    handler.sendMessage(handler.obtainMessage());
                   
                }
            } catch (Throwable t) {
            }
        });
        isExecutant = true;
        background.start();
    }
    @Override
    public void onStop() {
        super.onStop();
        isExecutant = false;
    }
}

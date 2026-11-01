package edu.fje.dam2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que hereta de la classe Activity i que
 * mostra com podem treballar amb subactivitats. En aquest
 * cas mostra les dades en un Google Maps
 *
 * @author sergi.grau@fje.edu
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */

public class M22_GoogleMapsActivity extends AppCompatActivity {
    private EditText lat;
    private EditText lng;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.m22_google_maps);

        Button btn = findViewById(R.id.mapa);
        lat = findViewById(R.id.lat);
        lng = findViewById(R.id.lng);

        btn.setOnClickListener(view -> {
            var _lat = lat.getText().toString();
            var _lon = lng.getText().toString();
            var uri = Uri.parse("geo:" + _lat + "," + _lon);

            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        });
    }
}
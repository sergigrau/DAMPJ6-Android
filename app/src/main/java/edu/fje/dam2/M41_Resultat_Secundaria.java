package edu.fje.dam2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que demostra el retorn de dades des d'una activitat a una altra
 *
 * @author sergi.grau@fje.edu
 * @version 2.0 19.01.2016
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */

public class M41_Resultat_Secundaria extends AppCompatActivity {

    int res=0;
    private TextView resultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m41_secundaria_activity);

        var intent = getIntent();
        for (int n: intent.getIntegerArrayListExtra("nombres")){
            res+=n;
        }

        resultat = findViewById(R.id.resultat);
        resultat.setText(String.valueOf(res));

        var returnIntent = new Intent();
        returnIntent.putExtra("resultat",String.valueOf(res));

        setResult(M41_Resultat_Principal.RESULT_OK,returnIntent);
        finish();


    }
}

package edu.fje.dam2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Classe que demostra el retorn de dades des d'una activitat a una altra
 *
 * @author sergi.grau@fje.edu
 * @version 2.0 19.01.2016
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M41_Resultat_Principal extends AppCompatActivity {

    private Button suma;
    private ArrayList<Integer> nombres = new ArrayList<>();
    private EditText n1, n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m41_activity_principal);
        suma = findViewById(R.id.suma);

        suma.setOnClickListener(view -> {

            n1 = findViewById(R.id.n1);
            n2 = findViewById(R.id.n2);
            nombres.add(Integer.parseInt(n1.getText().toString()));
            nombres.add(Integer.parseInt(n2.getText().toString()));

            var intent = new Intent(getApplicationContext(),
                    M41_Resultat_Secundaria.class);

            intent.putIntegerArrayListExtra("nombres", nombres);
            startActivityForResult(intent,1);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                suma.setText(data.getStringExtra("resultat"));
            }
        }
    }

}

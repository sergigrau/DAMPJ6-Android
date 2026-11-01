package edu.fje.dam2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que hereta de la classe Activity i implementa
 * la interfície OnCheckedChangeListener continguda a la classe CompoundButton
 * Utilitza un layout XML per a definir la interfície i mostra diversos
 * botons de radio
 * @author sergi.grau@fje.edu
 * @version 1.0, 06/11/2012
 * @version 2.0, 1/10/2020, actualització a API.30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M07_BotonsRadioActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m07_botons_radio);
        rb1 = findViewById(R.id.radio1);
        rb1.setOnCheckedChangeListener(this);
        rb2 = findViewById(R.id.radio2);
        rb2.setOnCheckedChangeListener(this);
        rb3 = findViewById(R.id.radio3);
        rb3.setOnCheckedChangeListener(this);
    }
    
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            buttonView.setText("el radio està marcat");
        } else {
            buttonView.setText("el radio està desmarcat");
        }
    }
}



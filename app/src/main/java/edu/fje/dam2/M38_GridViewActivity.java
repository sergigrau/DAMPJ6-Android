package edu.fje.dam2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activitat que mostra el funcionament d'un GridView 
 * @author Sergi Grau (sergi.grau@fje.edu)
 * @version 1.0 6.12.2014
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 *
 */
public class M38_GridViewActivity extends AppCompatActivity {
 
	GridView gridView;
 
	static final String[] numbers = new String[] { 
			"A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z"};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.m38_gridview);
 
		gridView = findViewById(R.id.gridView1);
 
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, numbers);
 
		gridView.setAdapter(adapter);
 
		gridView.setOnItemClickListener((parent, v, position, id) -> Toast.makeText(getApplicationContext(),
		   ((TextView) v).getText(), Toast.LENGTH_SHORT).show());
 
	}
 
}
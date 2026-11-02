package edu.fje.dam2;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que utilitza una llista de la qual l'usuari pot seleccionar diversos
 * items. Utilitza un ArrayAdapter que permet utilitzar el patró MVC
 *
 * @author sergi.grau@fje.edu
 * @version 1.0, 19.10.2015
 * @version 2.0, 1/10/2020, actualització a API.30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M14_ListActivityIntentActivity extends AppCompatActivity {

	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		String[] items = getResources().getStringArray(R.array.fruites);

		adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_multiple_choice, items);

		var listView = new ListView(this);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener((parent, v, position, id) -> {
			SparseBooleanArray checked = listView.getCheckedItemPositions();
			var itemsSeleccionats = new ArrayList<String>();
			for (int i = 0; i < checked.size(); i++) {
				int pos = checked.keyAt(i);
				if (checked.valueAt(i))
					itemsSeleccionats.add(adapter.getItem(pos));
			}

			var intent = new Intent(getApplicationContext(),
					M14_ListActivityIntentDepenentActivity.class);

			var b = new Bundle();
			b.putStringArrayList("itemsSeleccionats", itemsSeleccionats);

			intent.putExtras(b);

			startActivity(intent);
		});

		setContentView(listView);
	}
}

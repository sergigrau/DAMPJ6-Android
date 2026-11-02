package edu.fje.dam2;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que mostra com funcionen els menus emergents. El menu permet modificar
 * la distància entre els ítems de la llista.
 * Utilitza un layout XML per a definir la interfície.
 *
 * @author sergi.grau@fje.edu
 * @version 1.0, 29/11/2012
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M20_MenusEmergentsActivity extends AppCompatActivity {

    private TextView seleccio;
    private ListView listView;
    private String[] items = {"pomes", "peres", "taronges", "plàtans", "pinyes"};
    public static final int id1 = Menu.FIRST + 1;
    public static final int id2 = Menu.FIRST + 2;
    public static final int id8 = Menu.FIRST + 3;
    public static final int id16 = Menu.FIRST + 4;
    public static final int id24 = Menu.FIRST + 5;
    public static final int id32 = Menu.FIRST + 6;
    public static final int id40 = Menu.FIRST + 7;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.m20_menus_emergents);
        listView = findViewById(android.R.id.list);
        seleccio = findViewById(R.id.seleccio);

        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items));

        listView.setOnItemClickListener((parent, v, position, id) -> seleccio.setText(items[position]));

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenu.ContextMenuInfo menuInfo) {
        omplirMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        omplirMenu(menu);

        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return (escollirMenu(item)
                || super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return (escollirMenu(item)
                || super.onContextItemSelected(item));
    }

    private void omplirMenu(Menu menu) {
        menu.add(Menu.NONE, id1, Menu.NONE, "1 Pixel");
        menu.add(Menu.NONE, id2, Menu.NONE, "2 Pixels");
        menu.add(Menu.NONE, id8, Menu.NONE, "8 Pixels");
        menu.add(Menu.NONE, id16, Menu.NONE, "16 Pixels");
        menu.add(Menu.NONE, id24, Menu.NONE, "24 Pixels");
        menu.add(Menu.NONE, id32, Menu.NONE, "32 Pixels");
        menu.add(Menu.NONE, id40, Menu.NONE, "40 Pixels");
    }

    private boolean escollirMenu(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == id1) { listView.setDividerHeight(1); return true; }
        if (itemId == id2) { listView.setDividerHeight(2); return true; }
        if (itemId == id8) { listView.setDividerHeight(8); return true; }
        if (itemId == id16) { listView.setDividerHeight(16); return true; }
        if (itemId == id24) { listView.setDividerHeight(24); return true; }
        if (itemId == id32) { listView.setDividerHeight(32); return true; }
        if (itemId == id40) { listView.setDividerHeight(40); return true; }

        return false;
    }
}

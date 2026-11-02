package edu.fje.dam2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

/**
 * Classe que mostra com utilitzar un giny de pestanyes modern amb TabLayout.
 *
 * @author sergi.grau@fje.edu
 * @version 1.0, 26/11/2012
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M19_TabsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        setContentView(R.layout.m19_tabs);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        View tab1 = findViewById(R.id.tab1);
        Button tab2 = findViewById(R.id.tab2);

        tabLayout.addTab(tabLayout.newTab().setText("Rellotge"));
        tabLayout.addTab(tabLayout.newTab().setText("Botó"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    tab1.setVisibility(View.VISIBLE);
                    tab2.setVisibility(View.GONE);
                } else {
                    tab1.setVisibility(View.GONE);
                    tab2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}

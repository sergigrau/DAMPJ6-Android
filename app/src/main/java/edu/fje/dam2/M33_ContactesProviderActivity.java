package edu.fje.dam2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Classe Activity que hereta de AppCompatActivity i que accedeix mitjançant un
 * proveïdor de contingut als contactes d'Android
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 20/11/2013
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M33_ContactesProviderActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }

        Cursor mCursor = obtenirContactes();

        ListAdapter adaptador = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item, mCursor, new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME}, new int[]{
                android.R.id.text1, android.R.id.text2},
                CursorAdapter.NO_SELECTION);

        var listView = new ListView(this);
        listView.setAdapter(adaptador);
        setContentView(listView);
    }

    private Cursor obtenirContactes() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projeccio = new String[]{ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME};

        return getContentResolver().query(uri, projeccio, null, null, null);
    }

}

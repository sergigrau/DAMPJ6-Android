package edu.fje.dam2;

import android.app.ActionBar.LayoutParams;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

/**
 * Classe que demostra el funcionament de l'accés als contactes mitjançant un
 * loader
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 26/12/2013
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 * 
 */
public class M25_LoaderMilloratActivity extends AppCompatActivity implements
		LoaderManager.LoaderCallbacks<Cursor> {

	SimpleCursorAdapter mAdapter;
	private ListView listView;

	static final String[] PROJECCIO = new String[] {
			ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME };

	static final String SELECCIO = "((" + ContactsContract.Data.DISPLAY_NAME
			+ " NOTNULL) AND (" + ContactsContract.Data.DISPLAY_NAME
			+ " != '' ))";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		listView = new ListView(this);

		ProgressBar progressBar = new ProgressBar(this);
		progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, Gravity.CENTER));
		progressBar.setIndeterminate(true);
		listView.setEmptyView(progressBar);

		ViewGroup root = findViewById(android.R.id.content);
		root.addView(progressBar);

		String[] columnesOrigen = { ContactsContract.Data.DISPLAY_NAME };
		int[] vista = { android.R.id.text1 };

		mAdapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, null, columnesOrigen,
				vista, 0);
		listView.setAdapter(mAdapter);

		setContentView(listView);

		LoaderManager.getInstance(this).initLoader(0, null, this);
	}

	@NonNull
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		return new CursorLoader(this, ContactsContract.Data.CONTENT_URI,
                PROJECCIO, SELECCIO, null, null);
	}

	@Override
	public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
		mAdapter.swapCursor(data);
	}

	@Override
	public void onLoaderReset(@NonNull Loader<Cursor> loader) {
		mAdapter.swapCursor(null);
	}
}

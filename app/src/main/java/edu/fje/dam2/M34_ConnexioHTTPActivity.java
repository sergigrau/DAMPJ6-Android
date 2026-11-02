package edu.fje.dam2;

import java.net.*;
import java.io.*;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.StrictMode;
import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que utilitza la classe HTTPURLConnection, per a enviar i rebre dades d'Internet.
 * S'utilitza quan no es coneix la longitud de les dades a enviar i rebre
 * @author sergi.grau@fje.edu
 * @version 1.0 4/04/2013
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */
public class M34_ConnexioHTTPActivity extends AppCompatActivity {

	private TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m34_connexio_http);
		text = findViewById(R.id.text);
		
		//per evitar que el fil de la GUI tingui ocupada la comunicació
		//caldria millorar-ho amb un servei
		StrictMode.ThreadPolicy politiques = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
		StrictMode.setThreadPolicy(politiques);

		try {
			URL url = new URL("http://www.google.com");
			HttpURLConnection connexio = (HttpURLConnection) url.openConnection();
			llegirStream(connexio.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void llegirStream(InputStream in) {
		try (var reader = new BufferedReader(new InputStreamReader(in))) {
			String linia;
			var linies = new StringBuilder();
			
			while ((linia = reader.readLine()) != null) {
				linies.append(linia);
			}
			text.setText(linies.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public boolean isXarxaDisponible() {
		var cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm != null) {
			var activeNetwork = cm.getActiveNetwork();
			if (activeNetwork != null) {
				var caps = cm.getNetworkCapabilities(activeNetwork);
				return caps != null && (caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
						|| caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
						|| caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
			}
		}
		return false;
	}

}

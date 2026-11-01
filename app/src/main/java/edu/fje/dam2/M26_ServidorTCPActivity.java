package edu.fje.dam2;

import java.io.*;
import java.net.*;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;
/**
 * Activitat que definieix un servidor
 * mitjançant sòcols i el protocol TCP
 *
 * cal activar el bridfe de ADB
 * adb -s emulator-5554 forward tcp:12345 tcp:12345
 * @author sergi.grau@fje.edu
 * @version 1.0 9.01.2015
 * @version 2.0, 1/11/2026 actualització a API36
 */

public class M26_ServidorTCPActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy politiques = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(politiques);

		String res = "ERROR";
		try (var ss = new ServerSocket(12345)) {
			Log.i(M26_ServidorTCPActivity.class.getName(), "Esperant a client...");

			try (var s = ss.accept();
				 var out = new PrintWriter(s.getOutputStream(), true);
				 var in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
				Log.i(M26_ServidorTCPActivity.class.getName(), "S: Client connectat" + s);
				res = in.readLine();
				Log.i(M26_ServidorTCPActivity.class.getName(), "PONG" + res);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		var tv = new TextView(this);
		tv.setText("S: " + res);
		setContentView(tv);
	}

}

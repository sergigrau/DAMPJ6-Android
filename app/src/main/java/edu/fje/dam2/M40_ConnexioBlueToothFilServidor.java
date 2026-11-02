package edu.fje.dam2;

import java.io.IOException;
import java.util.UUID;

import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;

/**
 * Classe que demostra el funcionament de les comunicacions amb Bluetooth.
 * Hereta de Fil per a implementar un server socket. Accepta connexions entrants
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 19/01/2014
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */

public class M40_ConnexioBlueToothFilServidor extends Thread {

	    private final BluetoothServerSocket mmServerSocket;

	    public M40_ConnexioBlueToothFilServidor(Context context) {
	       
	        BluetoothServerSocket tmp = null;
	        try {
	        	UUID uuid = UUID.fromString("00001000-0000-1000-8000-00805f9b34fb");
				var manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
				var adaptadorBT = manager != null ? manager.getAdapter() : null;
				if (adaptadorBT != null) {
					tmp = adaptadorBT.listenUsingRfcommWithServiceRecord("dam2", uuid);
				}
	        } catch (IOException e) { }
	        mmServerSocket = tmp;
	    }
	 
	    public void run() {
	        BluetoothSocket socket = null;
	        while (true) {
	            try {
	                socket = mmServerSocket.accept();
	            } catch (IOException e) {
	                break;
	            }
	            //si una connexio es acceptada
	            if (socket != null) {
	               //caldria crear un fil per a gestionar la comunicació d'entrada
	            	
	                try {
						mmServerSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	                break;
	            }
	        }
	    }
	 
	    public void cancel() {
	        try {
	            mmServerSocket.close();
	        } catch (IOException e) { }
	    }
	
}

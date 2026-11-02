package edu.fje.dam2;

import java.lang.reflect.Method;
import java.util.Set;

import android.os.Build;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que demostra el funcionament de les comunicacions amb Bluetooth,
 * connetant per BT un dispositiu NXT i enviant el codi LPC per a reproduir un so
 *
 * @author sergi.grau@fje.edu
 * @version 2.0 19.01.2016
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 2.0, 1/11/2026 actualització a API36
 */

public class M40_ConnexioBluetooth extends AppCompatActivity {

    private final int OBTENCIO_BT = 1;

    // broadcast per a descobrir dispositius
    private final BroadcastReceiver receptorBroadcast = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String accio = intent.getAction();
            // Quan trobem un dispositiu
            if (BluetoothDevice.ACTION_FOUND.equals(accio)) {
                // recuperem l'objecte corresponent al dispositiu
                BluetoothDevice dispositiu;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    dispositiu = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE, BluetoothDevice.class);
                } else {
                    dispositiu = getParcelableLegacy(intent);
                }

                if (dispositiu != null) {
                    Log.i(getClass().getName(), "descobert dispositiu" +
                            dispositiu.getName() + " amb MAC "
                            + dispositiu.getAddress());
                }
            }
        }
    };

    @SuppressWarnings("deprecation")
    private BluetoothDevice getParcelableLegacy(Intent intent) {
        return intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m40_connexio_bluetooth);

        var manager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter adaptadorBT = manager != null ? manager.getAdapter() : null;

        if (adaptadorBT == null) {
            Toast.makeText(this, "Bluetooth no suportat", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        // activa BT
        if (!adaptadorBT.isEnabled()) {
            Intent intentActivarBT = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intentActivarBT, OBTENCIO_BT);
        }
        // defineix el temps que està en descobriment per a altres dispositius
        Intent intentDescobrimentBT = new Intent(
                BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        intentDescobrimentBT.putExtra(
                BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(intentDescobrimentBT);

        // dispositius amb els que esta aparellat
        Set<BluetoothDevice> dispositiusAparellats = adaptadorBT
                .getBondedDevices();

        //recuperem el mètode de la classe BT mitjançant tècniques reflexives
        Method obtenirUUIDS = null;
        try {
            obtenirUUIDS = BluetoothAdapter.class.getDeclaredMethod("getUuids", (Class<?>[]) null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ParcelUuid[] uuids = null;
        if (obtenirUUIDS != null) {
            try {
                uuids = (ParcelUuid[]) obtenirUUIDS.invoke(adaptadorBT, (Object[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (uuids != null) {
            for (ParcelUuid uuid : uuids) {
                Log.i(getClass().getName(), "UUID registrades: " + uuid.getUuid().toString());
            }
        }

        if (dispositiusAparellats != null && dispositiusAparellats.size() > 0) {
            // mostra informació dels dispositius amb els que està aparellat
            for (BluetoothDevice dispositiu : dispositiusAparellats) {
                Log.i(getClass().getName(), "dispositiu registrat " +
                        dispositiu.getName() + " amb MAC "
                        + dispositiu.getAddress());
                if (dispositiu.getUuids() != null) {
                    for (ParcelUuid uuid : dispositiu.getUuids()) {
                        Log.i(getClass().getName(), "UUIDs de dispositiu registrat: " + uuid.getUuid().toString());
                    }
                }
            }
        }

        // Registrem el BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receptorBroadcast, filter);

        BluetoothDevice dispositiu = adaptadorBT.getRemoteDevice("00:16:53:13:7E:94");

        //connectem un fil de client BT amb NXT
        Thread fil1 = new M40_ConnexioBlueToothFilClient(dispositiu);
        fil1.start();
    }
}

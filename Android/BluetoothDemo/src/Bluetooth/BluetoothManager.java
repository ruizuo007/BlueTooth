package Bluetooth;

/**
 * Created by shenlong on 15/7/2.
 */

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.app.AlertDialog;
import android.content.DialogInterface.OnCancelListener;

public class BluetoothManager {

    private BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

    private void BluetoothManger() { ; }

    private static BluetoothManager instance = null;

    public BluetoothManager sharedManager() {

        if (instance == null) {

            instance = new BluetoothManager();
        }

        return instance;
    }

    public  boolean isBluetoothAvailabe() {

        if (adapter == null) {

            new AlertDialog(this, true, new OnCancelListener() {

                new AlertDialog.Builder(this).show();
            })
        }

        return false;
    }
}

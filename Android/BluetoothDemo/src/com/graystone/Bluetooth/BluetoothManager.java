package com.graystone.Bluetooth;

/**
 * Created by shenlong on 15/7/2.
 */

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.app.AlertDialog;
import android.content.DialogInterface.OnCancelListener;

import android.content.Context;
import android.content.Intent;

import java.util.Set;

public class BluetoothManager {

    private BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

    private Context context;

    private void BluetoothManger() { ; }

    private static BluetoothManager instance = null;

    public static BluetoothManager sharedManager() {

        if (instance == null) {

            instance = new BluetoothManager();
        }

        return instance;
    }

    //MARK:

    public  boolean isBluetoothAvailabe() {

        if (adapter == null) {

            new AlertDialog.Builder(context).setTitle("").setPositiveButton("确定", null);

            return false;
        }

        if (adapter.isEnabled() == false) {

            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            context.startActivity(intent);

            return false;
        }

        return true;
    }

    //MARK:

    public Set<BluetoothDevice> bondedDevices() {

        return adapter.getBondedDevices();
    }

    //MARK:

    public void setContext(Context ctx) { this.context = ctx; }
}

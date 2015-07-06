package com.graystone.Bluetooth;

/**
 * Created by shenlong on 15/7/2.
 */

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.app.AlertDialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Set;

public class BluetoothManager {

    private BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

    private Context context;

    public BluetoothInterface bluetoothInterface;

    private static BluetoothManager instance = null;

    /**
     *
     */
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();

            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {

                if (BluetoothManager.this.bluetoothInterface != null) {

                    BluetoothManager.this.bluetoothInterface.onSearchProgress();
                }
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {

                if (BluetoothManager.this.bluetoothInterface != null) {

                    BluetoothManager.this.bluetoothInterface.onSearchFinished();
                }

                BluetoothManager.this.context.unregisterReceiver(this);
            }
        }
    }

    /**
     * init method
     */

    private void BluetoothManger() { ; }

    /**
     * Singleton
     */

    public static BluetoothManager sharedManager() {

        if (instance == null) {

            instance = new BluetoothManager();
        }

        return instance;
    }

    /**
     * @return
     */

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

    /**
     *
     * @return
     */

    public Set<BluetoothDevice> getBondedDevices() {

        return adapter.getBondedDevices();
    }

    /**
     *
     *
     */

    public void startSearch() {


    }

    /**
     *
     * @param ctx
     */

    public void setContext(Context ctx) { this.context = ctx; }
}

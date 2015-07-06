package com.graystone.Activity;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

import com.graystone.Adapter.DeviceListAdapter;
import com.graystone.Bluetooth.BluetoothManager;

import com.graystone.R;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView lv_devicelist;

    private DeviceListAdapter adapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        adapter = new DeviceListAdapter(this);

        lv_devicelist = (ListView)findViewById(R.id.lv_devicelist);
        lv_devicelist.setAdapter(adapter);
        lv_devicelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public void onCheckAvailable(View view) {

        BluetoothManager manager = BluetoothManager.sharedManager();
        manager.setContext(this);
        manager.isBluetoothAvailabe();
    }

    public void onDeviceList(View view) {

        BluetoothManager manager = BluetoothManager.sharedManager();
        adapter.setDevices(new ArrayList<BluetoothDevice>(manager.getBondedDevices()));
        adapter.notifyDataSetChanged();
    }
}

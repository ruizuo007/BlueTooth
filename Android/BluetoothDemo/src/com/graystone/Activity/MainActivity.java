package com.graystone.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.SimpleAdapter;
import com.graystone.Bluetooth.BluetoothManager;

import com.graystone.R;

public class MainActivity extends Activity {

    ListView lv_devicelist;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        SimpleAdapter sp = new SimpleAdapter()

        lv_devicelist = (ListView)findViewById(R.id.lv_devicelist);
        lv_devicelist.setAdapter(null);
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


    }
}

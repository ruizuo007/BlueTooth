package com.graystone.Adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.graystone.R;

import java.util.ArrayList;

/**
 * Created by shenlong on 15/7/3.
 */
public class DeviceListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;

    private ArrayList<BluetoothDevice> devices;

    public DeviceListAdapter(Context context) {

        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        if (devices == null) { return 0; }

        return devices.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();

            convertView = layoutInflater.inflate(R.layout.cell_devicelist, null);

            holder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
            holder.tv_address = (TextView)convertView.findViewById(R.id.tv_address);
            holder.tv_type = (TextView)convertView.findViewById(R.id.tv_type);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder)convertView.getTag();
        }

        BluetoothDevice device = devices.get(position);

        holder.tv_name.setText(device.getName() == null ? "" : device.getName());
        holder.tv_address.setText(device.getAddress() == null ? "" : device.getAddress());
        holder.tv_type.setText(Integer.toString(device.getType()));

        return convertView;
    }

    //MARK:

    public void setDevices(ArrayList<BluetoothDevice> devices) {

        this.devices = devices;
    }

    //MARK;

    private class ViewHolder {

        public TextView tv_name;
        public TextView tv_address;
        public TextView tv_type;
    }
}

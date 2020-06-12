package com.hobarb.secgir;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class DeviceListAdapter extends ArrayAdapter <BluetoothDevice>{

    LayoutInflater layoutInflater;
    ArrayList<BluetoothDevice> bluetoothDevices;
    int viewResourceId;
    public DeviceListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<BluetoothDevice> objects) {
        super(context, resource, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.bluetoothDevices = (ArrayList<BluetoothDevice>) objects;
        viewResourceId = resource;

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = layoutInflater.inflate(viewResourceId, null);
        BluetoothDevice device = bluetoothDevices.get(position);
        if (device!=null)
        {
            TextView device_name = convertView.findViewById(R.id.textView_name_dav);
            TextView device_address = convertView.findViewById(R.id.textView_address_dav);
            device_name.setText(device.getName());
            device_address.setText(device.getAddress());
        }
        return  convertView;
    }
}

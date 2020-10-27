package com.example.igem2020.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.bluetooth.BluetoothSocket;
import java.util.ArrayList;


public class bluetoothservice {

    private BluetoothAdapter blueadapter = BluetoothAdapter.getDefaultAdapter();
    public ArrayAdapter adapter;
    //需要一个listview

    //定义一个列表，存蓝牙设备的地址。
    public ArrayList<String> arrayList=new ArrayList<>();
    //定义一个列表，存蓝牙设备地址，用于显示。
    public ArrayList<String> deviceName=new ArrayList<>();

    public boolean issupport()//判断手机是否支持蓝牙
    {
        if(blueadapter!=null)
            return true;
        else
            return false;
    }

    public void opentooth(Activity activity,int code)//打开蓝牙
    {
        if (!blueadapter.isEnabled())
        //判断本机蓝牙是否打开
        {//如果没打开，则打开蓝牙
            //blueadapter.enable();//不推荐由程序直接调用
            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(intent,code);
        }
    }

/*
    private void openbluetoothvisibility()
    {
        if(blueadapter.getScanMode()!=BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE)
        {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);//设置本机蓝牙在300秒内可见
            startActivity(discoverableIntent);
        }
    }

    public void doDiscovry() {
        if (blueadapter.isDiscovering()) {
            //判断蓝牙是否正在扫描，如果是调用取消扫描方法；如果不是，则开始扫描
            blueadapter.cancelDiscovery();
        } else
            blueadapter.startDiscovery();
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, deviceName);
    }
*/


}

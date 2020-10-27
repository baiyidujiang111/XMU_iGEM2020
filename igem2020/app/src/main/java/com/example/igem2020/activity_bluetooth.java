package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.igem2020.bluetooth.bluetoothservice;

public class activity_bluetooth extends AppCompatActivity {

    private bluetoothservice bluetoothservice=new bluetoothservice();

    private Button open,close;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        //open=findViewById(R.id.button4);
        //close=findViewById(R.id);

    }


}

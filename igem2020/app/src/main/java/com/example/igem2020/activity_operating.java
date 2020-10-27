package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_operating extends AppCompatActivity {

    private ImageButton back;
    private ImageButton begin;
    private ImageButton ins_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operating);

        back=findViewById(R.id.back_operate);
        ins_more=findViewById(R.id.ins_more);
        begin=findViewById(R.id.begin_operate);

        ins_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("https://2020.igem.org/Team:XMU-China/Hardware");
                intent.setData(content_url);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_checking extends AppCompatActivity {

    private ImageButton get_report;
    private ImageButton back;
    private ImageButton more;
    private ImageView mytext;

    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);

        get_report = findViewById(R.id.get_report);
        back = findViewById(R.id.back_checking);
        more = findViewById(R.id.more_checking);
        mytext = findViewById(R.id.mytext_checking);

        get_report.setEnabled(false);
        get_report.setVisibility(View.INVISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 耗时操作
                try {
                    Thread.sleep(5000);
                    flag=true;
                    //System.out.println("tefsdfsd");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            get_report.setVisibility(View.VISIBLE);
                            get_report.setEnabled(true);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag)
                {
                    finish();
                }
                else
                {
                    Toast.makeText(activity_checking.this,"The test is running",Toast.LENGTH_SHORT);
                }
            }
        });

        get_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag)
                {
                    //跳转到报告界面
                    Intent intent=new Intent(activity_checking.this,activity_report.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(activity_checking.this,"The test is running",Toast.LENGTH_SHORT);
                }
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity_checking.this,activity_tips.class);
                startActivity(intent);
            }
        });


    }
}

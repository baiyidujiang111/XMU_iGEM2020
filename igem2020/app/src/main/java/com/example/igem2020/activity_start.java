package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_start extends AppCompatActivity {

    private ImageButton check;
    private ImageButton check_setting;
    private ImageButton history;
    private ImageButton about_us;
    private ImageButton login;
    private static final int REQUEST_CODE = 1;

    private boolean setting_flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        check=findViewById(R.id.check);
        check_setting=findViewById(R.id.check_setting);
        history=findViewById(R.id.history);
        about_us=findViewById(R.id.about_us);
        login=findViewById(R.id.login_in);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setting_flag)
                {
                    Intent i=new Intent(activity_start.this,activity_check.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(activity_start.this,"Please set the basic information first",Toast.LENGTH_SHORT).show();
                }
            }
        });
        check_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(activity_start.this,activity_setting.class);
                startActivityForResult(i,2);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(activity_start.this,activity_history.class);
                startActivity(i);
                //overridePendingTransition(Android.R.anim.fade_in,android.R.anim.fade_out);//淡入淡出
                //overridePendingTransition(R.anim.zoomin, R.anim.zoomout);//ZOOMIN&ZOOMOUT 类似iphone
            }
        });

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(activity_start.this,aboutus.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(activity_start.this,activity_login.class);
                startActivityForResult(i,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode==RESULT_OK)
        {
            if(requestCode==REQUEST_CODE)
            {
                //
                String userrname2 ="Welcome "+ data.getStringExtra("username");
                Toast.makeText(activity_start.this,userrname2,Toast.LENGTH_SHORT).show();
            }
            if(requestCode==2)
            {
                String s2="Setup succeeded";
                Toast.makeText(activity_start.this,s2,Toast.LENGTH_SHORT).show();
                setting_flag=true;
            }
        }

    }
}

package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_setting extends AppCompatActivity {

    private EditText date;
    private EditText origin;
    private EditText teatype;
    private ImageButton init;
    private String date_str;
    private String origin_str;
    private String teatype_str;

    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        date=findViewById(R.id.date_setting);
        origin=findViewById(R.id.origin_setting);
        teatype=findViewById(R.id.tea_type);
        init=findViewById(R.id.initialite_setting);

        myApplication=(MyApplication) getApplication();
        String s=myApplication.getDate();
        if(!s.equals(""))
        {
            date.setText(myApplication.getDate());
            origin.setText(myApplication.getPlace());
            teatype.setText(myApplication.getTeatype());
        }

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                origin_str=origin.getText().toString();
                date_str=date.getText().toString();
                teatype_str=teatype.getText().toString();

                if(origin_str.equals("")||date_str.equals("")||teatype_str.equals(""))
                {
                    String s = "Please complete the form";
                    Toast.makeText(activity_setting.this, s, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    myApplication=(MyApplication) getApplication();
                    myApplication.setDate(date_str);
                    myApplication.setPlace(origin_str);
                    myApplication.setTeatype(teatype_str);
                    Intent intent = getIntent();
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });

    }
}

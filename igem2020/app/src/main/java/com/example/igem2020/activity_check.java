package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_check extends AppCompatActivity {

    private ImageButton check;
    private ImageButton help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        check=findViewById(R.id.ready_detect);
        help=findViewById(R.id.help_check);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity_check.this,activity_operating.class);
                startActivity(intent);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity_check.this,activity_checking.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

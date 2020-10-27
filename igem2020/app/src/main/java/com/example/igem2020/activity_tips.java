package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class activity_tips extends AppCompatActivity {

    private ImageButton back;
    private ImageButton next;
    private TextView text;

    private int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        text=findViewById(R.id.text_tips);
        back=findViewById(R.id.back_tips);
        next=findViewById(R.id.next_tips);
        text.setMovementMethod(ScrollingMovementMethod.getInstance());

        if(flag%2==1)
        {
            text.setText(R.string.tip1);
        }
        else
        {
            text.setText(R.string.tip2);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag++;
                if(flag%2==1)
                {
                    text.setText(R.string.tip1);
                }
                else
                {
                    text.setText(R.string.tip2);
                }
            }
        });
    }

}

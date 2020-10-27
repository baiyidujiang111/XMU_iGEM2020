package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;


public class activity_login extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private ImageButton login;
    private ImageButton wechat;
    private ImageButton facebook;
    private ImageButton back;

    //取得全局数据
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.mylogin);
        name=findViewById(R.id.name_insert);
        password=findViewById(R.id.password_insert);
        wechat=findViewById(R.id.wechat_login);
        facebook=findViewById(R.id.facebook_login);
        back=findViewById(R.id.back_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String password1 = password.getText().toString();

                if (name1.equals("") || password1.equals("")) {
                    String s = "Please complete the form";
                    Toast.makeText(activity_login.this, s, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //发送数据Post
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username", name1);
                        jsonObject.put("password", password1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    myApplication =(MyApplication) getApplication();
                    System.out.println(myApplication.getIp_url() + "/user/login");
                    String url = myApplication.getIp_url() + "/user/login";
                    RequestQueue requestQueue = Volley.newRequestQueue(activity_login.this);
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            try {
                                Log.d("登录信息", jsonObject.toString());
                                String msg = jsonObject.getString("msg");
                                //Toast.makeText(activity_login.this, msg, Toast.LENGTH_SHORT).show();
                                if (msg.equals("登录成功")) {
                                    JSONObject detail = jsonObject.getJSONObject("detail");
                                    final String username_login = detail.getString("username");
                                    //将登录信息存入到全局数据中
                                    myApplication.setAddress(detail.getString("address"));
                                    myApplication.setEmail(detail.getString("email"));
                                    myApplication.setPhone(detail.getString("phone"));
                                    myApplication.setUsername(detail.getString("username"));
                                    /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                                    // HH:mm:ss
                                    // 获取当前时间
                                    Date date = new Date(System.currentTimeMillis());
                                    myApplication.setDate(simpleDateFormat.format(date));*/
                                    //
                                    Intent intent = getIntent();
                                    intent.putExtra("username", username_login);
                                    setResult(RESULT_OK,intent);
                                    finish();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            System.out.println("VolleyError:" + volleyError.toString());
                            Toast.makeText(activity_login.this, "网络出错", Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(jsonObjectRequest);
                }
            }
        });

        wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="Coming soon";
                Toast.makeText(activity_login.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="Coming soon";
                Toast.makeText(activity_login.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}

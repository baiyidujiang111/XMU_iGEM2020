package com.example.igem2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;

public class activity_report extends AppCompatActivity {

    private ImageButton back;
    private ImageButton save;
    private ImageButton share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        back=findViewById(R.id.back_report);
        save=findViewById(R.id.download_report);
        share=findViewById(R.id.share_report);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_report.this,"The report has been saved",Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String fileName="analysis report.pdf";
                copyAssetAndWrite(fileName);
                File dataFile=new File(getCacheDir(),fileName);
                //System.out.println("filePath:" + dataFile.getAbsolutePath());
                Uri report=Uri.parse(dataFile.toString());
                System.out.println("filePath:" + report );*/


                //String path = getResourcesUri(R.drawable.re);
                Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+ R.drawable.re);
                Intent mulIntent = new Intent(Intent.ACTION_SEND);
                mulIntent.setType("image/jpeg");
                mulIntent.putExtra(Intent.EXTRA_STREAM,path);
                startActivity(Intent.createChooser(mulIntent,"share report"));

            }
        });
    }

    /**
     * 将asset文件写入缓存
     */
    private boolean copyAssetAndWrite(String fileName){
        try {
            File cacheDir=getCacheDir();
            if (!cacheDir.exists()){
                cacheDir.mkdirs();
            }
            File outFile =new File(cacheDir,fileName);
            if (!outFile.exists()){
                boolean res=outFile.createNewFile();
                if (!res){
                    return false;
                }
            }else {
                if (outFile.length()>10){//表示已经写入一次
                    return true;
                }
            }
            InputStream is=getAssets().open(fileName);
            FileOutputStream fos = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int byteCount;
            while ((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
            is.close();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}

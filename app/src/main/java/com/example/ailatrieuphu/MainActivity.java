package com.example.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static boolean isPlayLuatChoi = true;
    public static boolean btnHelp;
    public static boolean btnPercent;
    public static boolean btnGoiDien;
    public static boolean btnDoiCauHoi;
    private MediaPlayer musicBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHelp = true;
        btnPercent = true;
        btnGoiDien = true;
        btnDoiCauHoi = true;
        anhXa();
        musicBackground = MediaPlayer.create(this, R.raw.bgmusic);
        musicBackground.start();
        DatabaseALTP.num = 1;
        if(ActivityChoiGame.isIsShowDialog()){
            DialogCustom dialogCustom = new DialogCustom(MainActivity.this);
            dialogCustom.setCancelable(false);
            dialogCustom.setCanceledOnTouchOutside(false);
            dialogCustom.show();
            ActivityChoiGame.setIsShowDialog(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnChoi:
                Intent showLevel = new Intent(MainActivity.this, ActivityLevel.class);
                startActivity(showLevel);
                overridePendingTransition(R.anim.enter, R.anim.exist);
                musicBackground.release();
                break;
            case R.id.btnBXH:
                Intent showBXH = new Intent(MainActivity.this, ActivityBXH.class);
                startActivity(showBXH);
                overridePendingTransition(R.anim.enter, R.anim.exist);
                musicBackground.release();
                break;
            case R.id.btnThoat:
                finishAffinity();// Thoát hết mọi hoạt động(activity)
                System.exit(0);
                musicBackground.release();
        }
    }

    private void anhXa(){
        Button btnChoi = findViewById(R.id.btnChoi);
        btnChoi.setOnClickListener(this);
        Button btnBXH = findViewById(R.id.btnBXH);
        btnBXH.setOnClickListener(this);
        Button btnThoat = findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(this);
    }
}
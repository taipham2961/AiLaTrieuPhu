package com.example.ailatrieuphu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLevel extends AppCompatActivity {
    private MediaPlayer mediaLuatChoi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        if(MainActivity.isPlayLuatChoi){
            mediaLuatChoi = MediaPlayer.create(this, R.raw.luatchoi);
            mediaLuatChoi.start();
            MainActivity.isPlayLuatChoi = false;
            new CountDownTimer(8000, 1300){

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    mediaLuatChoi.release();
                    Intent intent = new Intent(ActivityLevel.this, ActivityChoiGame.class);
                    startActivity(intent);
                }
            }.start();
        } else {
            new CountDownTimer(3000, 1000){

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    Intent intent = new Intent(ActivityLevel.this, ActivityChoiGame.class);
                    startActivity(intent);
                }
            }.start();
        }
        setBackgroundLevel();
    }

    private void setBackgroundLevel(){
        switch (DatabaseALTP.num){
            case 1:
                findViewById(R.id.tvLevel1).setBackgroundResource(R.drawable.bg_level);
                break;
            case 2:
                findViewById(R.id.tvLevel2).setBackgroundResource(R.drawable.bg_level);
                break;
            case 3:
                findViewById(R.id.tvLevel3).setBackgroundResource(R.drawable.bg_level);
                break;
            case 4:
                findViewById(R.id.tvLevel4).setBackgroundResource(R.drawable.bg_level);
                break;
            case 5:
                findViewById(R.id.tvLevel5).setBackgroundResource(R.drawable.bg_level);
                break;
            case 6:
                findViewById(R.id.tvLevel6).setBackgroundResource(R.drawable.bg_level);
                break;
            case 7:
                findViewById(R.id.tvLevel7).setBackgroundResource(R.drawable.bg_level);
                break;
            case 8:
                findViewById(R.id.tvLevel8).setBackgroundResource(R.drawable.bg_level);
                break;
            case 9:
                findViewById(R.id.tvLevel9).setBackgroundResource(R.drawable.bg_level);
                break;
            case 10:
                findViewById(R.id.tvLevel10).setBackgroundResource(R.drawable.bg_level);
                break;
            case 11:
                findViewById(R.id.tvLevel11).setBackgroundResource(R.drawable.bg_level);
                break;
            case 12:
                findViewById(R.id.tvLevel12).setBackgroundResource(R.drawable.bg_level);
                break;
            case 13:
                findViewById(R.id.tvLevel13).setBackgroundResource(R.drawable.bg_level);
                break;
            case 14:
                findViewById(R.id.tvLevel14).setBackgroundResource(R.drawable.bg_level);
                break;
            case 15:
                findViewById(R.id.tvLevel15).setBackgroundResource(R.drawable.bg_level);
                break;
        }
    }
}

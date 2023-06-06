package com.example.ailatrieuphu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ActivityChoiGame extends AppCompatActivity implements View.OnClickListener {
    private String chonCauTraLoi;
    private DatabaseALTP db;
    private Button btnA, btnB, btnC, btnD;
    private TextView tvCauHoi, tvTime, tvLevel, tvTienThuong;
    private ImageButton imgBtnDung, imgBtnHelp, imgBtnPercent,
            imgBtnGoiDien, imgBtnDoiCauHoi;
    private MediaPlayer mediaLevel, mediaAnswer,
                        mediaCheckFalse, mediaCheckTrue,
                        mediaHelp, mediaImportant, mediaClick;
    private AnimationDrawable animationDrawable;
    public static String tvTrue;
    private boolean checkClick;
    public static boolean isShowDialog = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choigame);
        setMusicLevel();
        anhXa();
        checkClick = true;
        db = new DatabaseALTP(this);
        db.query15CauHoi();
        setDataAnswer();
        setTienThuong();
        db.getBXH();
        timerCountDown(this);
        getTextTrueAnswer();
        Log.d("ALTP", DatabaseALTP.cauTraLoi);

       if (MainActivity.btnGoiDien == false) {
           imgBtnGoiDien.setEnabled(false);
           imgBtnGoiDien.setBackgroundResource(R.drawable.call_x);
       }
        if (MainActivity.btnPercent == false) {
            imgBtnPercent.setEnabled(false);
            imgBtnPercent.setBackgroundResource(R.drawable.percent50_x);
        }
        if (MainActivity.btnDoiCauHoi == false) {
            imgBtnDoiCauHoi.setEnabled(false);
            imgBtnDoiCauHoi.setBackgroundResource(R.drawable.change_x);
        }
        if (MainActivity.btnHelp == false) {
           imgBtnHelp.setEnabled(false);
           imgBtnHelp.setBackgroundResource(R.drawable.help_x);
        }
    }

    public static boolean isIsShowDialog() {
        return isShowDialog;
    }

    public static void setIsShowDialog(boolean isShowDialog) {
        ActivityChoiGame.isShowDialog = isShowDialog;
    }

    private void setMusicLevel(){
        switch (DatabaseALTP.num){
            case 1:
                mediaLevel = MediaPlayer.create(this, R.raw.quest1);
                mediaLevel.start();
                break;
            case 2:
                mediaLevel = MediaPlayer.create(this, R.raw.quest2);
                mediaLevel.start();
                break;
            case 3:
                mediaLevel = MediaPlayer.create(this, R.raw.quest3);
                mediaLevel.start();
                break;
            case 4:
                mediaLevel = MediaPlayer.create(this, R.raw.quest4);
                mediaLevel.start();
                break;
            case 5:
                mediaLevel = MediaPlayer.create(this, R.raw.quest5);
                mediaLevel.start();
                runMediaImportant();
                break;
            case 6:
                mediaLevel = MediaPlayer.create(this, R.raw.quest6);
                mediaLevel.start();
                break;
            case 7:
                mediaLevel = MediaPlayer.create(this, R.raw.quest7);
                mediaLevel.start();
                break;
            case 8:
                mediaLevel = MediaPlayer.create(this, R.raw.quest8);
                mediaLevel.start();
                break;
            case 9:
                mediaLevel = MediaPlayer.create(this, R.raw.quest9);
                mediaLevel.start();
                break;
            case 10:
                mediaLevel = MediaPlayer.create(this, R.raw.quest10);
                mediaLevel.start();
                runMediaImportant();
                break;
            case 11:
                mediaLevel = MediaPlayer.create(this, R.raw.quest11);
                mediaLevel.start();
                break;
            case 12:
                mediaLevel = MediaPlayer.create(this, R.raw.quest12);
                mediaLevel.start();
                break;
            case 13:
                mediaLevel = MediaPlayer.create(this, R.raw.quest13);
                mediaLevel.start();
                break;
            case 14:
                mediaLevel = MediaPlayer.create(this, R.raw.quest14);
                mediaLevel.start();
                break;
            case 15:
                mediaLevel = MediaPlayer.create(this, R.raw.quest15);
                mediaLevel.start();
                runMediaImportant();
                break;
        }
    }

    private void anhXa(){
        tvCauHoi = findViewById(R.id.tvCauHoi);
        btnA = findViewById(R.id.btnA);
        btnA.setOnClickListener(this);
        btnB = findViewById(R.id.btnB);
        btnB.setOnClickListener(this);
        btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(this);
        btnD = findViewById(R.id.btnD);
        btnD.setOnClickListener(this);
        tvLevel = findViewById(R.id.tvLevel);
        imgBtnDung = findViewById(R.id.imgBtnDung);
        imgBtnDung.setOnClickListener(this);
        imgBtnHelp = findViewById(R.id.imgBtnHelp);
        imgBtnHelp.setOnClickListener(this);
        imgBtnPercent = findViewById(R.id.imgBtnPercent50);
        imgBtnPercent.setOnClickListener(this);
        imgBtnGoiDien = findViewById(R.id.imgBtnGoiDien);
        imgBtnGoiDien.setOnClickListener(this);
        imgBtnDoiCauHoi = findViewById(R.id.imgBtnDoiCauHoi);
        imgBtnDoiCauHoi.setOnClickListener(this);
        tvTienThuong = findViewById(R.id.tvTienThuong);
        tvTime = findViewById(R.id.tvTime);
    }

    private void setDataAnswer(){
        tvLevel.setText("Câu " + DatabaseALTP.getNum() + " ");
        tvCauHoi.setText(DatabaseALTP.cauHoi.getCauHoi());
        btnA.setText("A. " + DatabaseALTP.cauHoi.getA());
        btnB.setText("B. " + DatabaseALTP.cauHoi.getB());
        btnC.setText("C. " + DatabaseALTP.cauHoi.getC());
        btnD.setText("D. " + DatabaseALTP.cauHoi.getD());
    }

    private void setTienThuong(){
        switch (DatabaseALTP.num - 1){
            case 0:
                tvTienThuong.setText("0");
                break;
            case 1:
                tvTienThuong.setText("200000");
                break;
            case 2:
                tvTienThuong.setText("400000");
                break;
            case 3:
                tvTienThuong.setText("600000");
                break;
            case 4:
                tvTienThuong.setText("1000000");
                break;
            case 5:
                tvTienThuong.setText("2000000");
                break;
            case 6:
                tvTienThuong.setText("3000000");
                break;
            case 7:
                tvTienThuong.setText("6000000");
                break;
            case 8:
                tvTienThuong.setText("10000000");
                break;
            case 9:
                tvTienThuong.setText("14000000");
                break;
            case 10:
                tvTienThuong.setText("20000000");
                break;
            case 11:
                tvTienThuong.setText("30000000");
                break;
            case 12:
                tvTienThuong.setText("40000000");
                break;
            case 13:
                tvTienThuong.setText("60000000");
                break;
            case 14:
                tvTienThuong.setText("85000000");
                break;
            case 15:
                tvTienThuong.setText("150000000");
                break;
            default:
                break;
        }
    }

    private void timerCountDown(final Context context){
        new CountDownTimer(31000, 1000){
            @Override
            public void onTick(long l) {
                if(checkClick){
                    tvTime.setText(l / 1000 + "");
                }
            }

            @Override
            public void onFinish() {
                if(checkClick){
                    tvTime.setText("0");
                    Intent intent = new Intent(ActivityChoiGame.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.enter, R.anim.exist);
                    if(!db.getListBXH().isEmpty()){
                        if(db.getListBXH().get(0).getSoLevel() < DialogCustom.level){
                            isShowDialog = true;
                        }
                    }
                }
            }
        }.start();
    }

    private void runMediaImportant(){
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                setMediaImportant();
            }
        }.start();
    }

    private void setMediaImportant(){
        mediaImportant = MediaPlayer.create(this, R.raw.important);
        mediaImportant.start();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnA:
                btnA.setEnabled(false);
                checkClick = false;
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_a);
                mediaAnswer.start();
                chonCauTraLoi = btnA.getText().toString();
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnA.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btnA.getBackground();
                animationDrawable.start();
                if(chonCauTraLoi.substring(3).equals(DatabaseALTP.cauTraLoi)){
                    DatabaseALTP.num++;
                    DatabaseALTP.setCheckDapAn(true);
                    mediaCheckTrue = MediaPlayer.create(this, R.raw.true_a);
                    new CountDownTimer(5000, 1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            mediaCheckTrue.start();
                        }
                    }.start();
                    new CountDownTimer(9000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                        }
                    }.start();
                    DialogCustom.level++;
                    hienDapAn();
                } else {
                    isShowDialog = true;
                    MainActivity.isPlayLuatChoi = true;
                    DatabaseALTP.num = 1;
                    new CountDownTimer(7000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            failAnswerAudio();
                            new CountDownTimer(6000,1000){

                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {
                                    Intent intent = new Intent(ActivityChoiGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }.start();
                        }
                    }.start();
                }
                break;
            case R.id.btnB:
                btnB.setEnabled(false);
                checkClick = false;
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_b);
                mediaAnswer.start();
                chonCauTraLoi = btnB.getText().toString();
                btnA.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setEnabled(false);
                btnB.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btnB.getBackground();
                animationDrawable.start();
                if(chonCauTraLoi.substring(3).equals(DatabaseALTP.cauTraLoi)){
                    DatabaseALTP.num++;
                    DatabaseALTP.setCheckDapAn(true);
                    mediaCheckTrue = MediaPlayer.create(this, R.raw.true_b);
                    new CountDownTimer(5000, 1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            mediaCheckTrue.start();
                        }
                    }.start();
                    new CountDownTimer(9000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                        }
                    }.start();
                    DialogCustom.level++;
                    hienDapAn();
                } else {
                    isShowDialog = true;
                    MainActivity.isPlayLuatChoi = true;
                    DatabaseALTP.num = 1;
                    new CountDownTimer(7000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            failAnswerAudio();
                            new CountDownTimer(6000,1000){

                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {
                                    Intent intent = new Intent(ActivityChoiGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }.start();
                        }
                    }.start();
                }
                break;
            case R.id.btnC:
                btnC.setEnabled(false);
                checkClick = false;
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_c);
                mediaAnswer.start();
                chonCauTraLoi = btnC.getText().toString();
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnD.setEnabled(false);
                btnC.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btnC.getBackground();
                animationDrawable.start();
                if(chonCauTraLoi.substring(3).equals(DatabaseALTP.cauTraLoi)){
                    DatabaseALTP.num++;
                    DatabaseALTP.setCheckDapAn(true);
                    mediaCheckTrue = MediaPlayer.create(this, R.raw.true_c);
                    new CountDownTimer(5000, 1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            mediaCheckTrue.start();
                        }
                    }.start();
                    new CountDownTimer(9000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                        }
                    }.start();
                    DialogCustom.level++;
                    hienDapAn();
                } else {
                    isShowDialog = true;
                    MainActivity.isPlayLuatChoi = true;
                    DatabaseALTP.num = 1;
                    new CountDownTimer(7000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            failAnswerAudio();
                            new CountDownTimer(6000,1000){

                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {
                                    Intent intent = new Intent(ActivityChoiGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }.start();
                        }
                    }.start();
                }
                break;
            case R.id.btnD:
                btnD.setEnabled(false);
                checkClick = false;
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_d);
                mediaAnswer.start();
                chonCauTraLoi = btnD.getText().toString();
                btnA.setEnabled(false);
                btnB.setEnabled(false);
                btnC.setEnabled(false);
                btnD.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btnD.getBackground();
                animationDrawable.start();
                if(chonCauTraLoi.substring(3).equals(DatabaseALTP.cauTraLoi)){
                    DatabaseALTP.num++;
                    DatabaseALTP.setCheckDapAn(true);
                    mediaCheckTrue = MediaPlayer.create(this, R.raw.true_d);
                    new CountDownTimer(5000, 1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            mediaCheckTrue.start();
                        }
                    }.start();
                    new CountDownTimer(9000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                        }
                    }.start();
                    DialogCustom.level++;
                    hienDapAn();
                } else {
                    isShowDialog = true;
                    MainActivity.isPlayLuatChoi = true;
                    DatabaseALTP.num = 1;
                    new CountDownTimer(7000,1000){

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            failAnswerAudio();
                            new CountDownTimer(6000,1000){

                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {
                                    Intent intent = new Intent(ActivityChoiGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }.start();
                        }
                    }.start();
                }
                break;
            //Dừng cuộc chơi
            case R.id.imgBtnDung:
                checkClick = false;
                MainActivity.isPlayLuatChoi = true;
                DialogCustom.soTien = Integer.parseInt(tvTienThuong.getText().toString());
                Intent intent = new Intent(ActivityChoiGame.this, MainActivity.class);
                isShowDialog = true;
                startActivity(intent);
                break;
            //Trợ giúp khán giả
            case R.id.imgBtnHelp:
                mediaClick();
                List<TextView> list = new ArrayList<>();
                list.add(btnA);
                list.add(btnB);
                list.add(btnC);
                list.add(btnD);
                mediaHelp = MediaPlayer.create(this, R.raw.khan_gia);
                mediaHelp.start();
                final DialogTuVan dialogTuVan = new DialogTuVan(
                        this, MainActivity.btnPercent, list);
                new CountDownTimer(6000, 1000){

                    @Override
                    public void onTick(long l) {
                        imgBtnHelp.setBackgroundResource(R.drawable.help_active);
                    }

                    @Override
                    public void onFinish() {
                        dialogTuVan.show();
                        mediaHelp.release();
                        imgBtnHelp.setEnabled(false);
                        imgBtnHelp.setBackgroundResource(R.drawable.help_x);
                        MainActivity.btnHelp = false;
                    }
                }.start();
                break;
            //Trợ giúp 50:50
            case R.id.imgBtnPercent50:
                mediaClick();
                mediaHelp = MediaPlayer.create(this, R.raw.sound5050);
                mediaHelp.start();
                imgBtnPercent.setEnabled(false);
                new CountDownTimer(3500, 1000){

                    @Override
                    public void onTick(long l) {
                        btnA.setEnabled(false);
                        btnB.setEnabled(false);
                        btnC.setEnabled(false);
                        btnD.setEnabled(false);
                        imgBtnPercent.setBackgroundResource(R.drawable.percent50_active);
                    }

                    @Override
                    public void onFinish() {
                        btnA.setEnabled(true);
                        btnB.setEnabled(true);
                        btnC.setEnabled(true);
                        btnD.setEnabled(true);
                        percent50();
                        imgBtnPercent.setBackgroundResource(R.drawable.percent50_x);
                        mediaHelp.release();
                        MainActivity.btnPercent = false;
                    }
                }.start();
                break;
            //Trợ giúp gọi điện cho người thân
            case R.id.imgBtnGoiDien:
                mediaClick();
                mediaHelp = MediaPlayer.create(this, R.raw.help_call);
                mediaHelp.start();
                new CountDownTimer(5000,1000){

                    @Override
                    public void onTick(long l) {
                        imgBtnGoiDien.setBackgroundResource(R.drawable.call_active);
                    }

                    @Override
                    public void onFinish() {
                        DialogCall dialogCall = new DialogCall(ActivityChoiGame.this);
                        dialogCall.setCancelable(true);
                        dialogCall.setCanceledOnTouchOutside(true);
                        dialogCall.show();
                        imgBtnGoiDien.setEnabled(false);
                        imgBtnGoiDien.setBackgroundResource(R.drawable.call_x);
                        MainActivity.btnGoiDien = false;
                    }
                }.start();
                break;
            //Trợ giúp đổi câu hỏi
            case R.id.imgBtnDoiCauHoi:
                mediaClick();
                //Khởi tạo lại bộ câu hỏi
                db.query15CauHoi();
                setDataAnswer();
                imgBtnDoiCauHoi.setEnabled(false);
                imgBtnDoiCauHoi.setBackgroundResource(R.drawable.change_x);
                MainActivity.btnDoiCauHoi = false;
                break;
        }
    }

    private void releaseMediaTrue(){
        if(mediaCheckTrue != null){
            mediaCheckTrue.release();
        }
    }

    private void mediaClick() {
        mediaClick = MediaPlayer.create(this, R.raw.sound_trogiup);
        mediaClick.start();
    }

    private void hienDapAn(){
        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                getTrueAnswerAnim();
                new CountDownTimer(4000,1000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if(DatabaseALTP.num > 15){
                            isShowDialog = true;
                            MainActivity.isPlayLuatChoi = true;
                            DatabaseALTP.num = 1;
                            Intent intent = new Intent(ActivityChoiGame.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(ActivityChoiGame.this, ActivityLevel.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.enter,R.anim.exist);
                        }
                    }
                }.start();
            }
        }.start();
    }

    //Hiện câu trả lời đúng bằng animation
    private void getTrueAnswerAnim() {
        List<TextView> list = new ArrayList<>();
        list.add(btnA);
        list.add(btnB);
        list.add(btnC);
        list.add(btnD);
        String string;
        for (int i = 0; i < list.size(); i++) {
            string = list.get(i).getText().toString();
            if (string.contains(DatabaseALTP.cauTraLoi)) {
                list.get(i).setBackgroundResource(R.drawable.drawable_choose_true);
                AnimationDrawable animationDrawable = (AnimationDrawable) list.get(i).getBackground();
                animationDrawable.start();
            }
        }
    }

    //Lấy câu trả lời đúng
    private void getTextTrueAnswer() {
        List<TextView> list = new ArrayList<>();
        list.add(btnA);
        list.add(btnB);
        list.add(btnC);
        list.add(btnD);
        String string;
        for (int i = 0; i < list.size(); i++) {
            string = list.get(i).getText().toString();
            if (string.substring(3).equals(DatabaseALTP.cauTraLoi)) {
                tvTrue = list.get(i).getText().toString();
            }
        }
    }

    //Thông báo trả lời sai và đưa kết quả đúng
    private void failAnswerAudio(){
        List<TextView> list = new ArrayList<>();
        list.add(btnA);
        list.add(btnB);
        list.add(btnC);
        list.add(btnD);
        String string;
        for (int i = 0; i < list.size(); i++) {
            string = list.get(i).getText().toString();
            if(string == ""){
                return;
            } else {
                if(string.substring(3).contains(DatabaseALTP.cauTraLoi)){
                    switch (i){
                        case 0:
                            mediaCheckFalse = MediaPlayer.create(this, R.raw.lose_a);
                            mediaCheckFalse.start();
                            break;
                        case 1:
                            mediaCheckFalse = MediaPlayer.create(this, R.raw.lose_b);
                            mediaCheckFalse.start();
                            break;
                        case 2:
                            mediaCheckFalse = MediaPlayer.create(this, R.raw.lose_c);
                            mediaCheckFalse.start();
                            break;
                        case 3:
                            mediaCheckFalse = MediaPlayer.create(this, R.raw.lose_d);
                            mediaCheckFalse.start();
                            break;
                        default:
                            break;
                    }
                    list.get(i).setBackgroundResource(R.drawable.drawable_choose_true);
                    AnimationDrawable animationDrawable = (AnimationDrawable) list.get(i).getBackground();
                    animationDrawable.start();
                }
            }
        }
    }

    private void percent50() {
        List<TextView> list = new ArrayList<>();
        list.add(btnA);
        list.add(btnB);
        list.add(btnC);
        list.add(btnD);
        String string;
        //Bỏ câu đúng ra khỏi danh sách sẽ xóa nội dung đáp án
        for (int i = 0; i < list.size(); i++) {
            string = list.get(i).getText().toString();
            if (string.substring(3).equals(DatabaseALTP.cauTraLoi)) {
                list.remove(i);
            }
        }
        Random rd = new Random();
        Vector v = new Vector();
        int j = 0;
        //Chọn 2 trong 3 đáp án để xóa nội dung đáp án
        for (int i = 0; i < 2; ) {
            j = rd.nextInt(list.size());
            if (!v.contains(j)) {
                i++;
                v.add(j);
                list.get(i).setText("");
                list.get(i).setEnabled(false);
            }
        }
    }
}

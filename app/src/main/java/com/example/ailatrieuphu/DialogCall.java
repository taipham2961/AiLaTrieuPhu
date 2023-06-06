package com.example.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DialogCall extends Dialog implements View.OnClickListener{
    private ImageButton imgBtnMe, imgBtnBo, imgBtnAnhTrai;
    private TextView tvLoiKhuyen;

    public DialogCall(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_goidien);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        imgBtnMe = findViewById(R.id.imgBtnMe);
        imgBtnMe.setOnClickListener(this);
        imgBtnBo = findViewById(R.id.imgBtnBo);
        imgBtnBo.setOnClickListener(this);
        imgBtnAnhTrai = findViewById(R.id.imgBtnAnhTrai);
        imgBtnAnhTrai.setOnClickListener(this);
        tvLoiKhuyen = findViewById(R.id.tvLoiKhuyen);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBtnMe:
                tvLoiKhuyen.setText(
                        "Mẹ của bạn chọn đáp án " + ActivityChoiGame.tvTrue.substring(0, 1));
                imgBtnBo.setClickable(false);
                imgBtnAnhTrai.setClickable(false);
                new CountDownTimer(3000, 1000){

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        dismiss();
                    }
                }.start();
                break;
            case R.id.imgBtnBo:
                tvLoiKhuyen.setText(
                        "Bố của bạn chọn đáp án " + ActivityChoiGame.tvTrue.substring(0, 1));
                imgBtnMe.setClickable(false);
                imgBtnAnhTrai.setClickable(false);
                new CountDownTimer(3000, 1000){

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        dismiss();
                    }
                }.start();
                break;
            case R.id.imgBtnAnhTrai:
                tvLoiKhuyen.setText(
                        "Anh trai của bạn chọn đáp án " + ActivityChoiGame.tvTrue.substring(0, 1));
                imgBtnBo.setClickable(false);
                imgBtnMe.setClickable(false);
                new CountDownTimer(3000, 1000){

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        dismiss();
                    }
                }.start();
                break;
        }
    }
}

package com.example.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class DialogCustom extends Dialog implements View.OnClickListener {
    private EditText edtUser;
    private DatabaseALTP db;
    public static int level = 0;
    public static int soTien = 0;

    public DialogCustom(@NonNull Context context){
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        edtUser = findViewById(R.id.edtUsername);
        Button btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(this);
        Button btnHuy = findViewById(R.id.btnHuy);
        btnHuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEnter:
                String name = edtUser.getText().toString();
                db = new DatabaseALTP((this.getContext()));
                BangXepHang bangXepHang = new BangXepHang();
                bangXepHang.setName(name);
                bangXepHang.setSoLevel(level);

                if(soTien == 0){
                    if(level < 5){
                        soTien = 0;
                    } else if(level < 10){
                        soTien = 2000000;
                    } else if(level < 15){
                        soTien = 20000000;
                    } else {
                        soTien = 150000000;
                    }
                }
                bangXepHang.setSoTien(soTien);
                db.insertBXH(bangXepHang);
                soTien = 0;
                level = 0;
                dismiss();
                break;
            case R.id.btnHuy:
                dismiss();
        }
    }
}

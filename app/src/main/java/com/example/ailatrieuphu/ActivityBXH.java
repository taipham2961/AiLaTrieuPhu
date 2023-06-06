package com.example.ailatrieuphu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityBXH extends AppCompatActivity implements AdapterBXH.IGetBXH{
    private DatabaseALTP db;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bang_xep_hang);
        db  = new DatabaseALTP(this);
        if (db != null) {
            db.getBXH();
        }
        AdapterBXH adapterBXH = new AdapterBXH((AdapterBXH.IGetBXH) this);
        recyclerView = findViewById(R.id.rc_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterBXH);
    }

    public int getCount() {
        if (db == null) {
            return 0;
        }
        return db.getListBXH().size();
    }

    public BangXepHang getItems(int position) {
        return db.getListBXH().get(position);
    }
}

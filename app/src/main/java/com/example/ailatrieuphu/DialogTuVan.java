package com.example.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DialogTuVan extends Dialog {
    private BarChart barChart;
    private int yA, yB, yC, yD;
    private Random rd;
    private List<TextView> listAns;

    public DialogTuVan(@NonNull Context context, Boolean percent, List<TextView> l){
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_tuvan);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        barChart = findViewById(R.id.bieuDo);
        listAns = l;
        if(percent){
            setBarChart();
        } else {
            setBarChartPercent();
        }
        setData();
    }

    private void setBarChart(){
        switch (ActivityChoiGame.tvTrue.substring(0, 1)) {
            case "A":
                rd = new Random();
                yC = rd.nextInt(20);
                yD = rd.nextInt(20);
                yA = rd.nextInt(100 - yB - yC - yD);
                break;
            case "B":
                rd = new Random();
                yA = rd.nextInt(20);
                yC = rd.nextInt(20);
                yD = rd.nextInt(20);
                yB = rd.nextInt(100 - yA - yC - yD);
                break;
            case "C":
                rd = new Random();
                yA = rd.nextInt(20);
                yB = rd.nextInt(20);
                yD = rd.nextInt(20);
                yC = rd.nextInt(100 - yB - yA - yD);
                break;
            case "D":
                rd = new Random();
                yA = rd.nextInt(20);
                yC = rd.nextInt(20);
                yB = rd.nextInt(20);
                yD = rd.nextInt(100 - yB - yC - yA);
                break;
        }
    }

    private void setBarChartPercent(){
        switch (ActivityChoiGame.tvTrue.substring(0, 1)) {
            case "A":
                rd = new Random();
                if(listAns.get(1).getText().toString().equals("")){
                    yB = 0;
                } else {
                    yB = rd.nextInt(50);
                }
                if(listAns.get(2).getText().toString().equals("")){
                    yC = 0;
                } else {
                    yC = rd.nextInt(50);
                }
                if(listAns.get(3).getText().toString().equals("")){
                    yD = 0;
                } else {
                    yD = rd.nextInt(50);
                }
                yA = rd.nextInt(100 - yB - yC - yD);
                break;
            case "B":
                rd = new Random();
                if(listAns.get(0).getText().toString().equals("")){
                    yA = 0;
                } else {
                    yA = rd.nextInt(50);
                }
                if(listAns.get(2).getText().toString().equals("")){
                    yC = 0;
                } else {
                    yC = rd.nextInt(50);
                }
                if(listAns.get(3).getText().toString().equals("")){
                    yD = 0;
                } else {
                    yD = rd.nextInt(50);
                }
                yB = rd.nextInt(100 - yA - yC - yD);
                break;
            case "C":
                rd = new Random();
                if(listAns.get(0).getText().toString().equals("")){
                    yA = 0;
                } else {
                    yA = rd.nextInt(50);
                }
                if(listAns.get(1).getText().toString().equals("")){
                    yB = 0;
                } else {
                    yB = rd.nextInt(50);
                }
                if(listAns.get(3).getText().toString().equals("")){
                    yD = 0;
                } else {
                    yD = rd.nextInt(50);
                }
                yC = rd.nextInt(100 - yA - yB - yD);
                break;
            case "D":
                rd = new Random();
                if(listAns.get(0).getText().toString().equals("")){
                    yA = 0;
                } else {
                    yA = rd.nextInt(50);
                }
                if(listAns.get(1).getText().toString().equals("")){
                    yB = 0;
                } else {
                    yB = rd.nextInt(50);
                }
                if(listAns.get(2).getText().toString().equals("")){
                    yC = 0;
                } else {
                    yC = rd.nextInt(50);
                }
                yD = rd.nextInt(100 - yB - yC - yA);
                break;
        }
    }

    private void setData(){
        List<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(0f, yA));
        barEntries.add(new BarEntry(1f, yB));
        barEntries.add(new BarEntry(2f, yC));
        barEntries.add(new BarEntry(3f, yD));

        BarDataSet barDataSet = new BarDataSet(barEntries, "");

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.setTouchEnabled(false);
        barChart.setDragEnabled(false);
        barChart.setScaleEnabled(false);
    }
}

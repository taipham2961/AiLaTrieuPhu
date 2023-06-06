package com.example.ailatrieuphu;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseALTP {
    private static final String DB_NAME = "trieuphu_games";
    private final String pathDb;
    public static CauHoi cauHoi;
    public BangXepHang bangXepHang;
    private List<BangXepHang> listBXH = new ArrayList<>();
    public static String cauTraLoi;
    public static int num = 1;
    Cursor c, cBXH;
    private String name;
    private int tien;
    private int level;
    public static boolean checkDapAn;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public List<BangXepHang> getListBXH() {
        return listBXH;
    }

    public void setListBXH(List<BangXepHang> listBXH) {
        this.listBXH = listBXH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        DatabaseALTP.num = num;
    }

    public static boolean isCheckDapAn() {
        return checkDapAn;
    }

    public static void setCheckDapAn(boolean checkDapAn) {
        DatabaseALTP.checkDapAn = checkDapAn;
    }

    public DatabaseALTP(Context context){
        this.context = context;
        pathDb = Environment.getDataDirectory()
                + File.separator + "data"
                + File.separator + context.getPackageName()
                + File.separator + "database"
                + File.separator + DB_NAME;
    }

    private void copyDB(){
        String path = Environment.getDataDirectory()
                + File.separator + "data"
                + File.separator + context.getPackageName()
                + File.separator + "database";
        new File(path).mkdir();
        File file = new File(pathDb);
        if(file.exists()){
            return;
        }
        //Copy database
        AssetManager manager = context.getAssets();
        try{
            InputStream in = manager.open(DB_NAME);
            OutputStream out = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int le = in.read(b);
            while (le > -1){
                out.write(b, 0, le);
                le = in.read(b);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDB() {
        copyDB();
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            sqLiteDatabase = SQLiteDatabase.openDatabase(pathDb, null,
                            SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public void closeDB() {
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }

    public List<CauHoi> query15CauHoi(){
        List<CauHoi> listCauHoi = new ArrayList<>();
        openDB();
        if(num == 1){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =1 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 2){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =2 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 3){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =3 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 4){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =4 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 5){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =5 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 6){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =6 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 7){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =7 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 8){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =8 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 9){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =9 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 10){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =10 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 11){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =11 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 12){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =12 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 13){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =13 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 14){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =14 limit 1",  null);
            checkDapAn = false;
        }

        if(num == 15){
            c = sqLiteDatabase.rawQuery(
                    "SELECT * FROM ( SELECT * FROM question ORDER BY RANDOM() )  where level =15 limit 1",  null);
            checkDapAn = false;
        }

        while (true){
            if(c != null){
                int indexId = c.getColumnIndex("id");
                int indexLevel = c.getColumnIndex("level");
                int indexCauHoi = c.getColumnIndex("ask");
                int indexA = c.getColumnIndex("ra");
                int indexB = c.getColumnIndex("rb");
                int indexC = c.getColumnIndex("rc");
                int indexD = c.getColumnIndex("rd");
                c.moveToFirst();

                int id = c.getInt(indexId);
                String ask = c.getString(indexCauHoi);
                String ra = c.getString(indexA);
                String rb = c.getString(indexB);
                String rc = c.getString(indexC);
                String rd = c.getString(indexD);
                int level = c.getInt(indexLevel);
                cauTraLoi = ra;

                List<String> listDapAn = new ArrayList<>();
                listDapAn.add(ra);
                listDapAn.add(rb);
                listDapAn.add(rc);
                listDapAn.add(rd);
                Collections.shuffle(listDapAn);
                cauHoi = new CauHoi();
                cauHoi.setLevel(level);
                cauHoi.setId(id);
                cauHoi.setCauHoi(ask);
                cauHoi.setA(listDapAn.get(0));
                cauHoi.setB(listDapAn.get(1));
                cauHoi.setD(listDapAn.get(2));
                cauHoi.setC(listDapAn.get(3));
                listCauHoi.add(cauHoi);
                c.moveToNext();
                c.close();
            }
            closeDB();
            return listCauHoi;
        }
    }

    public void getBXH(){
        openDB();
        cBXH = sqLiteDatabase.rawQuery(
                "SELECT * FROM hight_score  ORDER BY level_pass DESC",null);
        if(cBXH == null){
            return;
        }
        while (cBXH .moveToNext()){
            int indexName = cBXH.getColumnIndex("name");
            int indexSoLevel = cBXH.getColumnIndex("level_pass");
            int indexSoTien = cBXH.getColumnIndex("money");
            bangXepHang = new BangXepHang();
            name = cBXH.getString(indexName);
            tien = cBXH.getInt(indexSoTien);
            level = cBXH.getInt(indexSoLevel);
            bangXepHang.setName(name);
            bangXepHang.setSoTien(tien);
            bangXepHang.setSoLevel(level);
            listBXH.add(bangXepHang);
        }
        cBXH.close();
        closeDB();
    }

    public void insertBXH(BangXepHang bangXepHang){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bangXepHang.getName());
        contentValues.put("level_pass", bangXepHang.getSoLevel());
        contentValues.put("money", bangXepHang.getSoTien());
        openDB();
        Cursor query = sqLiteDatabase.rawQuery(
                ("SELECT * FROM hight_score WHERE TRIM(name) = '" +
                        bangXepHang.getName().trim() + "'"), null);
        if(query.moveToFirst()){
            int indexSoTien = query.getColumnIndex("money");
            int tien = query.getInt(indexSoTien);
            if(tien < bangXepHang.getSoTien()){
                updateBXH(bangXepHang.getName(),
                        bangXepHang.getSoLevel(), bangXepHang.getSoTien());
            }
        } else {
            int index = (int) sqLiteDatabase.insert(
                    "hight_score", null, contentValues);
            if(index > 0){
                Log.d("ALTP", "Thêm thành công!");
            } else {
                Log.d("ALTP", "Thêm thất bại!!!");
            }
        }
        query.close();
        closeDB();
    }

    public void updateBXH(String name, int level, int money){
        openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("level_pass", level);
        contentValues.put("money", money);
        int index = sqLiteDatabase.update(
                "hight_score", contentValues,
                "name=?", new String[]{name + ""});
        if(index > 0){
            Log.d("ALTP", "Cập nhật thành công!");
        } else {
            Log.d("ALTP", "Cập nhật thất bại!!!");
        }
        closeDB();
    }
}
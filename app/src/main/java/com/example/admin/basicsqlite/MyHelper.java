package com.example.admin.basicsqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyHelper extends SQLiteOpenHelper
{
    private static  final String dbname="mydb";
    private static final int version=5;

    public MyHelper(Context context)
    {
        super(context, dbname, null, version);
    }

    //Call only One Time when table is not created
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE PRODUCTS(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DES TEXT,PRICE REAL)";
        sqLiteDatabase.execSQL(sql);

        //insert
        insertdata("Jam","Fruit jam",300.50,sqLiteDatabase);
        insertdata("Bread","Brown Bread",25.00,sqLiteDatabase);
        insertdata("Butter","Amul Butter",24.2,sqLiteDatabase);
    }

    private  void insertdata(String name,String desc,double price,SQLiteDatabase database)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("DES",desc);
        contentValues.put("PRICE",price);
        database.insert("PRODUCTS",null,contentValues);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


    }
}

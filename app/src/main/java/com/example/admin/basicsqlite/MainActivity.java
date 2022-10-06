package com.example.admin.basicsqlite;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getReadableDatabase();

        //UPDATE RECORDS IN TABLE PRODUCTS
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("PRICE",280);
        db.update("PRODUCTS",values,"_id=?",new String[]{"1"});

        //DELETE RECORDS IN TABLE PRODUCTS
        db.delete("PRODUCTS","_id=?",new String[]{"1"});

        Cursor cursor=database.rawQuery("select name,price from products",new String[]{});

        if (cursor!=null)
        {
            cursor.moveToFirst();
        }

        StringBuilder builder=new StringBuilder();
        do {
            String name=cursor.getString(0);
            double price=cursor.getDouble(1);
            builder.append("Name: "+name+"\tPrice: "+price+"\n");
        }while (cursor.moveToNext());

        TextView textView=(TextView)findViewById(R.id.data);
        textView.setText(builder.toString());

    }
}

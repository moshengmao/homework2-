package com.example.lenovo.shop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class SpecialstoreActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    Boolean bBoolean=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specialstore);
        dbHelper= new MyDatabaseHelper(this, "Shop.db", null, 1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Button button1=(Button) findViewById(R.id.btn1);
        TextView tv=(TextView)findViewById(R.id.tv);
        Intent intent=getIntent();
        int data = intent.getIntExtra("extra_data1",1);
        String data2=intent.getStringExtra("extra_data");
        final String data1=Integer.toString(data);
        Cursor cursor = db.query("Shop", new String[]{"id"},"id=?", new String[]{data1},null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
            }
            while (cursor.moveToNext());
        }
        Cursor cursor1 = db.query("Shop", new String[]{"bossId"},"bossId=?", new String[]{data2},null, null, null);
        if (cursor1.moveToFirst()) {
            do {
            int amount=cursor1.getCount();
            if(amount==0){bBoolean=true;
            }}
            while (cursor1.moveToNext());
        }
        String name = cursor.getString(cursor.getColumnIndex("name"));
        tv.setText(name);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SpecialstoreActivity.this,GoodsActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Shop", "id= ?", new String[]{data1});
                Toast.makeText(SpecialstoreActivity.this, "删除完成", Toast.LENGTH_SHORT).show();
            }});
            }
    }

package com.example.lenovo.shop;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddstoreActivity extends AppCompatActivity {
    //其实这个是添加店铺的activity
    private MyDatabaseHelper dbHelper;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstore);
        dbHelper = new  MyDatabaseHelper(this, "Shop.db", null, 1);
        //Intent intent=getIntent();
        //String data = intent.getStringExtra("extra_data");
        EditText editText1 = (EditText) findViewById(R.id.et1);
        EditText editText2 = (EditText) findViewById(R.id.et2);
        Button button1 = (Button) findViewById(R.id.btn1);
        //检查之前是否建过数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Person", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));

            }
            while (cursor.moveToNext());}
            cursor.close();     //用过之后记得调用cursor的close函数

            String et_text1 = editText1.getText().toString();
            String et_text2 = editText2.getText().toString();

            ContentValues values = new ContentValues();
            //开始组装第一条数据
            values.put("name", et_text1);
            values.put("bossName", et_text2);
            db.insert("Shop", null, values);
         Toast.makeText(AddstoreActivity.this, "添加完成", Toast.LENGTH_SHORT).show();

         button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AddstoreActivity.this, StoreActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


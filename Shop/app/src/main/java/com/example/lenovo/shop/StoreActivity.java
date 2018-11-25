package com.example.lenovo.shop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import static java.lang.System.out;

public class StoreActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    boolean aBoolean=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);
       Button button1=(Button)findViewById(R.id.btn1);
        //final Intent intent = getIntent();
       // int data = intent.getIntExtra("extra_data",1);
       // final String data1=Integer.toString(data);
     dbHelper= new MyDatabaseHelper(this, "Shop.db", null, 1);
        SQLiteDatabase db =dbHelper.getWritableDatabase();
       // Cursor cursor = db.query("Shop",null, null,null,null, null, null);
         //   if (cursor.moveToFirst()) {
           //     do {
             //       int id = cursor.getInt(cursor.getColumnIndex("id"));
               //     String name = cursor.getString(cursor.getColumnIndex("name"));
                 //   aBoolean = true;
                //}
                /*while (cursor.moveToNext());
                cursor.close();     //用过之后记得调用cursor的close函数
            }//
        //若id存在(aBoolean是对的)，就跳转时传值到goods表里；若不存在，就跳转到空白页
        if(aBoolean) { button1.setText("管理店铺");}
        final int id = cursor.getInt(cursor.getColumnIndex("id"));
       */ button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /* if(aBoolean) {Intent intent=new Intent(StoreActivity.this,SpecialstoreActivity.class);
                intent.putExtra("extra_data1", id);
                //intent.putExtra("extra_data", data1);
                startActivity(intent);}
                else{Intent intent=new Intent(StoreActivity.this,AddstoreActivity.class);
                 //intent.putExtra("extra_data",data1);
                */
                Intent intent=new Intent(StoreActivity.this,GoodsItemActivity.class);
              startActivity(intent);}
        } );}}



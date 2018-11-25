package com.example.lenovo.shop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by lenovo on 2018/11/20.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_GOODS= "create table Phone ("
            + "id integer primary key autoincrement, "
            + "image integer，"
            + "price real, "
            + "name text)";
    private static final String CREATE_PERSON = "create table Person ("
            + "id integer primary key autoincrement, "
            + "name text, "
            +"phoneNumber text,"
            + "password text)";
    private static final String CREATE_SHOP="create table Shop("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"bossName text)";
    private  static final String CREATE_FORMALORDER="create table FormalOrder("
            +"id integer primary key autoincrement, "
            +"goods text,"
            +"price double)";

    private Context mContext;

    //构造函数
    public  MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GOODS);
        db.execSQL(CREATE_PERSON);
        db.execSQL(CREATE_FORMALORDER);
        db.execSQL(CREATE_SHOP);
        Toast.makeText(mContext, "创建成功", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Goods");
        db.execSQL("drop table if exists Person");
        db.execSQL("drop table if exists FormalOrder ");//升级数据库 = 删掉可能存在的旧表 + 创建新表
        db.execSQL("drop table if exists Shop");
        onCreate(db);
    }
}
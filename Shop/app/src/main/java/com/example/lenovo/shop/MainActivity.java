package com.example.lenovo.shop;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private  MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new  MyDatabaseHelper(this, "Shop.db", null, 1);
        Button button1 =(Button) findViewById(R.id.confirm);
        Button button2 = (Button) findViewById(R.id.register);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddstoreActivity.class);
                //intent.putExtra("extra_data",Person.id);
                startActivity(intent);
            }});


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //register
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }});
    }
}





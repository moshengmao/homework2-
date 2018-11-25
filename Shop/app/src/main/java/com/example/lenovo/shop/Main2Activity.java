/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.lenovo.shop;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 * MainActivity class that loads {@link MainFragment}.
 */
public class Main2Activity extends Activity  {
    private  MyDatabaseHelper dbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        dbHelper = new  MyDatabaseHelper(this, "Shop.db", null, 1);
        Button button1 = (Button) findViewById(R.id.confirm);
        Button button2=(Button)findViewById(R.id.fanhui);
        final EditText editText1=(EditText) findViewById(R.id.edittext1);
        final EditText editText2=(EditText) findViewById(R.id.edittext2);
        final EditText editText3=(EditText) findViewById(R.id.edittext3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editText1.getText().toString();
                //editText2密码，editText3手机号
                String text3 = editText3.getText().toString();
                String text2 = editText2.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", text1);
                values.put("passWord", text2);
                values.put("phoneNumber",text3);
                db.insert("Person", null, values);
                String inputText = getString(R.string.zhuce成功);
                Toast.makeText(Main2Activity.this, inputText, Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Main2Activity.this, MainActivity.class);
               startActivity(intent);
           }});

    }
}



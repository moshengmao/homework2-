package com.example.lenovo.shop;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GoodsItemActivity extends AppCompatActivity {
    public static final int TAKE_PHOTO = 1;
    private ImageView picture;
    private Uri imageUri;
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_item);
        dbHelper = new MyDatabaseHelper(this, "Shop.db", null, 1);
        Button button1 = (Button) findViewById(R.id.btn1);//1是删，2是改，3是买
        Button button2 = (Button) findViewById(R.id.btn2);
        Button button3 = (Button) findViewById(R.id.btn3);
        Button button4= (Button) findViewById(R.id.btn4);

        final EditText tv_1 = (EditText) findViewById(R.id.tv1);
        final EditText tv_2 = (EditText) findViewById(R.id.tv2);
        final EditText et_3 = (EditText) findViewById(R.id.et3);
        final EditText et_4 = (EditText) findViewById(R.id.et4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", tv_1.getText().toString());
                values.put("price", tv_2.getText().toString());
                db.insert("Goods", null, values);
                Toast.makeText(GoodsItemActivity.this, "添加完成", Toast.LENGTH_SHORT).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Goods", "name = ?", new String[] {tv_1.getText().toString()});
                Toast.makeText(GoodsItemActivity.this, "删除完成", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values  = new ContentValues();
                values.put("price", et_3.getText().toString());
                values.put("name", et_4.getText().toString());
                db.update("Goods", values, "name = ?", new String[] {"The Da Vinci Code"});
                Toast.makeText(GoodsItemActivity.this, "修改完成", Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", tv_1.getText().toString());
                values.put("price", tv_2.getText().toString());
                values.put("bossId", "extra_data");
                db.insert("FormalOrder", null, values);
                Toast.makeText(GoodsItemActivity.this, "添加完成", Toast.LENGTH_SHORT).show();
            }
        });
        Button takePhoto = (Button) findViewById(R.id.take_photo);
        picture = (ImageView) findViewById(R.id.picture);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputImage = new File(getExternalCacheDir(),
                        "output_image.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    imageUri = FileProvider.getUriForFile(GoodsItemActivity.this,
                            "com.example.cameraalbumtest.fileprovider", outputImage);
                } else {
                    imageUri = Uri.fromFile(outputImage);
                }
                //启动相机程序
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (requestCode == RESULT_OK) {
                    try {
                        //显示派出的照片
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }
}




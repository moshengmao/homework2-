package com.example.lenovo.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends AppCompatActivity {
    private List<Goods> mGoodsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        GoodsAdapter  GoodsAdapter = new GoodsAdapter(mGoodsList);
        recyclerView.setAdapter(GoodsAdapter);

    }

        }



package com.example.lenovo.shop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by lenovo on 2018/11/25.
 */


    public class GoodsAdapter extends RecyclerView.Adapter<com.example.lenovo.shop.GoodsAdapter.ViewHolder>{
        //私有成员变量mGoodsList
        private List<Goods > mGoodsList;
        static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView goodsImage;
            TextView goodsPrice;
            TextView goodsName;
            View goodsView;//这个view指的是自身（这个一整个item）
            public ViewHolder(View view){
                super(view);
                goodsView=view;
                //这个phoneView绑定的是自身（这个一整个item）
                goodsImage=(ImageView)view.findViewById(R.id.iv_image);
                goodsName=(TextView)view.findViewById(R.id.tv_name);
                goodsPrice=(TextView) view.findViewById(R.id.tv_price);
            }
        }
        //实现PhoneAdapter的构造函数
        public GoodsAdapter(List<Goods> GoodsList) {mGoodsList = GoodsList;
        }
        @Override
        public com.example.lenovo.shop.GoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                                  int viewType) {
            View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.goods_item, parent, false);
            final com.example.lenovo.shop.GoodsAdapter.ViewHolder holder = new com.example.lenovo.shop.GoodsAdapter.ViewHolder(view);
            //在viewHolder里设置item_phone.xml里iv_image按钮的点击事件
            holder.goodsPrice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //注意下面这两行是学姐写的
                    int position = holder.getAdapterPosition();
                    Goods goods = mGoodsList.get(position);
                    //注意makeText里的getContext和getName是学姐写的
                    Toast.makeText(view.getContext(),
                            goods.getName(),
                            Toast.LENGTH_SHORT).show();
                }
            });
            return holder;
        }
        @Override
        public void onBindViewHolder(com.example.lenovo.shop.GoodsAdapter.ViewHolder holder, int position) {
            Goods goods = mGoodsList.get(position);
            holder.goodsImage.setImageResource(goods.getImageId());
            holder.goodsName.setText(goods.getName());
            holder.goodsPrice.setText(String.valueOf(goods.getPrice()));
        }
        @Override
        public int getItemCount() {
            return mGoodsList.size();
        }
    }





package com.example.java_zhcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}


















/*
        list.add(R.mipmap.dangjian_banner1);
        list.add(R.mipmap.dangjian_banner2);
        list.add(R.mipmap.dangjian_banner3);
        list.add(R.mipmap.dangjian_banner4);


        Banner banner = findViewById(R.id.banner);

        banner.setAdapter(new BannerImageAdapter<Integer>(list) {

            @Override
            public void onBindView(BannerImageHolder bannerImageHolder, Integer integer, int i, int i1) {
                Glide.with(MainActivity.this).load(integer).into(bannerImageHolder.imageView);
            }
        });*/
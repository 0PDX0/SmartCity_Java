package com.example.java_zhcs.guide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.java_zhcs.R;
import com.example.java_zhcs.Util.App;
import com.example.java_zhcs.Util.RetrofitUtil;
import com.example.java_zhcs.bean.BannerBean;
import com.example.java_zhcs.databinding.ActivityGuideBinding;
import com.google.gson.Gson;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private List<Integer> bannerList = new ArrayList();
    public ActivityGuideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*初始化轮播图*/
        initBanner();

    }

    /**
     * 初始化轮播图
     */
    private void initBanner() {

        bannerList.add(R.mipmap.smartcity1);
        bannerList.add(R.mipmap.smartcity2);
        bannerList.add(R.mipmap.smartcity3);
        bannerList.add(R.mipmap.smartcity4);
        bannerList.add(R.mipmap.smartcity5);

        binding.guideBanner.setAdapter(new BannerImageAdapter<Integer>(bannerList){
            @Override
            public void onBindView(BannerImageHolder bannerImageHolder, Integer integer, int i, int i1) {
                Glide.with(GuideActivity.this).load(integer)
                        .transform(new CenterCrop()).into(bannerImageHolder.imageView);
            }
        }).setIndicator(new CircleIndicator(GuideActivity.this));

        /*引导页轮播请求无效果*/
//        RetrofitUtil.get("/prod-api/api/rotation/list?type=1", new RetrofitUtil.OnRequest() {
//            @Override
//            public void onRequest(String json) {
//                List<BannerBean.RowsDTO> rows = new Gson().fromJson(json, BannerBean.class).getRows();
//
//                binding.guideBanner.setAdapter(new BannerImageAdapter<BannerBean.RowsDTO>(rows){
//
//                    @Override
//                    public void onBindView(BannerImageHolder bannerImageHolder, BannerBean.RowsDTO rowsDTO, int i, int i1) {
//                        Log.e("pdxbanner",rowsDTO.getAdvImg());
//                        Glide.with(GuideActivity.this).load(App.url + rowsDTO.getAdvImg())
//                                .transform(new CenterCrop()).into(bannerImageHolder.imageView);
//                    }
//                }).setIndicator(new CircleIndicator(GuideActivity.this));
//            }
//        });

    }
}


















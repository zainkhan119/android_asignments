package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class introactivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introactivity);

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Fresh Food","",R.drawable.images));
        mList.add(new ScreenItem("Fast Delivery","",R.drawable.images1));
        mList.add(new ScreenItem("Easy Payment","",R.drawable.images2));


        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);


    }
}

package com.example.ug.viewpagerexample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        CustomAdapter adapter = new CustomAdapter(getLayoutInflater());
        pager.setAdapter(adapter);
    }

    public void mOnClick(View v) {
        int position;

        switch(v.getId()) {
            case R.id.btn_previous :
                position = pager.getCurrentItem();
                pager.setCurrentItem(position - 1, true);
                break;

            case R.id.btn_next :
                position = pager.getCurrentItem();
                pager.setCurrentItem(position + 1, true);
                break;
        }
    }
}

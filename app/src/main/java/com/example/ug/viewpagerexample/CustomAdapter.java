package com.example.ug.viewpagerexample;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by UG on 2016-01-03.
 */
public class CustomAdapter extends PagerAdapter {
    LayoutInflater inflater;
    //ListView에서는 int layout도 있었지만, 여기서는 instantiateItem에서처럼 바로 R.layout.view~ 로 넣어줌

    public CustomAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    //PagerAdapter가 가지고 있는 View의 개수를 리턴
    @Override
    public int getCount() {
        return 10;
    }

    //ViewPager가 현재 보여질 Item(View객체)를 생성할 필요가 있는 때 자동으로 호출
    //ListView에서 getView 같은 것
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        view = inflater.inflate(R.layout.viewpager_childview, null);
        ImageView img = (ImageView)view.findViewById(R.id.img_viewpager_childimage);
        img.setImageResource(R.drawable.gametitle_01 + position);
        container.addView(view); //ViewPager에 만들어낸 View 추가
        return view;
    }

    //화면에 보이지 않는 View 파괴하여 메모리 관리
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    //instantiateItem 메소드에서 리턴된 Object가 View가 맞는지 확인하는 메소드
    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == obj;
    }
}

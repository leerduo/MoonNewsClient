package me.chenfuduo.moonnewsclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import me.chenfuduo.moonnewsclient.utils.WechatTab;

public class TestActivity04 extends AppCompatActivity {

    String[] program_title = {"全部项目", "我参与的", "我创建的"};

    @ViewInject(R.id.tabs)
    WechatTab tabs;

    @ViewInject(R.id.pagerFragmentProgram)
    ViewPager viewPager;

    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test04);
        ViewUtils.inject(this);

        adapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        viewPager.setPageMargin(pageMargin);

        tabs.setViewPager(viewPager);
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ItemFragment itemFragment = new ItemFragment();
            return itemFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return program_title[position];
        }

        @Override
        public int getCount() {
            return program_title.length;
        }
    }
}

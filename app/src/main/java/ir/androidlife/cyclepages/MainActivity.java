package ir.androidlife.cyclepages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HorizontalInfiniteCycleViewPager viewPager;
    List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        viewPager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.view_pager);
        MyAdapter adapter = new MyAdapter(this, movieList);
        viewPager.setAdapter(adapter);
    }

    private void initData() {
        movieList.add(new Movie("پروانه ای زیبا", getString(R.string.long_text),R.drawable.pic1));
        movieList.add(new Movie("فیلم علمی تخیلی", getString(R.string.long_text),R.drawable.pic2));
        movieList.add(new Movie("جاده ای برفی", getString(R.string.long_text),R.drawable.pic3));
    }
}

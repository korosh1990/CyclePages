package ir.androidlife.cyclepages;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mojtaba on 1/27/2019.
 */

public class MyAdapter extends PagerAdapter {

    Context context;
    List<Movie> movieList;

    public MyAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        //کدهای اصلی برنامه
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);
        //مشاهده صفحات
        ImageView movie_image = (ImageView)view.findViewById(R.id.movie_image);
        TextView movie_title = (TextView)view.findViewById(R.id.movie_title);
        TextView movie_description = (TextView)view.findViewById(R.id.movie_description);
        FloatingActionButton btn_fav = (FloatingActionButton)view.findViewById(R.id.btn_fav);

        //Set data
        movie_image.setImageResource(movieList.get(position).getImage());
        movie_title.setText(movieList.get(position).getName());
        movie_description.setText(movieList.get(position).getDescription());

        //Set event click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Click to view , here you can add startActivity
                Toast.makeText(context, ""+movieList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "روی دکمه علاقه مندی ها کلیک شد", Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);
        return view;
    }
}

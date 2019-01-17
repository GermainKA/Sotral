package myactivity.cp16.com.sotral_way.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import myactivity.cp16.com.sotral_way.R;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    Integer [] images={R.drawable.slidesotral8r,
                     R.drawable.servicesotral,
                     R.drawable.slidesotral4r,
                     R.drawable.slidesotral1r,
                     R.drawable.slidesotral2r,
                     R.drawable.logosotral,
                     R.drawable.presentationsotral,
                     R.drawable.slidesotral7r,
                     R.drawable.slidesotral9,};

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object objet) {
        return view == objet;
    }
    @Override
    public Object instantiateItem(ViewGroup  contenair,int position){
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView =(ImageView)view.findViewById(R.id.idunkImageView);
        imageView.setImageResource(images[position]);

        ViewPager vp =(ViewPager)contenair;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp=(ViewPager)container;
        View view =(View)object;
        vp.removeView(view);
    }
}

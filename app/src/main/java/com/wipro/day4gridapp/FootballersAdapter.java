package com.wipro.day4gridapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class FootballersAdapter extends BaseAdapter {
    private Context appContext;
    // Array of Images retrieved from the drawable resource
    public Integer [] arrayOfImages = {R.drawable.lionel_messi, R.drawable.luiz_suarez, R.drawable.busquets, R.drawable.coutinho, R.drawable.dembele,
                                       R.drawable.jordi_alba, R.drawable.pique, R.drawable.rafinha, R.drawable.rakitic, R.drawable.ter_stegen, R.drawable.vidal};

    // Constructor
    FootballersAdapter(Context c) {appContext = c;}

    @Override
    public int getCount() {return arrayOfImages.length;}
    @Override
    public Object getItem(int position) {return null;}
    @Override
    public long getItemId(int position) {return 0;}

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(appContext);
            imageView.setLayoutParams(new GridView.LayoutParams(220, 220));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(arrayOfImages[position]);
        return imageView;
    }
}

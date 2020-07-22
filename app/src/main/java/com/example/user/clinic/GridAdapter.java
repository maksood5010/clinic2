package com.example.user.clinic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    private Context mcontext;
    public  Integer[] mthumbsIds={
            R.drawable.c1, R.drawable.c2,
            R.drawable.c3,R.drawable.c4,
            R.drawable.c5,R.drawable.c6,
            R.drawable.c7,R.drawable.c8,
            R.drawable.c9,R.drawable.c10,
            R.drawable.c11};
    public GridAdapter(Context c)
    {
     mcontext=c;
    }
    @Override
    public int getCount() {
        return mthumbsIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null){
            imageView=new ImageView(mcontext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

        }
        else {
            imageView= (ImageView) convertView;
        }
        imageView.setImageResource(mthumbsIds[position]);
        return imageView;
    }

}

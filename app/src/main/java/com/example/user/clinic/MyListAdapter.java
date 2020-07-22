package com.example.user.clinic;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private final Activity context;


    private LayoutInflater inflater;
    MyListAdapter(Activity context) {

        this.context=context;
        inflater = context.getLayoutInflater();

    }
    static class ViewHolderItem {
        TextView textviewitem1,textviewitem2;
        ImageView imageView;


}

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;

        if(convertView==null){
            // inflate the layout

            convertView = inflater.inflate(R.layout.activity_listview, parent, false);


            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.textviewitem1 =  convertView.findViewById(R.id.textview01);
            viewHolder.textviewitem2 =  convertView.findViewById(R.id.textview02);
            viewHolder.imageView =  convertView.findViewById(R.id.image1);
  //          viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        }else{
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolderItem) convertView.getTag();
        }
//        viewHolder.imageView.setImageResource(imgid[position]);
        viewHolder.textviewitem1.setText(users.get(position).getName());
        viewHolder.textviewitem2.setText(users.get(position).getEmail());


        return convertView;
    }

    private List<User> users = new ArrayList<>();
    void setdata(List<User> users) {
        this.users = users;
        Log.d("MAK_TAG","List size"+users.size());
        notifyDataSetChanged();
    }


}

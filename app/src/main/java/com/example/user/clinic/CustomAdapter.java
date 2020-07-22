package com.example.user.clinic;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;
    private Rcycle c;
    private Boolean flag=true;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

       //view.setOnClickListener(Rcycle.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int listPosition) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.specialisation;
        TextView textView=holder.Age;
        ImageView imageView = holder.imageViewIcon;
        final Button Book= holder.booking;


        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    c.permission();
                    Book.setText("Booked");
                    flag=false;

                }
                else if (!flag){

                    Book.setText("Book appointment");
                    flag=true;
                }

            }
        });
        textViewName.setText(dataSet.get(listPosition).name);
        textViewVersion.setText(dataSet.get(listPosition).age);
//        imageView.setImageResource(dataSet.get(listPosition).);
        textView.setText(dataSet.get(listPosition).salary);


    } public CustomAdapter(ArrayList<DataModel> data, Rcycle rcycle) {
        this.dataSet = data;
        this.c=rcycle;

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView specialisation;
        TextView Age;
        Button booking;
        ImageView imageViewIcon;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.booking=(Button) itemView.findViewById(R.id.book);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.specialisation = (TextView) itemView.findViewById(R.id.Specialisation);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
            this.Age= itemView.findViewById(R.id.rating_bar);
        }
    }
}

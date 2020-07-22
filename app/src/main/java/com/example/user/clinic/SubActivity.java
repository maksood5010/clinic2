package com.example.user.clinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SubActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent in=getIntent();
        Integer i=in.getExtras().getInt("id");
        GridAdapter gridAdapter=new GridAdapter(this);
        imageView=(ImageView)findViewById(R.id.image2);
        imageView.setImageResource(gridAdapter.mthumbsIds[i]);


    }
}

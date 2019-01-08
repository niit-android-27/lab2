package com.luan.myapp.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class ActivityTwo extends AppCompatActivity {
    //mock data
    int[] images = new int[]{
        R.drawable.avt1,
            R.drawable.avt2,
            R.drawable.avt3,
            R.drawable.avt4,
            R.drawable.avt5,
            R.drawable.avt6,
            R.drawable.avt7,
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        GridView gridView =(GridView)findViewById(R.id.gridView);
        MyImageAdapter myImageAdapter = new MyImageAdapter(ActivityTwo.this,images);
        gridView.setAdapter(myImageAdapter);
    }
}

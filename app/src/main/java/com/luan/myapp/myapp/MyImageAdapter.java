package com.luan.myapp.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyImageAdapter extends BaseAdapter {
    Context context;
    int[] images;
    LayoutInflater inflater;

    public MyImageAdapter(Context context,
                          int[] images) {
        this.context = context;
        this.images = images;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view = inflater.inflate(R.layout.item_image, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imgView);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.imageView.setImageResource(images[i]);
        return view;
    }

    class ViewHolder{
        ImageView imageView;
    }
}

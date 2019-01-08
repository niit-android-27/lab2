package com.luan.myapp.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<User>{
    Context context;
    int resource;
    ArrayList<User> users;
    LayoutInflater inflater;
    public MyAdapter(@NonNull Context context,
                     int resource,
                     @NonNull ArrayList<User> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.users=objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        Log.e("ConverView",(convertView==null)+"");
        if(convertView==null){
            convertView = inflater.inflate(resource, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
        tvName.setText(getItem(position).getName());
        tvPhone.setText(getItem(position).getPhone());
        return convertView;
    }
}

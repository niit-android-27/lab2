package com.luan.myapp.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter{
    Context context;
    int resources;
    ArrayList<User> users;
    LayoutInflater inflater;
    public MyBaseAdapter(Context context,
                         int resources,
                         ArrayList<User> users) {
        this.context= context;
        this.resources=resources;
        this.users=users;
        inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int i) {
        return this.users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view = inflater.inflate(resources, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView)view.findViewById(R.id.tvName);
            viewHolder.tvPhone=(TextView)view.findViewById(R.id.tvPhone);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.tvName.setText(users.get(i).getName());
        viewHolder.tvPhone.setText(users.get(i).getPhone());
        return view;
    }

    class ViewHolder{
        TextView tvName;
        TextView tvPhone;
    }
}

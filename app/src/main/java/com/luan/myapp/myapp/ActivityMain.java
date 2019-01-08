package com.luan.myapp.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {
    //EditText edtFullName,edtUserName,edtPassword,edtAddress;
    //Button btnSubmit;
    ArrayList<User> users = new ArrayList<>();
    void _generateData(){
        for (int i=0;i<50;i++){
            User user = new User();
            user.setId(i);
            user.setName("Ten "+i);
            user.setPhone("012345586 "+i);
            users.add(user);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tao mock data
        this._generateData();
        setContentView(R.layout.list_user);
        ListView listView = (ListView)findViewById(R.id.lstUser);
//        MyAdapter myAdapter =new MyAdapter(ActivityMain.this,
//                R.layout.item_listview,
//                users);
        final MyBaseAdapter myAdapter = new MyBaseAdapter(ActivityMain.this,
                R.layout.item_listview,users);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityMain.this,users.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
               if(i+i1 >= i2){
                   //loading more
                   Log.e("Loading more","Loading more");
                   for (int j=0;j<10;j++){
                       User user = new User();
                       user.setId(j);
                       user.setName("Ten "+j);
                       user.setPhone("012345586 "+j);
                       users.add(user);
                   }
                   myAdapter.notifyDataSetChanged();
               }
            }
        });




        //setContentView(R.layout.activity_main);
        /*edtFullName =(EditText)findViewById(R.id.edtFullName);
        edtUserName = (EditText)findViewById(R.id.edtUserName);
        edtAddress=(EditText)findViewById(R.id.edtAddress);
        edtPassword=(EditText)findViewById(R.id.edtPwd);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String txtFullName = edtFullName.getText().toString();
               String txtUserName = edtUserName.getText().toString();
               String txtAddress = edtAddress.getText().toString();
               Toast.makeText(getApplicationContext(),
                       "FullName"+txtFullName+"&txtUserName"+txtFullName,
                       Toast.LENGTH_SHORT).show();
            }
        });*/
    }


}

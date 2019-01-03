package com.luan.myapp.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    EditText edtFullName,edtUserName,edtPassword,edtAddress;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFullName =(EditText)findViewById(R.id.edtFullName);
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
        });
    }
}

package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demotxt.myapp.myapplication.DbHelper;
import com.demotxt.myapp.myapplication.R;

public class Loginpage extends AppCompatActivity {
    EditText username,password;
    Button signin;
    DbHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        signin=(Button) findViewById(R.id.btnsignin1);
        DB = new DbHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(Loginpage.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==false){
                        Toast.makeText(Loginpage.this,"user credantials invalid",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(Loginpage.this,"Login successfull",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }

            }


        });
    }
}
package com.androidgroup.view.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.database.UserService;

public class RegisterActivity extends AppCompatActivity {

    private UserService userService;
    private EditText name;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.register);
            userService=new UserService(RegisterActivity.this);//通过userServer进行注册
        name=(EditText)findViewById(R.id.et_username_r);
        pass=(EditText)findViewById(R.id.et_password_r);
        ImageView toMyzone=(ImageView)findViewById(R.id.exit_home);
        toMyzone.setOnClickListener(
                new View.OnClickListener(){
                    public  void onClick(View v){
                        finish();//关闭当前activity
                    }

                }
        );
        Button toRegister=(Button) findViewById(R.id.btn_register);
//        toLogin.setOnClickListener(
//                new View.OnClickListener(){
//                    public  void onClick(View v){
//                        Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                    }
//
//                }
//        );

        toRegister.setOnClickListener(
                new View.OnClickListener(){
                    public  void onClick(View v){
                        boolean flag=userService.register(name.getText().toString(),pass.getText().toString());
                        if(flag){
                            Toast.makeText(MyApplication.getContext(),"注册成功",Toast.LENGTH_SHORT);
                            Intent intent=new Intent(MyApplication.getContext(),LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(MyApplication.getContext(),"注册失败",Toast.LENGTH_SHORT);

                        }
                    }

                }
        );
    }
}

package com.androidgroup.view.system;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidgroup.MainActivity;
import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.database.MyDatabaseHelper;
import com.androidgroup.database.UserService;
import com.luozm.captcha.Captcha;

public class LoginActivity extends AppCompatActivity {

    private String username;
    private String password;
    private FragmentManager fm;
    private UserService userDb;//通过userService对数据库进行操作
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        fm=getSupportFragmentManager();
        userDb= new UserService(LoginActivity.this);
        userDb.insert("feifei","123");
        userDb.insert("qiangqiang","123");
        userDb.insert("liuqing","123");
        userDb.insert("dandan","123");
        ImageView toMine=(ImageView)findViewById(R.id.exit_myzone);
        final EditText et_username=(EditText)findViewById(R.id.et_username);
        final EditText et_password=(EditText)findViewById(R.id.et_password);
//        et_username.setText("fei");
//        et_password.setText("123");
//        username=et_username.getText().toString();
//        password=et_password.getText().toString();
        //final Intent getMain=getIntent();
        Button btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(//登录成功跳转
                new View.OnClickListener(){
                    public void onClick(View v){
                        boolean flags=userDb.login(et_username.getText().toString(),et_password.getText().toString());
                        if(flags){
                            Intent toMain=new Intent(LoginActivity.this, MainActivity.class);
                            Bundle bd=new Bundle();
                            bd.putString("username",et_username.getText().toString());
                            toMain.putExtras(bd);
                            setResult(2,toMain);
                            LoginActivity.this.finish();
                        }
                        else{
                            Toast.makeText(MyApplication.getContext(),"请重新输入正确的用户名或密码！",Toast.LENGTH_SHORT).show();
//                            Intent intent=new Intent(MyApplication.getContext(),RegisterActivity.class);
//                            startActivity(intent);
                        }
                    }
                }
        );

        //返回
        toMine.setOnClickListener(
                new View.OnClickListener(){
                    public  void onClick(View v){
                        Toast.makeText(MyApplication.getContext(),"why?",Toast.LENGTH_SHORT).show();
                    }

                }
        );

        TextView toRegister=(TextView)findViewById(R.id.tv_register);

        //注册

        toRegister.setOnClickListener(
                new View.OnClickListener(){
                    public  void onClick(View v){
                        Intent toRegister=new Intent(LoginActivity.this,RegisterActivity.class);
                        startActivity(toRegister);
                        finish();
                    }

                }
        );



        Captcha captcha = (Captcha) findViewById(R.id.captCha);
     //   captcha.setBitmap("@drawable/cat");
        captcha.setCaptchaListener(new Captcha.CaptchaListener() {
            @Override
            public String onAccess(long time) {
                Toast.makeText(LoginActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
                return "验证通过,耗时"+time+"毫秒";
            }

            @Override
            public String onFailed(int failedCount) {
                Toast.makeText(LoginActivity.this,"验证失败",Toast.LENGTH_SHORT).show();
                return "验证失败,已失败"+failedCount+"次";
            }

            @Override
            public String onMaxFailed() {
                Toast.makeText(LoginActivity.this,"验证超过次数，你的帐号被封锁",Toast.LENGTH_SHORT).show();
                return "验证失败,帐号已封锁";
            }
        });

    }

}

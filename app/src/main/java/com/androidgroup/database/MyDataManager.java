package com.androidgroup.database;

/**
 * Created by silence on 2018/10/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.androidgroup.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
public class MyDataManager {
    public static final String DB_NAME = "wenwen.db"; //数据库名字
    public static final String PACKAGE_NAME ="com.zking.laci.android_project";//包名
    public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + PACKAGE_NAME;   //数据库的绝对路径( /data/data/com.*.*(package name))
    private SQLiteDatabase db;
    private Context context;

    public MyDataManager(Context context) {
        this.context = context;
    }

    //对外提供的打开数据库接口
    public void openDataBase() {
        this.db = this.openDataBase(DB_PATH + "/databases");
    }

    //获取打开后的数据库
    public SQLiteDatabase getDb() {
        return this.db;
    }

    // 本地打开数据方法
    private SQLiteDatabase openDataBase(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) { //判断文件是否存在
                //通过输入流和输出流，把数据库拷贝到"filePath"下
                file.mkdir();
                File file2=new File(filePath+"/"+DB_NAME);
//                if (!file2.exists()) {
//                    InputStream is = context.getResources().openRawResource(R.raw.wenwen);//获取输入流，使用R.raw.test资源
//                    FileOutputStream fos = new FileOutputStream(file2);
//                    byte[] buffer = new byte[1024];
//                    int readCount;
//                    while ((readCount = is.read(buffer)) > 0) {
//                        fos.write(buffer, 0, readCount);
//                    }
//                    fos.close();
//                    is.close();
//                }
            }
//打开数据库
            SQLiteDatabase db =new MyDatabaseHelper(context).getWritableDatabase();
            return db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库
    public  void closeDataBase()
    {
        if(this.db!=null)
            db.close();
    }

}

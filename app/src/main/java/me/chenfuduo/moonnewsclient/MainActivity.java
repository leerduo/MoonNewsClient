package me.chenfuduo.moonnewsclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lidroid.xutils.DbUtils;

import me.chenfuduo.moonnewsclient.domain.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 保存单个对象
     * @param view view对象
     */
    public void button(View view){
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            //创建表
            dbUtils.createTableIfNotExist(Student.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存对象集合
     * @param view view对象
     */
    public void button2(View view){

    }

    /**
     * 查询所有
     * @param view view对象
     */
    public void button3(View view){

    }

    /**
     * 根据id查询
     * @param view view对象
     */
    public void button4(View view){

    }

    /**
     * 根据其他条件查询
     * @param view view对象
     */
    public void button5(View view){

    }

    /**
     * 更新
     * @param view view对象
     */
    public void button6(View view){

    }

    /**
     * 删除
     * @param view view对象
     */
    public void button7(View view){

    }

}

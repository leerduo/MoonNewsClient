package me.chenfuduo.moonnewsclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

import java.util.ArrayList;
import java.util.List;

import me.chenfuduo.moonnewsclient.domain.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 保存单个对象
     *
     * @param view view对象
     */
    public void button(View view) {
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            //创建表
            dbUtils.createTableIfNotExist(Student.class);

            Student student = new Student("zhangsan", 20);

            //保存对象
            dbUtils.save(student);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

    /**
     * 保存对象集合
     *
     * @param view view对象
     */
    public void button2(View view) {
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            List<Student> list = new ArrayList<>();
            list.add(new Student("lisi", 30));
            list.add(new Student("wangwu", 40));
            //保存对象
            dbUtils.saveAll(list);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

    /**
     * 查询所有
     *
     * @param view view对象
     */
    public void button3(View view) {
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            List<Student> students = dbUtils.findAll(Student.class);
            for (Student student : students) {
                Log.e("Test", student.toString() + "   ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

    /**
     * 根据id查询
     *
     * @param view view对象
     */
    public void button4(View view) {
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            Student student = dbUtils.findById(Student.class, 1);
            Log.e("Test", student.toString() + "   ");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

    /**
     * 根据其他条件查询
     *
     * @param view view对象
     */
    public void button5(View view) {
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            List<Student> students = dbUtils.findAll(Selector.from(Student.class).where("age", "==", "30"));
            for (Student student : students) {
                Log.e("Test", student.toString() + "   ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

    /**
     * 更新
     *
     * @param view view对象
     */
    public void button6(View view) {
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            Student student = new Student(1,"duoduo",25);
            dbUtils.update(student, new String[]{"name","age"});
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

    /**
     * 删除
     *
     * @param view view对象
     */
    public void button7(View view) {
        try {
            //创建数据库
            DbUtils dbUtils = DbUtils.create(this, "test.db");
            dbUtils.deleteById(Student.class,3);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

}

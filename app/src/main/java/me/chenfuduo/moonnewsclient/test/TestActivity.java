package me.chenfuduo.moonnewsclient.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

import me.chenfuduo.moonnewsclient.R;

public class TestActivity extends AppCompatActivity {

  /*  @ViewInject(R.id.btnViewUtils)
    private Button btnViewUtils;*/

    @ViewInject(R.id.img)
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_test);
        ViewUtils.inject(this);
       /* btnViewUtils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"ViewUtils测试",Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    /**
     * BitmapUtils的演示
     * @param view
     */
    @OnClick(R.id.btnBitmapUtils)
    public void showImg(View view){
        BitmapUtils bitmapUtils = new BitmapUtils(this);
        String url = "https://www.baidu.com/img/bd_logo1.png";
        bitmapUtils.display(img, url);
    }



    /**
     * ViewUtils测试
     *
     * @param v
     */
    @OnClick(R.id.btnViewUtils)
    public void show(View v) {
        Toast.makeText(TestActivity.this, "ViewUtils测试", Toast.LENGTH_SHORT).show();
    }

    /**
     * HttpUtils演示
     *
     * @param v
     */
    @OnClick(R.id.btnHttpUtils)
    public void get(View v) {
        Toast.makeText(TestActivity.this, "点击了", Toast.LENGTH_SHORT).show();

        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET,
                "http://www.lidroid.com",
                new RequestCallBack<String>() {
                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                        Log.e("Test", "Total-->" + total + "  current--->" + current);
                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String result = responseInfo.result;
                        Log.e("TEST", result);
                    }

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        Log.e("TEST", "失败");
                    }
                });
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
            Student student = new Student(1, "duoduo", 25);
            dbUtils.update(student, new String[]{"name", "age"});
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
            dbUtils.deleteById(Student.class, 3);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Test", "创建失败");
        }
    }

}

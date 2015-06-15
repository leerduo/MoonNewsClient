package me.chenfuduo.moonnewsclient.domain;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2015/6/13.
 *
 * 主键   唯一标示  自增
 */
@Table(name="t_student") //指定表名，如果不指定，那么表名为类名
public class Student {
    //表示是主键 键的名字是属性名
    @Id
    public int _id;

    public String name;

    public int age;

    //如果使用XUtils框架，必须一个无参数的构造器
    //里面的属性最好加上geter/setter方法
    public Student() {
    }

    public Student(int _id, String name, int age) {
        this._id = _id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package me.chenfuduo.moonnewsclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.event.OnClick;

import me.chenfuduo.moonnewsclient.domain.CategoryInfo;

public class TestActivity03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test03);
        ViewUtils.inject(this);
    }

    @OnClick(R.id.get)
    public void get(View view){
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, "http://zhbj.qianlong.com/static/api/news/categories.json", new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
               // Log.e("Test",responseInfo.result);

                String result = responseInfo.result;

                Gson gson = new Gson();

                CategoryInfo categoryInfo = gson.fromJson(result, CategoryInfo.class);

                Log.e("Test",categoryInfo.toString());

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Log.e("Test","请求数据失败:" + s);
            }
        });
    }


}

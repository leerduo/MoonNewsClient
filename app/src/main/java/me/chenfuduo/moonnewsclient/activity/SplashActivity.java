package me.chenfuduo.moonnewsclient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import me.chenfuduo.moonnewsclient.R;
import me.chenfuduo.moonnewsclient.utils.Constants;
import me.chenfuduo.moonnewsclient.utils.SpUtils;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener{

    public static final String TAG = SplashActivity.class.getSimpleName();

    @ViewInject(R.id.ll_root)
    private LinearLayout ll_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ViewUtils.inject(this);

        //动画的效果：旋转，缩放，透明度变化

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    /**
     * onWindowFocusChanged(boolean)在 onResume()之后执行
     *
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e(TAG, "onWindowFocusChanged");


        AnimationSet set = new AnimationSet(false);//传入false表示每个动画使用自己的插值器

        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);

        //缩放动画
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(2000);
        scale.setFillAfter(true);


        //透明度改变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);

        set.addAnimation(rotateAnimation);
        set.addAnimation(scale);
        set.addAnimation(alphaAnimation);

        ll_root.startAnimation(set);

        //动画完成，进入向导界面
        set.setAnimationListener(this);
    }

    private Handler handler = new Handler();

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        handler.postDelayed(new EnterTask(),3000);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private class EnterTask implements Runnable{
        @Override
        public void run() {
            //进入主界面或者向导界面:通过首选项去判断
            boolean hasFinishedGuide = SpUtils.getBoolean(getApplicationContext(), Constants.KEY_HAS_FINISH_GUIDE, false);
            Intent intent = new Intent();
            if (hasFinishedGuide){
                //进入主界面
                intent.setClass(getApplicationContext(),MainActivity.class);
            }else{
                //进入向导界面
                intent.setClass(getApplicationContext(),GuideActivity.class);
            }
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //如果用户按下后退键，把Handler里面的消息清空
        handler.removeCallbacksAndMessages(null);
    }
}

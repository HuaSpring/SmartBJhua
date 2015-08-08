package com.hua.zhbj.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.hua.zhbj.R;
import com.hua.zhbj.utils.PrefUtils;


public class SplashActivity extends Activity {


    private RelativeLayout rlRoot;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rlRoot = (RelativeLayout) findViewById(R.id.rlRoot);
        startAnim();
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpNextPage();
            }
        },3000);


    }

    /**
     * start animation
     */
    private void startAnim(){
        AnimationSet set = new AnimationSet(false);

        RotateAnimation rotate = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        ScaleAnimation scale = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scale.setDuration(1000);
        scale.setFillAfter(true);

        AlphaAnimation alpha = new AlphaAnimation(0,1);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);


        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(alpha);


        rlRoot.startAnimation(set);
    }



    private void jumpNextPage(){
        // 判断之前有没有显示过新手引导

       boolean userGuide = PrefUtils.getBoolean(this,"is_user_showed_guide",false);
        if(!userGuide) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
            finish();
        }
        else{
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    }
}

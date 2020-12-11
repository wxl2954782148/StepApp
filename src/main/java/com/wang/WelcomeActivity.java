package com.wang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

/**
 * 闪屏页
 */
public class WelcomeActivity extends BaseActivity implements View.OnClickListener {
    private Button skipButton;
    private final Handler handler = new Handler();
    private final Runnable runnableToMain = new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        initView();
        handler.postDelayed(runnableToMain, 3000);
    }

    @Override
    public void initView() {
        skipButton = findViewById(R.id.btn_skip);
        skipButton.setOnClickListener(this);
    }

    private void toMainActivity(){
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_skip:
                //防止被两次打开
                handler.removeCallbacks(runnableToMain);
                toMainActivity();
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnableToMain);
    }
}
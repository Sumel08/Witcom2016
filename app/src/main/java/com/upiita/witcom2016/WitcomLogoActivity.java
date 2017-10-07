package com.upiita.witcom2016;

import android.content.Intent;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.upiita.witcom2016.dataBaseHelper.WitcomDataBase;
import com.upiita.witcom2016.pager.WitcomPagerActivity;
import com.upiita.witcom2016.rate.RateActivity;

public class WitcomLogoActivity extends AppCompatActivity {

    public static String URL_BASE = "http://www.sum08.omniversoft.com/witcom";
    public static String CONTENT_VERSION = "0";
    public static String URL_STREAM = "rtmp://148.204.86.75:1935/envivo.upiita/livestream";
    public static String URL_STREAM_LQ = "rtmp://148.204.86.75:1935/envivo.upiita.lq/livestream";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MultiDex.install(getApplicationContext());
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_witcom_logo);

        //getTables();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (getIntent().getStringExtra("conference") != null) {
                    Intent intent = new Intent(WitcomLogoActivity.this, RateActivity.class);
                    intent.putExtra("conference", getIntent().getStringExtra("conference"));
                    startActivity(intent);
                } else {
                    startActivity(new Intent(getApplicationContext(), WitcomPagerActivity.class));
                }
                //startActivity(new Intent(getApplicationContext(), StreamingActivity.class));
            }
        }, 1680);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }
}

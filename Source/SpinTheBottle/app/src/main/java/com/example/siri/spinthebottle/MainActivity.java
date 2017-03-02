package com.example.siri.spinthebottle;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends WearableActivity {

ImageView iv_bottle;

    Button b_go;

    Random r;
    int angle;
    boolean restart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
        iv_bottle = (ImageView) findViewById(R.id.iv_bottle);

        b_go = (Button) findViewById(R.id.b_go);

        b_go.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v) {
                if (restart) {
                    int temp = angle % 360;
                    RotateAnimation rotate = new RotateAnimation(temp, 0,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    iv_bottle.startAnimation(rotate);
                    b_go.setText("GO");

                    restart = false;
                } else {
                    angle = r.nextInt(3600) + 360;
                    RotateAnimation rotate = new RotateAnimation(0, angle, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                    iv_bottle.startAnimation(rotate);
                    restart = true;
                    b_go.setText("RESET");
                }
            }
        });
        }
    }



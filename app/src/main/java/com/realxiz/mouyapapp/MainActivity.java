package com.realxiz.mouyapapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;


import java.util.Random;

public class MainActivity extends Activity {
    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    private TextView tv2;
    ImageView imageView, imageView2;

    Integer[] images = {
            R.drawable.list1,
            R.drawable.list2,
            R.drawable.list3,
            R.drawable.list4,
            R.drawable.list5,
            R.drawable.list6,
            R.drawable.list7,
            R.drawable.list8
    };

    Integer[] images2 = {
            R.drawable.aong,
            R.drawable.arm,
            R.drawable.ball,
            R.drawable.benz,
            R.drawable.dump,
            R.drawable.man,
            R.drawable.tan,
            R.drawable.sket

    };
    Random r = new Random ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mSwitcher = findViewById (R.id.switcher);
        mSwitcher.setFactory (mFactory);
        Animation in = AnimationUtils.loadAnimation (this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation (this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation (in);
        mSwitcher.setOutAnimation (out);
        // END_INCLUDE(setup)


        imageView = (ImageView) findViewById (R.id.imageView);
        imageView2 = (ImageView) findViewById (R.id.imageView2);

        Button nextButton = findViewById (R.id.button);
        nextButton.setOnClickListener (new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                imageView.setImageResource (images[r.nextInt (images.length)]);
                imageView2.setImageResource (images2[r.nextInt (images2.length)]);
                mCounter++;
                mSwitcher.setText ("รอบที่ " + String.valueOf (mCounter));

            }
        });

        // Set the initial text without an animation
        mSwitcher.setCurrentText ("Press > สุ่ม < to Start");

    }

    private ViewFactory mFactory = new ViewFactory () {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView (MainActivity.this);
            t.setGravity (Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance (MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
//

}

package com.example.anderson.w6_p2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv1;
    private EditText et1;
    private CheckBox cb_red;
    private CheckBox cb_green;
    private CheckBox cb_blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        et1 = findViewById(R.id.et1);
        cb_red = findViewById(R.id.cb_red);
        cb_green = findViewById(R.id.cb_green);
        cb_blue = findViewById(R.id.cb_blue);
        cb_red.setOnClickListener(this);
        cb_green.setOnClickListener(this);
        cb_blue.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("tv1", tv1.getText().toString());
        outState.putString("et1", et1.getText().toString());
       ColorDrawable tv_background = (ColorDrawable) tv1.getBackground();
       int tv1color = tv_background.getColor();
        ColorDrawable et_background = (ColorDrawable) tv1.getBackground();
        int et1color = tv_background.getColor();
        outState.putInt("tv11", tv1color);
        outState.putInt("et11", et1color);


        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String tvtext = savedInstanceState.getString("tv1");
        String ettext = savedInstanceState.getString("et1");
        int tvbg = savedInstanceState.getInt("tv11");
        int etbg = savedInstanceState.getInt("et11");
        tv1.setText(tvtext);
        et1.setText(ettext);
        tv1.setBackgroundColor(tvbg);
        et1.setBackgroundColor(etbg);

    }

        public void onClick(View view){
            switch(view.getId()){
                case R.id.cb_red:
                    cb_red.setChecked(true);
                    cb_green.setChecked(false);
                    cb_blue.setChecked(false);
                    tv1.setText("Red");
                    et1.setText("Red");
                    tv1.setBackgroundColor(Color.parseColor("#FF0000"));
                    et1.setBackgroundColor(Color.parseColor("#FF0000"));

                    break;
                case R.id.cb_green:
                    cb_red.setChecked(false);
                    cb_green.setChecked(true);
                    cb_blue.setChecked(false);
                    tv1.setText("Green");
                    et1.setText("Green");

                    tv1.setBackgroundColor(Color.parseColor("#008000"));
                    et1.setBackgroundColor(Color.parseColor("#008000"));
                    break;
                case R.id.cb_blue:
                    cb_red.setChecked(false);
                    cb_green.setChecked(false);
                    cb_blue.setChecked(true);
                    tv1.setText("Blue");
                    et1.setText("Blue");

                    tv1.setBackgroundColor(Color.parseColor("#87ceeb"));
                    et1.setBackgroundColor(Color.parseColor("#87ceeb"));
                    break;

            }
            }

    }



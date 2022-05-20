package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Height_Comparison extends AppCompatActivity {

    TextView lst2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_comparison);
        lst2 = (TextView) findViewById(R.id.list2);
        MyDBHandler dbHandler= new MyDBHandler(this,null,null,2);
        Intent intentH = getIntent();

        String s1 = intentH.getStringExtra("a");
        String s2 = intentH.getStringExtra("b");
        String s3 = intentH.getStringExtra("c");

        int p = Integer.parseInt(s1);
        int q = Integer.parseInt(s2);
        float r =Float.parseFloat(s3);
        int sumAge = p*12+q;
        lst2.setText(dbHandler.loadHandlerH(sumAge,r));
    }
}
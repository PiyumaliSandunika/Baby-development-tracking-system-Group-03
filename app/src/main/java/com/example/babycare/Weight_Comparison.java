package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Weight_Comparison extends AppCompatActivity {

    TextView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_comparison);
        lst = (TextView) findViewById(R.id.list);
        MyDBHandler dbHandler= new MyDBHandler(this,null,null,2);
        Intent intent = getIntent();

        String s1 = intent.getStringExtra("a");
        String s2 = intent.getStringExtra("b");
        String s3 = intent.getStringExtra("c");

        int p = Integer.parseInt(s1);
        int q = Integer.parseInt(s2);
        float r =Float.parseFloat(s3);
        int sumAge = p*12+q;
        lst.setText(dbHandler.loadHandlerW(sumAge,r));


    }
}
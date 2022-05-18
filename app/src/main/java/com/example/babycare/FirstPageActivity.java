package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class FirstPageActivity extends AppCompatActivity {
    public Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        button1 = (Button) findViewById(R.id.btn_signin);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1){
                Intent intent1 = new Intent(FirstPageActivity.this,AddBabyActivity.class);
                startActivity(intent1);
            }
        });

        button2 = (Button) findViewById(R.id.btn_login);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2){
                Intent intent2 = new Intent(FirstPageActivity.this,DashboardActivity.class);
                startActivity(intent2);
            }
        });
    }
}
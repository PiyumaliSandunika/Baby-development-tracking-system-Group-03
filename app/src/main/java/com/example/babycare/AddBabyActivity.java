package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddBabyActivity extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_baby);

        button = (Button) findViewById(R.id.btn_addbaby_done);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(AddBabyActivity.this,VaccinationActivity.class);
                startActivity(intent);
            }
        });
    }
}
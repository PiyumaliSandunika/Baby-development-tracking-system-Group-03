package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.babycare.db.AppDatabase;
import com.example.babycare.db.User_Weight;

public class WeightTrackerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker);

        final EditText ageYearInput =  findViewById(R.id.editText_weight_years);
        final EditText ageMonthInput =  findViewById(R.id.editText_weight_months);
        final EditText weightInput =  findViewById(R.id.editTxt_weight);

        Button backButton =  findViewById(R.id.btn_weight_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeightTrackerActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        Button saveButton =  findViewById(R.id.btn_weight_add);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveNewUser(ageYearInput.getText().toString(), ageMonthInput.getText().toString(),weightInput.getText().toString());

            }
        });
    }
    public void saveNewUser(String ageY, String ageM ,String weightkg) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());


        Intent intent = new Intent(WeightTrackerActivity.this,Weight_Comparison.class);

        intent.putExtra("a",ageY);
        intent.putExtra("b",ageM);
        intent.putExtra("c",weightkg);
        startActivity(intent);

        int ageYInt = Integer.parseInt(ageY);
        int ageMInt = Integer.parseInt(ageM);
        float w = Float.parseFloat(weightkg);


        User_Weight user = new User_Weight();
        user.ageYear = ageY;
        user.ageMonth = ageM;
        user.weight = weightkg;
        user.age = (ageYInt*12)+ageMInt;

        db.userDao().insertUser(user);

        finish();

    }

}
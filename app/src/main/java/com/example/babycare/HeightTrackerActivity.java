package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.babycare.db.AppDatabase;
import com.example.babycare.db.Baby;
import com.example.babycare.db.Baby_Height;
import com.example.babycare.db.User_Weight;

public class HeightTrackerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_tracker);

        final EditText ageYearInput =  findViewById(R.id.editText_height_years);
        final EditText ageMonthInput =  findViewById(R.id.editText_height_months);
        final EditText heightInput =  findViewById(R.id.editTxt_height);

        Button backButton =  findViewById(R.id.btn_height_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeightTrackerActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        Button saveButton =  findViewById(R.id.btn_weight_add);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveNewUser(ageYearInput.getText().toString(), ageMonthInput.getText().toString(),heightInput.getText().toString());

            }
        });
    }
    public void saveNewUser(String ageY, String ageM ,String heightcm) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());


        Intent intent = new Intent(HeightTrackerActivity.this,Height_Comparison.class);

        intent.putExtra("a",ageY);
        intent.putExtra("b",ageM);
        intent.putExtra("c",heightcm);
        startActivity(intent);

        int ageYInt = Integer.parseInt(ageY);
        int ageMInt = Integer.parseInt(ageM);
        float w = Float.parseFloat(heightcm);


        Baby_Height user2 = new Baby_Height();
        user2.ageYear = ageY;
        user2.ageMonth = ageM;
        user2.height = heightcm;
        user2.age = (ageYInt*12)+ageMInt;

        //db.HeightDao().insertUser(user2);

        finish();

    }

}
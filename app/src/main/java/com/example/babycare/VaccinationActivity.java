package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VaccinationActivity extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        button = (Button)findViewById(R.id.btn_firstVaccineDone);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(VaccinationActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
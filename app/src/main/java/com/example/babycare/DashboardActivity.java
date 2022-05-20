package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView card1,card2,card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        card1 = (CardView) findViewById(R.id.card_height);
        card2 = (CardView) findViewById(R.id.card_weight);
        card3 = (CardView) findViewById(R.id.card_vaccine);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.card_height:
                intent = new Intent(DashboardActivity.this,HeightTrackerActivity.class);
                startActivity(intent);
                break;

            case R.id.card_weight:
                intent = new Intent(DashboardActivity.this, Weight_View.class);
                startActivity(intent);
                break;

            case R.id.card_vaccine:
                intent = new Intent(DashboardActivity.this,VaccinationTrackerActivity.class);
                startActivity(intent);
                break;
        }

    }
}
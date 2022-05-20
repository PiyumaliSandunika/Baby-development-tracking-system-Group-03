package com.example.babycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.babycare.db.AppDatabase;
import com.example.babycare.db.Baby;


public class AddBabyActivity extends AppCompatActivity {
    public Button button;
    public String Gen ;

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;


   /* public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radbtn_boy:
                if (checked){
                    Gen = "male";
                    break;
                }
            case R.id.radbtn_girl:
                if (checked){
                    Gen = "female";
                    break;
                }

        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_baby);

        final EditText nameInput =  findViewById(R.id.editTxt_Name);
        final EditText bDayInput =  findViewById(R.id.editTxt_BDate);

        radioGroup = findViewById(R.id.radioGroup);

        button = (Button) findViewById(R.id.btn_addbaby_done);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                saveNewBaby(nameInput.getText().toString(), bDayInput.getText().toString(),radioButton.getText().toString());

                Intent intent = new Intent(AddBabyActivity.this,VaccinationActivity.class);
                startActivity(intent);
            }
        });
    }

        public void saveNewBaby(String babyName, String bDate ,String gender) {
        AppDatabase dbb  = AppDatabase.getDbInstance(this.getApplicationContext());


        Baby baby = new Baby();
        baby.Bname = babyName;
        baby.bday = bDate;
        baby.gender = gender;

        //dbb.babyDao().insertBaby(baby);
        finish();

    }

}
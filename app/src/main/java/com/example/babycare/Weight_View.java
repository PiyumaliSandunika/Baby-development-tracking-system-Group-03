package com.example.babycare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.babycare.db.AppDatabase;
import com.example.babycare.db.User_Weight;

import java.util.List;


public class Weight_View extends AppCompatActivity {

    private UserListAdapter userListAdapter;
    //public Button addrecordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_view);

        Button addrecordBtn = findViewById(R.id.addNewUserButton);
        addrecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent = new Intent(Weight_View.this,WeightTrackerActivity.class);
                startActivity(intent);
            }
        });
        initRecyclerView();

        loadUserList();

    }
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);

    }

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User_Weight> userList =db.userDao().getAllUsers();
        userListAdapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}


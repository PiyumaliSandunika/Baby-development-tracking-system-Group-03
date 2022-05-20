package com.example.babycare.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User_Weight {

    @PrimaryKey
    public int age;

    @ColumnInfo(name = "ageYear")
    public String ageYear;

    @ColumnInfo(name = "ageMonth")
    public String ageMonth;

    @ColumnInfo(name = "weight")
    public String weight;



}
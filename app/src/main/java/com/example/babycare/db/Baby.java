package com.example.babycare.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Baby {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String Bname;

    @ColumnInfo(name = "bday")
    public String bday;

    @ColumnInfo(name = "gender")
    public String gender;


}
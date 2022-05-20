package com.example.babycare.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BabyDao {

    @Query("SELECT * FROM Baby")
    List<Baby> getAllUsers();

    @Insert
    void insertBaby(Baby... babies);

    @Delete
    void delete(Baby baby);
}
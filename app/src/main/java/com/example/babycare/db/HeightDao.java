package com.example.babycare.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HeightDao {
    @Query("SELECT * FROM Baby_Height")
    List<Baby_Height> getAllUsers();

    @Insert
    void insertUser(Baby_Height... users);

    @Delete
    void delete(Baby_Height user);
}

package com.example.babycare.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User_Weight")
    List<User_Weight> getAllUsers();

    @Insert
    void insertUser(User_Weight... users);

    @Delete
    void delete(User_Weight user);
}

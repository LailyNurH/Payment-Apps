package com.laily.responsimp3.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void   insertuser(Users users);

    @Query("SELECT * FROM User WHERE email = (:email) and password = (:password)")
    Users loginInfo(String email, String password);
}

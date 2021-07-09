package com.laily.responsimp3.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Users.class , version =1 )
public abstract class UserDB extends RoomDatabase {

    public  abstract  UserDao userDao();
    public static  UserDB userDB;

    public static UserDB getDatabase(final Context context) {
        if (userDB == null){
            synchronized (UserDB.class){
                if (userDB == null){
                    userDB = Room.databaseBuilder(context.getApplicationContext(),
                            UserDB.class,"userDB").build();
                }
            }
        }
        return  userDB;
    }


}

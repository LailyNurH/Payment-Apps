package com.laily.responsimp3.DB;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Insert;

import org.jetbrains.annotations.NotNull;

public class UserViewModel extends AndroidViewModel {

    private  UserDao userDao;
    private  UserDB userDB;
    public UserViewModel(@NonNull @NotNull Application application) {
        super(application);
        userDB = UserDB.getDatabase(application);
        userDao = userDB.userDao();
    }
    public  void  insertuser(Users users){
        new InsertAsyncTask(userDao).execute(users);
    }

    private class InsertAsyncTask  extends AsyncTask<Users,Void,Void> {
        UserDao userDao;

        public InsertAsyncTask(UserDao mUserDAO) {
            this.userDao = mUserDAO;
        }
        @Override
        protected Void doInBackground(Users... users) {
            userDao.insertuser(users[0]);
            return null;
        }
    }
}

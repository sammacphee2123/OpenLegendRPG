package ca.unb.mobiledev.openlegendrpg.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import ca.unb.mobiledev.openlegendrpg.Items.User;
import ca.unb.mobiledev.openlegendrpg.database.UserRoomDatabase;

public class userRepo {

    private ca.unb.mobiledev.openlegendrpg.dao.userDao userDao;
    private LiveData<List<User>> mUsers;
    public userRepo(Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
    }
    public boolean insertRecord(String name, String password, String email) throws ExecutionException, InterruptedException {
        User newItem = new User(name, password, email);
        boolean inserted = insertRecord(newItem);
        return inserted;
    }
    public boolean insertRecord(final User user) throws ExecutionException, InterruptedException {
        Future<List<User>> future = UserRoomDatabase.databaseWriterExecutor.submit(new Callable<List<User>>(){
            public List<User> call() {
                return userDao.verifyUser(user.getName(), user.getPassword());
            }
        });
        List<User> list = future.get();
        if(list.isEmpty()){
            UserRoomDatabase.databaseWriterExecutor.execute(() -> {
                userDao.insertUser(user);
            });
            return true;
        }
        else{
            return false;
        }
    }
    public List<User> verifiedUser(String name,String password) throws ExecutionException, InterruptedException {
        Future<List<User>> future = UserRoomDatabase.databaseWriterExecutor.submit(new Callable<List<User>>(){
            public List<User> call() {
                return userDao.verifyUser(name, password);
            }
        });
        List<User> list = future.get();
        return list;
    }
}

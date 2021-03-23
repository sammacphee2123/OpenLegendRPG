package ca.unb.mobiledev.openlegendrpg.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
import ca.unb.mobiledev.openlegendrpg.Items.User;

@Dao
public interface userDao {

    @Query("SELECT * from user_table WHERE name = :enteredName AND password = :enteredPassword ")
    public List<User> verifyUser(String enteredName, String enteredPassword);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertUser(User user);
}

package ca.unb.mobiledev.openlegendrpg.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import ca.unb.mobiledev.openlegendrpg.Items.Boon;

import java.util.List;

/**
 * This DAO object validates the SQL at compile-time and associates it with a method
 */
@Dao
public interface boonDao {

    @Query("SELECT * from boon_table")
    LiveData<List<Boon>> getAlphabetizedBoons();

    @Query("DELETE FROM boon_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Boon boon);

}

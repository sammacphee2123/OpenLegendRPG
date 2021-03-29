package ca.unb.mobiledev.openlegendrpg.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import ca.unb.mobiledev.openlegendrpg.Items.Bane;

import java.util.List;

/**
 * This DAO object validates the SQL at compile-time and associates it with a method
 */
@Dao
public interface baneDao {

    @Query("SELECT * from bane_table")
    LiveData<List<Bane>> getAlphabetizedBanes();

    @Query("DELETE FROM bane_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Bane bane);

}

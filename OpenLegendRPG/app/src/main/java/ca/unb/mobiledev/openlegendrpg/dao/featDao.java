package ca.unb.mobiledev.openlegendrpg.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import ca.unb.mobiledev.openlegendrpg.Items.Feat;

import java.util.List;

/**
 * This DAO object validates the SQL at compile-time and associates it with a method
 */
@Dao
public interface featDao {

    @Query("SELECT * from feat_table")
    LiveData<List<Feat>> getAlphabetizedFeats();

    @Query("DELETE FROM feat_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Feat feat);

}

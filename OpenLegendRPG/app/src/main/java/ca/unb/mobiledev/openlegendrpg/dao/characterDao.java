package ca.unb.mobiledev.openlegendrpg.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import ca.unb.mobiledev.openlegendrpg.Items.Character;

import java.util.List;

@Dao
public interface characterDao
{
    @Query("SELECT * from character_table")
    LiveData<List<Character>> getCharacters();

    @Query("DELETE FROM character_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Character character);

    @Query("DELETE FROM character_table WHERE charName = :charName")
    void deleteCharacterByName(String charName);

    //query to drop specific character from table
}

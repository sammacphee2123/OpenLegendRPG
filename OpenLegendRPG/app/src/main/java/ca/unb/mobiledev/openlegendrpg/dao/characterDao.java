package ca.unb.mobiledev.openlegendrpg.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.Items.User;

import java.util.List;

@Dao
public interface characterDao
{
    @Query("SELECT * from character_table WHERE userId = :userId")
    LiveData<List<Character>> getCharacters(String userId);

    @Query("DELETE FROM character_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Character character);

    @Query("DELETE FROM character_table WHERE charName = :charName")
    void deleteCharacterByName(String charName);
    //query to drop specific character from table

    @Query("SELECT * FROM character_table WHERE charName = :charName")
    List<Character> selectCharacterByName(String charName);
    //query to drop specific character from table


    @Query("UPDATE character_table SET playerName = :playerName, description = :desc, equipment = :equipment, additionalNotes = :additional, perk1 = :perk1, perk2= :perk2, flaw1 = :flaw1, flaw2 = :flaw2,level = :level,  experience = :exp, lethalHP = :lethalHP, currentHP = :currentHP, initADV= :initADV, legend = :legend, wealth = :wealth, speed = :speed, guardOther = :guardOther, toughnessOther = :toughnessOther, resolveOther = :resolveOther,armor = :armor, agility = :agility, fortitude = :fortitude, might = :might, deception = :deception, persuasion = :persuasion,presence = :presence,  learning = :learning, logic = :logic, perception = :perception, will = :will, alteration = :alteration ,creation = :creation, energy = :energy, entropy = :entropy, influence =:influence, movement =:movement, prescience = :prescience, protection = :protection WHERE charName = :charName")
    void update(String charName, String playerName,
                int level, int exp, String desc, int lethalHP, int currentHP,
                int initADV, int legend, int wealth, int speed,
                int guardOther, int toughnessOther, int resolveOther, int armor,
                String equipment, String additional, int agility, int fortitude,
                int might, int deception, int persuasion, int presence, int learning,
                int logic, int perception, int will, int alteration, int creation,
                int energy, int entropy, int influence, int movement,
                int prescience, int protection,String perk1,String perk2,String flaw1, String flaw2);
    //query to drop specific character from table
}

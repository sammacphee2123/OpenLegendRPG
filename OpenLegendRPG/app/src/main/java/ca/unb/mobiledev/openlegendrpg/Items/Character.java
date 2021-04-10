package ca.unb.mobiledev.openlegendrpg.Items;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.List;

@Entity(tableName = "character_table")
public class Character {
    //Basic character information
    @PrimaryKey
    @NonNull
    private String charName;
    private String playerName;
    private int level;
    private int experience;
    private String description;
    private int lethalHP;
    private int currentHP;
    private int legend;
    private int wealth;
    private int speed;
    private int guardOther;
    private int toughnessOther;
    private int resolveOther;
    private int armor;
    //private List<attribute> attributes;
    //private List<Feat> feats;
    //private String[] perks;
    //private String[] flaws;
    private String equipment;
    private String additionalNotes;
    private String userId;


    public Character(String charName, String playerName, int level, int experience,
                     String description, int lethalHP, int currentHP, int legend, int wealth,
                     int speed, int guardOther, int toughnessOther, int resolveOther, int armor, String equipment,
                     String additionalNotes, String userId)
    {
        this.charName = charName;
        this.playerName = playerName;
        this.level = level;
        this.experience = experience;
        this.description = description;
        this.lethalHP = lethalHP;
        this.currentHP = currentHP;
        this.legend = legend;
        this.wealth = wealth;
        this.speed = speed;
        this.guardOther = guardOther;
        this.toughnessOther = toughnessOther;
        this.resolveOther = resolveOther;
        this.armor = armor;
        this.equipment = equipment;
        this.additionalNotes = additionalNotes;
        this.userId = userId;
    }

    @NonNull
    public String getCharName() { return charName; }

    public void setCharName(@NonNull String charName) { this.charName = charName; }

    public String getPlayerName() { return playerName; }

    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public int getExperience() { return experience; }

    public void setExperience(int experience) { this.experience = experience; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getLethalHP() { return lethalHP; }

    public void setLethalHP(int lethalHP) { this.lethalHP = lethalHP; }

    public int getCurrentHP() { return currentHP; }

    public void setCurrentHP(int currentHP) { this.currentHP = currentHP; }

    public int getLegend() { return legend; }

    public void setLegend(int legend) { this.legend = legend; }

    public int getWealth() { return wealth; }

    public void setWealth(int wealth) { this.wealth = wealth; }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getGuardOther() { return guardOther; }

    public void setGuardOther(int guardOther) { this.guardOther = guardOther; }

    public int getToughnessOther() { return toughnessOther; }

    public void setToughnessOther(int toughnessOther) { this.toughnessOther = toughnessOther; }

    public int getResolveOther() { return resolveOther; }

    public void setResolveOther(int resolveOther) { this.resolveOther = resolveOther; }

    public int getArmor() { return armor; }

    public void setArmor(int armor) { this.armor = armor; }

    public String getEquipment() { return equipment; }

    public void setEquipment(String equipment) { this.equipment = equipment; }

    public String getAdditionalNotes() { return additionalNotes; }

    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }


    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }
}
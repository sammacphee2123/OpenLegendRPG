package ca.unb.mobiledev.openlegendrpg.Items;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_table")
public class Character {
    //Basic character information
    @PrimaryKey
    @NonNull
    private String charName;
    //@TypeConverters(featsTypeConverter.class)
    //private List<Feat> feats;
    private String playerName, description, equipment, additionalNotes, perk1, perk2, flaw1, flaw2;
    private int level, experience, lethalHP, currentHP, initADV, legend, wealth, speed, guardOther,
            toughnessOther, resolveOther, armor, agility, fortitude, might, deception, persuasion,
            presence, learning, logic, perception, will, alteration, creation, energy, entropy,
            influence,  movement, prescience, protection;
    private String userId;

    public Character(String charName, String playerName, int level, int experience,
                     String description, int lethalHP, int currentHP, int initADV, int legend,
                     int wealth, int speed, int guardOther, int toughnessOther, int resolveOther,
                     int armor, String equipment, String additionalNotes, String userId,
                     int agility, int fortitude, int might, int deception, int persuasion,
                     int presence, int learning, int logic, int perception, int will, int alteration,
                     int creation, int energy, int entropy, int influence, int movement,
                     int prescience, int protection, String perk1, String perk2, String flaw1,
                     String flaw2)
    {
        this.charName = charName;
        this.playerName = playerName;
        this.level = level;
        this.experience = experience;
        this.description = description;
        this.lethalHP = lethalHP;
        this.currentHP = currentHP;
        this.initADV = initADV;
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
        this.agility = agility;
        this.fortitude = fortitude;
        this.might = might;
        this.deception = deception;
        this.persuasion = persuasion;
        this.presence = presence;
        this.learning = learning;
        this.logic = logic;
        this.perception = perception;
        this.will = will;
        this.alteration = alteration;
        this.creation = creation;
        this.energy = energy;
        this.entropy = entropy;
        this.influence = influence;
        this.movement = movement;
        this.prescience = prescience;
        this.protection = protection;

        this.perk1 = perk1;
        this.perk2 = perk2;
        this.flaw1 = flaw1;
        this.flaw2 = flaw2;
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

    public int getInitADV() { return initADV; }

    public void setInitADV(int initADV) { this.initADV = initADV; }

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

    public int getAgility() { return agility; }

    public void setAgility(int agility) { this.agility = agility; }

    public int getFortitude() { return fortitude; }

    public void setFortitude(int fortitude) { this.fortitude = fortitude; }

    public int getMight() { return might; }

    public void setMight(int might) { this.might = might; }

    public int getDeception() { return deception; }

    public void setDeception(int deception) { this.deception = deception; }

    public int getPersuasion() { return persuasion; }

    public void setPersuasion(int persuasion) { this.persuasion = persuasion; }

    public int getPresence() { return presence; }

    public void setPresence(int presence) { this.presence = presence; }

    public int getLearning() { return learning; }

    public void setLearning(int learning) { this.learning = learning; }

    public int getLogic() { return logic; }

    public void setLogic(int logic) { this.logic = logic; }

    public int getPerception() { return perception; }

    public void setPerception(int perception) { this.perception = perception; }

    public int getWill() { return will; }

    public void setWill(int will) { this.will = will; }

    public int getAlteration() { return alteration; }

    public void setAlteration(int alteration) { this.alteration = alteration; }

    public int getCreation() { return creation; }

    public void setCreation(int creation) { this.creation = creation; }

    public int getEnergy() { return energy; }

    public void setEnergy(int energy) { this.energy = energy; }

    public int getEntropy() { return entropy; }

    public void setEntropy(int entropy) { this.entropy = entropy; }

    public int getInfluence() { return influence; }

    public void setInfluence(int influence) { this.influence = influence; }

    public int getMovement() { return movement; }

    public void setMovement(int movement) { this.movement = movement; }

    public int getPrescience() { return prescience; }

    public void setPrescience(int prescience) { this.prescience = prescience; }

    public int getProtection() { return protection; }

    public void setProtection(int protection) { this.protection = protection; }

    public String getPerk2() { return perk2; }

    public void setPerk2(String perk1) { this.perk2 = perk2; }

    public String getPerk1() { return perk1; }

    public void setPerk1(String perk1) { this.perk1 = perk1; }

    public String getFlaw2() { return flaw2; }

    public void setFlaw2(String flaw1) { this.flaw2 = flaw2; }

    public String getFlaw1() { return flaw1; }

    public void setFlaw1(String flaw1) { this.flaw1 = flaw1; }
}
package ca.unb.mobiledev.openlegendrpg.Items;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_table")
public class Character
{
    //Basic character information
    private String playerName;

    @PrimaryKey
    @NonNull
    private String charName;
    private String archetype;
    private String description;
    private int level;
    private int experience;

    //Physical attributes
    private int agility;
    private int fortitude;
    private int might;

    //Mental attributes
    private int learning;
    private int logic;
    private int perception;
    private int will;

    //Social attributes
    private int deception;
    private int persuasion;
    private int presence;

    //Extraordinary attributes
    private int alteration;
    private int creation;
    private int energy;
    private int entropy;
    private int influence;
    private int movement;
    private int prescience;
    private int protection;

    //Feats
    private String featName;
    private int featCost;
    private int featSpent;
    private int featTotal;

    //Weapons & Armor
    private String meleeWeapon;
    private String rangedWeapon;
    private String armorName;
    private String armorType;

    private int guard; //agility + might + armor + Feats + 10
    private int toughness; //fortitude + will + Feats + 10
    private int resolve; //presence + will + Feats + 10
    private int legend; //not sure what type this variable should be
    private int wealth;
    private int speed;

    //Hit points
    private int maxHP;
    private int lethalHP;
    private int currentHP;

    //Initiative
    private int initiative;
    private int advantage;

    //Perks & Flaws
    private String perks;
    private String flaws;

    //Actions
    private String actionName;
    private String actionAttribute;
    private String actionTarget;
    private String actionSpecial;

    //Preferred Boons -- listed like this because database was having trouble storing arrays
    private String boon1;
    private String boon2;
    private String boon3;
    private String boon4;

    //Equipment
    private String equipment;

    private String additionalNotes;

    private boolean expanded;

    public Character(String playerName, String charName, String archetype, String description, int level,
                     int experience, int agility, int fortitude, int might, int learning, int logic,
                     int perception, int will, int deception, int persuasion, int presence, int alteration,
                     int creation, int energy, int entropy, int influence, int movement, int prescience,
                     int protection, String featName, int featCost, int featSpent, int featTotal, String meleeWeapon,
                     String rangedWeapon, String armorName, String armorType, int guard,
                     int toughness, int resolve, int legend, int wealth, int speed, int maxHP,
                     int lethalHP, int currentHP, int initiative, int advantage, String perks, String flaws,
                     String actionName, String actionAttribute, String actionTarget, String actionSpecial,
                     String boon1, String boon2, String boon3, String boon4, String equipment, String additionalNotes)
    {
        this.playerName = playerName;
        this.charName = charName;
        this.archetype = archetype;
        this.description = description;
        this.level = level;
        this.experience = experience;
        this.agility = agility;
        this.fortitude = fortitude;
        this.might = might;
        this.learning = learning;
        this.logic = logic;
        this.perception = perception;
        this.will = will;
        this.deception = deception;
        this.persuasion = persuasion;
        this.presence = presence;
        this.alteration = alteration;
        this.creation = creation;
        this.energy = energy;
        this.entropy = entropy;
        this.influence = influence;
        this.movement = movement;
        this.prescience = prescience;
        this.protection = protection;
        this.featName = featName;
        this.featCost = featCost;
        this.featSpent = featSpent;
        this.featTotal = featTotal;
        this.meleeWeapon = meleeWeapon;
        this.rangedWeapon = rangedWeapon;
        this.armorName = armorName;
        this.armorType = armorType;
        this.guard = guard;
        this.toughness = toughness;
        this.resolve = resolve;
        this.legend = legend;
        this.wealth = wealth;
        this.speed = speed;
        this.maxHP = maxHP;
        this.lethalHP = lethalHP;
        this.currentHP = currentHP;
        this.initiative = initiative;
        this.advantage = advantage;
        this.perks = perks;
        this.flaws = flaws;
        this.actionName = actionName;
        this.actionAttribute = actionAttribute;
        this.actionTarget = actionTarget;
        this.actionSpecial = actionSpecial;
        this.boon1 = boon1;
        this.boon2 = boon2;
        this.boon3 = boon3;
        this.boon4 = boon4;
        this.equipment = equipment;
        this.additionalNotes = additionalNotes;
        this.expanded = false;
    }


    //From here on out there are only getters and setters for each variable


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @NonNull
    public String getCharName() {
        return charName;
    }

    public void setCharName(@NonNull String charName) {
        this.charName = charName;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getFortitude() {
        return fortitude;
    }

    public void setFortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    public int getMight() {
        return might;
    }

    public void setMight(int might) {
        this.might = might;
    }

    public int getLearning() {
        return learning;
    }

    public void setLearning(int learning) {
        this.learning = learning;
    }

    public int getLogic() {
        return logic;
    }

    public void setLogic(int logic) {
        this.logic = logic;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getAlteration() {
        return alteration;
    }

    public void setAlteration(int alteration) {
        this.alteration = alteration;
    }

    public int getCreation() {
        return creation;
    }

    public void setCreation(int creation) {
        this.creation = creation;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEntropy() {
        return entropy;
    }

    public void setEntropy(int entropy) {
        this.entropy = entropy;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getPrescience() {
        return prescience;
    }

    public void setPrescience(int prescience) {
        this.prescience = prescience;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public String getFeatName() {
        return featName;
    }

    public void setFeatName(String featName) {
        this.featName = featName;
    }

    public int getFeatCost() {
        return featCost;
    }

    public void setFeatCost(int featCost) {
        this.featCost = featCost;
    }

    public int getFeatSpent() {
        return featSpent;
    }

    public void setFeat(int featSpent) {
        this.featSpent = featSpent;
    }

    public int getFeatTotal() {
        return featTotal;
    }

    public void setFeatTotal(int featTotal) {
        this.featTotal = featTotal;
    }

    public String getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(String meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public String getRangedWeapon() {
        return rangedWeapon;
    }

    public void setRangedWeapon(String rangedWeapon) {
        this.rangedWeapon = rangedWeapon;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public int getGuard() {
        return guard;
    }

    public void setGuard(int guard) {
        this.guard = guard;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public int getResolve() {
        return resolve;
    }

    public void setResolve(int resolve) {
        this.resolve = resolve;
    }

    public int getLegend() {
        return legend;
    }

    public void setLegend(int legend) {
        this.legend = legend;
    }

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getLethalHP() {
        return lethalHP;
    }

    public void setLethalHP(int lethalHP) {
        this.lethalHP = lethalHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAdvantage() {
        return advantage;
    }

    public void setAdvantage(int advantage) {
        this.advantage = advantage;
    }

    public String getPerks() {
        return perks;
    }

    public void setPerks(String perks) {
        this.perks = perks;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionAttribute() {
        return actionAttribute;
    }

    public void setActionAttribute(String actionAttribute) {
        this.actionAttribute = actionAttribute;
    }

    public String getActionTarget() {
        return actionTarget;
    }

    public void setActionTarget(String actionTarget) {
        this.actionTarget = actionTarget;
    }

    public String getActionSpecial() {
        return actionSpecial;
    }

    public void setActionSpecial(String actionSpecial) {
        this.actionSpecial = actionSpecial;
    }

    public String getBoon1() {
        return boon1;
    }

    public void setBoon1(String boon1) {
        this.boon1 = boon1;
    }

    public String getBoon2() {
        return boon2;
    }

    public void setBoon2(String boon2) {
        this.boon2 = boon2;
    }

    public String getBoon3() {
        return boon3;
    }

    public void setBoon3(String boon3) {
        this.boon3 = boon3;
    }

    public String getBoon4() {
        return boon4;
    }

    public void setBoon4(String boon4) {
        this.boon4 = boon4;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}

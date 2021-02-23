package com.journaldev.navigationdrawer.banes;

public class Bane
{
    private String name;
    private String powerLevel;
    private String description;
    private String duration;
    private String atkAttributes;
    private String attack;
    private String effect;
    private String special;
    private boolean expanded;

    public Bane(String name, String powerLevel, String description, String duration, String atkAttributes, String attack, String effect, String special)
    {
        this.name = name;
        this.powerLevel = powerLevel;
        this.description = description;
        this.duration = duration;
        this.atkAttributes = atkAttributes;
        this.attack = attack;
        this.effect = effect;
        this.special = special;

        expanded = false;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getPowerLevel()
    {
        return powerLevel;
    }
    public void setPowerLevel(String powerLevel)
    {
        this.powerLevel = powerLevel;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDuration()
    {
        return duration;
    }
    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getAtkAttributes()
    {
        return atkAttributes;
    }
    public void setAtkAttributes(String atkAttributes)
    {
        this.atkAttributes = atkAttributes;
    }

    public String getAttack()
    {
        return attack;
    }
    public void setAttack(String attack)
    {
        this.attack = attack;
    }

    public String getEffect()
    {
        return effect;
    }
    public void setEffect(String effect)
    {
        this.effect = effect;
    }

    public String getSpecial()
    {
        return special;
    }
    public void setSpecial(String special)
    {
        this.special = special;
    }

    public boolean isExpanded()
    {
        return expanded;
    }
    public void setExpanded(boolean expanded)
    {
        this.expanded = expanded;
    }
}

package ca.unb.mobiledev.openlegendrpg.Items;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "boon_table")
public class Boon
{
    @PrimaryKey
    @NonNull
    private String name;
    private String powerLevel;
    private String description;
    private String invocationTime;
    private String duration;
    private String attributes;
    private String effect;
    private boolean expanded;

    public Boon(String name, String powerLevel, String description, String invocationTime, String duration, String attributes, String effect)
    {
        this.name = name;
        this.powerLevel = powerLevel;
        this.description = description;
        this.invocationTime = invocationTime;
        this.duration = duration;
        this.attributes = attributes;
        this.effect = effect;

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

    public String getInvocationTime()
    {
        return invocationTime;
    }
    public void setInvocationTime(String invocationTime)
    {
        this.invocationTime = invocationTime;
    }

    public String getDuration()
    {
        return duration;
    }
    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getAttributes()
    {
        return attributes;
    }
    public void setAttributes(String attributes)
    {
        this.attributes = attributes;
    }

    public String getEffect()
    {
        return effect;
    }
    public void setEffect(String effect)
    {
        this.effect = effect;
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

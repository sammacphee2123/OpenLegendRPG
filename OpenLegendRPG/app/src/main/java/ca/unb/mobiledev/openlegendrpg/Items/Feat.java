package ca.unb.mobiledev.openlegendrpg.Items;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "feat_table")
public class Feat {

    @PrimaryKey
    @NonNull
    private String name;
    private String cost;
    private String preReq;
    private String desc;
    private String effect;
    private boolean expanded;

    public Feat(String name, String cost, String preReq, String desc, String effect){
        this.name = name;
        this.cost = cost;
        this.preReq = preReq;
        this.desc = desc;
        this.effect = effect;
        this.expanded = false;
    }

    public String getCost(){
        return cost;
    }
    public void setCost(String cost){
        this.cost = cost;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPreReq(){
        return preReq;
    }
    public void setPreReq(String preReq){
        this.preReq = preReq;
    }

    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getEffect(){
        return effect;
    }
    public void setEffect(){
        this.effect = effect;
    }

    public boolean isExpanded() {
        return expanded;
    }
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}

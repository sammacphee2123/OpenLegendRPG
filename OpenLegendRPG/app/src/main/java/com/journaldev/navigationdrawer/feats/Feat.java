package com.journaldev.navigationdrawer.feats;

public class Feat {
    private String cost;
    private String name;
    private String preReq;
    private String desc;
    private String effect;
    private String special;
    private boolean expanded;

    public Feat(String cost, String name, String preReq, String desc, String effect, String special){
        this.cost = cost;
        this.name = name;
        this.preReq = preReq;
        this.desc = desc;
        this.effect = effect;
        this.special = special;
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

    public String getSpecial(){
        return special;
    }
    public void setSpecial(String special){
        this.special = special;
    }

    public boolean isExpanded() {
        return expanded;
    }
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}

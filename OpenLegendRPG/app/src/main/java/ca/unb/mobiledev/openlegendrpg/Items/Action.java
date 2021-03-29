package ca.unb.mobiledev.openlegendrpg.Items;

public class Action
{
    private String name;
    private String attribute;
    private String target;
    private String special;

    public Action(String name, String attribute, String target, String special)
    {
        this.name = name;
        this.attribute = attribute;
        this.target = target;
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}

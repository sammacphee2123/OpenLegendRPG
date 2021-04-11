package ca.unb.mobiledev.openlegendrpg.Items;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attribute_table")
public class attribute {
    @PrimaryKey
    @NonNull
    private String name;
    private int score;
    private int cost;
    private String dice;

    public attribute(String name, int score){
        this.name = name;
        this.score = score;
        switch(score){
            case 1:
                this.cost = 1;
                this.dice = "d4";
                break;
            case 2:
                this.cost = 3;
                this.dice = "d6";
                break;
            case 3:
                this.cost = 6;
                this.dice = "d8";
                break;
            case 4:
                this.cost = 10;
                this.dice = "d10";
                break;
            case 5:
                this.cost = 15;
                this.dice = "2d6";
                break;
            case 6:
                this.cost = 21;
                this.dice = "2d8";
                break;
            case 7:
                this.cost = 28;
                this.dice = "2d10";
                break;
            case 8:
                this.cost = 36;
                this.dice = "3d8";
                break;
            case 9:
                this.cost = 45;
                this.dice = "3d10";
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDice() {
        return dice;
    }

    public void setDice(String dice) {
        this.dice = dice;
    }
}

package ca.unb.mobiledev.openlegendrpg.Items;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "email")
    private String email;

    public User(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public String getName(){
            return name;
        }
    public void setName(String name){
            this.name = name;
        }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
            return password;
        }
    public void setPassword(String password){
            this.password = password;
        }

}

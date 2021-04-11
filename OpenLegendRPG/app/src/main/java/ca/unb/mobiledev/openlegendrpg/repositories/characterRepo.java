package ca.unb.mobiledev.openlegendrpg.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.Items.User;
import ca.unb.mobiledev.openlegendrpg.MainActivity;
import ca.unb.mobiledev.openlegendrpg.dao.characterDao;
import ca.unb.mobiledev.openlegendrpg.database.CharacterRoomDatabase;
import ca.unb.mobiledev.openlegendrpg.database.UserRoomDatabase;

public class characterRepo
{
    private characterDao mCharacterDao;
    private LiveData<List<Character>> mCharacters;

    public characterRepo(Application application)
    {
        CharacterRoomDatabase db = CharacterRoomDatabase.getDatabase(application);
        mCharacterDao = db.characterDao();
        User user = MainActivity.getUser();
        if(user != null) {
            String userId = user.getName();
            mCharacters = mCharacterDao.getCharacters(userId);
        }
        else{
            mCharacters = null;
        }
    }

    public LiveData<List<Character>> listAllRecords()
    {
        return mCharacters;
    }

    public boolean insertRecord(final Character character) throws ExecutionException, InterruptedException {
        Future<List<Character>> future = UserRoomDatabase.databaseWriterExecutor.submit(new Callable<List<Character>>(){
            public List<Character> call() {
                return mCharacterDao.selectCharacterByName(character.getCharName());
            }
        });
        List<Character> list = future.get();
        if(list.isEmpty()){
            UserRoomDatabase.databaseWriterExecutor.execute(() -> {
                mCharacterDao.insert(character);
            });
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateRecord(final Character character) throws ExecutionException, InterruptedException {
        String charName = character.getCharName();
        String playerName = character.getPlayerName();
        int level = character.getLevel();
        int exp = character.getExperience();
        String desc = character.getDescription();
        int lethalHP = character.getLethalHP();
        int currentHP = character.getCurrentHP();
        int initADV = character.getInitADV();
        int legend = character.getLegend();
        int wealth = character.getWealth();
        int speed = character.getSpeed();
        int guardOther = character.getGuardOther();
        int toughnessOther = character.getToughnessOther();
        int resolveOther = character.getResolveOther();
        int armor = character.getArmor();
        String equipment = character.getEquipment();
        String additional = character.getAdditionalNotes();
        int agility = character.getAgility();
        int fortitude = character.getFortitude();
        int might = character.getMight();
        int deception = character.getDeception();
        int persuasion = character.getPersuasion();
        int presence = character.getPresence();
        int learning = character.getLearning();
        int logic = character.getLogic();
        int perception = character.getPerception();
        int will = character.getWill();
        int alteration = character.getAlteration();
        int creation = character.getCreation();
        int energy = character.getEnergy();
        int entropy = character.getEntropy();
        int influence = character.getInfluence();
        int movement = character.getMovement();
        int prescience = character.getPrescience();
        int protection = character.getProtection();
        String perk1 = character.getPerk1();
        String perk2 = character.getPerk2();
        String flaw1 = character.getFlaw1();
        String flaw2 = character.getFlaw2();
            UserRoomDatabase.databaseWriterExecutor.execute(() -> {
                mCharacterDao.update(charName, playerName, level, exp, desc,  lethalHP, currentHP, initADV, legend, wealth, speed,
                guardOther, toughnessOther, resolveOther, armor,
                equipment, additional, agility, fortitude,
                might, deception, persuasion, presence, learning,
                 logic, perception,  will,  alteration,  creation,
                 energy,  entropy, influence, movement,
                prescience,  protection, perk1, perk2, flaw1,  flaw2);
            });
            return true;

    }

    public void deleteRecord(final String charName)
    {
        CharacterRoomDatabase.databaseWriterExecutor.execute(() -> {
            mCharacterDao.deleteCharacterByName(charName);
        });
    }
}

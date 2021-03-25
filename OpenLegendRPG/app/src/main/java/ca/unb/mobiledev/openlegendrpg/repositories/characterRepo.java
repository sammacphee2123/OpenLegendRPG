package ca.unb.mobiledev.openlegendrpg.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.dao.characterDao;
import ca.unb.mobiledev.openlegendrpg.database.CharacterRoomDatabase;

public class characterRepo
{
    private characterDao mCharacterDao;
    private LiveData<List<Character>> mCharacters;

    public characterRepo(Application application)
    {
        CharacterRoomDatabase db = CharacterRoomDatabase.getDatabase(application);
        mCharacterDao = db.characterDao();
        mCharacters = mCharacterDao.getCharacters();
    }

    public LiveData<List<Character>> listAllRecords()
    {
        return mCharacters;
    }

    public void insertRecord(final Character character)
    {
        CharacterRoomDatabase.databaseWriterExecutor.execute(() -> {
            mCharacterDao.insert(character);
        });
    }

    public void deleteRecord(final String charName)
    {
        CharacterRoomDatabase.databaseWriterExecutor.execute(() -> {
            mCharacterDao.deleteCharacterByName(charName);
        });
    }
}

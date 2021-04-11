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
            return false;
        }
        else{
            return true;
        }
    }

    public void deleteRecord(final String charName)
    {
        CharacterRoomDatabase.databaseWriterExecutor.execute(() -> {
            mCharacterDao.deleteCharacterByName(charName);
        });
    }
}

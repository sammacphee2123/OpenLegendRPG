package ca.unb.mobiledev.openlegendrpg.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.repositories.characterRepo;
import java.util.List;

public class characterViewModel extends AndroidViewModel
{
    private final characterRepo characterRepository;
    private final LiveData<List<Character>> characters;

    public characterViewModel(@NonNull Application application)
    {
        super(application);
        characterRepository = new characterRepo(application);
        characters = characterRepository.listAllRecords();
    }

    public LiveData<List<Character>> listAllRecords()
    {
        return characters;
    }

    public void insert(Character character)
    {
        characterRepository.insertRecord(character);
    }

    public void deleteCharacter(String charName)
    {
        characterRepository.deleteRecord(charName);
    }
}

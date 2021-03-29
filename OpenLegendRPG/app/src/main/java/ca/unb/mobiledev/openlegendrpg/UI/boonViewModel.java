package ca.unb.mobiledev.openlegendrpg.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import ca.unb.mobiledev.openlegendrpg.Items.Boon;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.repositories.boonRepo;

public class boonViewModel extends AndroidViewModel {
    private final boonRepo boonRepository;
    private final LiveData<List<Boon>> boons;

    public boonViewModel(@NonNull Application application) {
        super(application);
        boonRepository = new boonRepo(application);
        boons = boonRepository.listAllRecords();
    }

    public LiveData<List<Boon>> listAllRecords() {
        return boons;
    }
}
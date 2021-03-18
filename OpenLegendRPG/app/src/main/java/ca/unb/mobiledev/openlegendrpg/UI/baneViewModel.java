package ca.unb.mobiledev.openlegendrpg.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import ca.unb.mobiledev.openlegendrpg.Items.Bane;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.repositories.baneRepo;

public class baneViewModel extends AndroidViewModel {
    private final baneRepo baneRepository;
    private final LiveData<List<Bane>> banes;

    public baneViewModel(@NonNull Application application) {
        super(application);
        baneRepository = new baneRepo(application);
        banes = baneRepository.listAllRecords();
    }

    public LiveData<List<Bane>> listAllRecords() {
        return banes;
    }
}

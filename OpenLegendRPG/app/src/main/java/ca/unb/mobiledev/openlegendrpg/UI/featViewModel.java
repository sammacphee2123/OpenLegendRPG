package ca.unb.mobiledev.openlegendrpg.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import ca.unb.mobiledev.openlegendrpg.Items.Feat;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.repositories.featRepo;

public class featViewModel extends AndroidViewModel {
    private final featRepo featRepository;
    private final LiveData<List<Feat>> feats;

    public featViewModel(@NonNull Application application) {
        super(application);
        featRepository = new featRepo(application);
        feats = featRepository.listAllRecords();
    }

    public LiveData<List<Feat>> listAllRecords() {
        return feats;
    }
}

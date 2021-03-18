package ca.unb.mobiledev.openlegendrpg.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;

import ca.unb.mobiledev.openlegendrpg.Items.Feat;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.dao.featDao;
import ca.unb.mobiledev.openlegendrpg.database.FeatRoomDatabase;


public class featRepo {
    private featDao mFeatDao;
    private LiveData<List<Feat>> mFeats;

    public featRepo(Application application) {
        FeatRoomDatabase db = FeatRoomDatabase.getDatabase(application);
        mFeatDao = db.featDao();
        mFeats = mFeatDao.getAlphabetizedFeats();
    }

    public LiveData<List<Feat>> listAllRecords(){
        return mFeats;
    }

    public void insertRecord(final Feat feat) {
        FeatRoomDatabase.databaseWriterExecutor.execute(() -> {
            mFeatDao.insert(feat);
        });
    }

}

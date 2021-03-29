package ca.unb.mobiledev.openlegendrpg.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;

import ca.unb.mobiledev.openlegendrpg.Items.Boon;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.dao.boonDao;
import ca.unb.mobiledev.openlegendrpg.database.BoonRoomDatabase;


public class boonRepo {
    private boonDao mboonDao;
    private LiveData<List<Boon>> mBoons;

    public boonRepo(Application application) {
        BoonRoomDatabase db = BoonRoomDatabase.getDatabase(application);
        mboonDao = db.boonDao();
        mBoons = mboonDao.getAlphabetizedBoons();
    }

    public LiveData<List<Boon>> listAllRecords(){
        return mBoons;
    }

    public void insertRecord(final Boon boon) {
        BoonRoomDatabase.databaseWriterExecutor.execute(() -> {
            mboonDao.insert(boon);
        });
    }

}

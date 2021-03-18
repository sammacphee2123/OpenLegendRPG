package ca.unb.mobiledev.openlegendrpg.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;

import ca.unb.mobiledev.openlegendrpg.Items.Bane;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.dao.baneDao;
import ca.unb.mobiledev.openlegendrpg.database.BaneRoomDatabase;
import ca.unb.mobiledev.openlegendrpg.database.BoonRoomDatabase;


public class baneRepo {
    private baneDao mBaneDao;
    private LiveData<List<Bane>> mBanes;

    public baneRepo(Application application) {
        BaneRoomDatabase db = BaneRoomDatabase.getDatabase(application);
        mBaneDao = db.baneDao();
        mBanes = mBaneDao.getAlphabetizedBanes();
    }

    public LiveData<List<Bane>> listAllRecords(){
        return mBanes;
    }

    public void insertRecord(final Bane bane) {
        BoonRoomDatabase.databaseWriterExecutor.execute(() -> {
            mBaneDao.insert(bane);
        });
    }

}

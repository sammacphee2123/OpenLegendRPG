package ca.unb.mobiledev.openlegendrpg.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ca.unb.mobiledev.openlegendrpg.Items.Feat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ca.unb.mobiledev.openlegendrpg.Items.User;
import ca.unb.mobiledev.openlegendrpg.dao.featDao;
import ca.unb.mobiledev.openlegendrpg.dao.userDao;


/**
 * Database layer in top of the SQLite database
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract userDao userDao();
    private static volatile UserRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 15;
    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static UserRoomDatabase getDatabase(final Context context) {
        if (null == INSTANCE) {
            synchronized (UserRoomDatabase.class) {
                if (null == INSTANCE) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
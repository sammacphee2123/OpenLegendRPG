package ca.unb.mobiledev.openlegendrpg.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.dao.characterDao;

@Database(entities = {Character.class}, version = 1, exportSchema = false)
public abstract class CharacterRoomDatabase extends RoomDatabase
{
    public abstract characterDao characterDao();
    private static volatile CharacterRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 15;
    public static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static CharacterRoomDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null)
        {
            synchronized (CharacterRoomDatabase.class)
            {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CharacterRoomDatabase.class, "character_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db)
        {
            super.onCreate(db);

            databaseWriterExecutor.execute(() -> {
                characterDao dao = INSTANCE.characterDao();
                dao.deleteAll();
            });
        }
    };
}

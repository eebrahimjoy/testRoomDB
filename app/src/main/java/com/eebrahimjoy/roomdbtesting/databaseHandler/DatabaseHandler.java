package com.eebrahimjoy.roomdbtesting.databaseHandler;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.eebrahimjoy.roomdbtesting.dao.StateInfoDao;
import com.eebrahimjoy.roomdbtesting.model.PrimeMinister;
import com.eebrahimjoy.roomdbtesting.model.State;

@Database(entities = {State.class, PrimeMinister.class},
        version = 1, exportSchema = true)

public abstract class DatabaseHandler extends RoomDatabase {

    private static final String DATABASE_NAME = "state";

    private static final Object LOCK = new Object();
    private static volatile DatabaseHandler sInstance;

    public static DatabaseHandler getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseHandler.class, DatabaseHandler.DATABASE_NAME)
                            .build();
                }
            }
        }

        return sInstance;
    }

    public abstract StateInfoDao stateInfoDao();
}



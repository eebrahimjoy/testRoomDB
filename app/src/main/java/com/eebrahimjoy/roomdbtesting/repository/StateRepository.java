package com.eebrahimjoy.roomdbtesting.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eebrahimjoy.roomdbtesting.background.AppExecutors;
import com.eebrahimjoy.roomdbtesting.dao.StateInfoDao;
import com.eebrahimjoy.roomdbtesting.databaseHandler.DatabaseHandler;
import com.eebrahimjoy.roomdbtesting.model.State;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StateRepository {
    private DatabaseHandler db;
    private AppExecutors mAppExecutor;
    private StateInfoDao stateInfoDao;
    private static StateRepository sInstance;
    private List<State> stateList;

    private static final Object LOCK = new Object();

    private StateRepository(DatabaseHandler db, StateInfoDao stateInfoDao,
                            AppExecutors appExecutor) {
        this.db = db;
        this.stateInfoDao = stateInfoDao;
        mAppExecutor = appExecutor;
    }

    public static StateRepository getInstance(DatabaseHandler db, StateInfoDao stateInfoDao,
                                              AppExecutors appExecutor) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new StateRepository(db, stateInfoDao, appExecutor);
            }
        }

        return sInstance;
    }

    public List<State> getStateList(final String name) {
        mAppExecutor.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                stateList = stateInfoDao.getStateList(name);
            }
        });

        return stateList;


    }
}

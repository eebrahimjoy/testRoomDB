package com.eebrahimjoy.roomdbtesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.eebrahimjoy.roomdbtesting.background.AppExecutors;
import com.eebrahimjoy.roomdbtesting.dao.StateInfoDao;
import com.eebrahimjoy.roomdbtesting.databaseHandler.DatabaseHandler;
import com.eebrahimjoy.roomdbtesting.model.PrimeMinister;
import com.eebrahimjoy.roomdbtesting.model.State;
import com.eebrahimjoy.roomdbtesting.viewmodel.StateViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private StateInfoDao stateInfoDao;

    private List<State> stateList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler database = DatabaseHandler.getInstance(getApplicationContext().getApplicationContext());

        final State state = new State(1, 101, "Bangladesh", 500, "good", "bengali"
                , "islam", 147570, "asia", 16000000, 64
                , new PrimeMinister(101, "Ebrahim Joy", 25, "male", "islam",
                true, "mirpur, dhaka"));
        final State state2 = new State(102, "India", 500, "good", "bengali"
                , "islam", 147570, "asia", 16000000, 64
                , new PrimeMinister(102, "Joy", 25, "male", "islam",
                true, "mirpur, dhaka"));
        final State state3 = new State(103, "Japoan", 500, "good", "bengali"
                , "islam", 147570, "asia", 16000000, 64
                , new PrimeMinister(103, "Niton", 25, "male", "islam",
                true, "mirpur, dhaka"));
        final State state4 = new State(104, "Bangladesh", 500, "good", "bengali"
                , "islam", 147570, "asia", 16000000, 64
                , new PrimeMinister(104, "Ebrahim Joy", 25, "male", "islam",
                true, "mirpur, dhaka"));

        stateList.add(state);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);

        stateInfoDao = database.stateInfoDao();


        {
            new AppExecutors().diskIO().execute(new Runnable() {
                @Override
                public void run() {

                    stateInfoDao.bulkInsertOutbox(stateList);

                    List<State> states = stateInfoDao.getStateList("Bangladesh");
                    Log.d("states", "onCreate: "+states);

                }
            });
        }





    }

}

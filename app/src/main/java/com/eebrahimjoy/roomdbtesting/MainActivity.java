package com.eebrahimjoy.roomdbtesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.eebrahimjoy.roomdbtesting.background.AppExecutors;
import com.eebrahimjoy.roomdbtesting.dao.DivisionDao;
import com.eebrahimjoy.roomdbtesting.dao.StateInfoDao;
import com.eebrahimjoy.roomdbtesting.databaseHandler.DatabaseHandler;
import com.eebrahimjoy.roomdbtesting.model.Division;
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
    private DivisionDao divisionDao;

    private List<State> stateList = new ArrayList<>();
    private List<Division> divisionList = new ArrayList<>();

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
        final State state4 = new State(104, "India", 500, "good", "bengali"
                , "islam", 147570, "asia", 16000000, 64
                , new PrimeMinister(104, "Ebrahim Joy", 25, "male", "islam",
                true, "mirpur, dhaka"));

        stateList.add(state);
        stateList.add(state2);
        stateList.add(state3);
        stateList.add(state4);

        stateInfoDao = database.stateInfoDao();


        final Division division = new Division("Dhaka", 500, 101);
        final Division division2 = new Division("Khulna", 501, 101);
        final Division division3 = new Division("Mymensingh", 502, 101);
        final Division division4 = new Division("Chittagong", 503, 101);
        final Division division5 = new Division("Polland", 504, 102);
        final Division division6 = new Division("Uganda", 505, 102);

        divisionList.add(division);
        divisionList.add(division2);
        divisionList.add(division3);
        divisionList.add(division4);
        divisionList.add(division5);
        divisionList.add(division6);

        divisionDao = database.divisionInfoDao();


        {
            new AppExecutors().diskIO().execute(new Runnable() {
                @Override
                public void run() {

                    stateInfoDao.bulkInsertOutbox(stateList);
                    divisionDao.bulkInsertOutbox(divisionList);

                    List<State> states = stateInfoDao.getStateList("Bangladesh");
                    Log.d("states", "onCreate: " + states);


                    List<Division> divisions = divisionDao.getStateWithDivision("Bangladesh");
                    Log.d("states", "onCreate: " + divisions);

                }
            });
        }


    }

}

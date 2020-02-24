package com.eebrahimjoy.roomdbtesting.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.eebrahimjoy.roomdbtesting.model.State;

import java.util.List;

@Dao
public interface StateInfoDao {

    //Single_Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOutbox(State state);

    //List_Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsertOutbox(List<State> states);

    //Get_State_List
    @Query("SELECT * FROM state_table WHERE state_name = :name")
    List<State> getStateList(String name);

}

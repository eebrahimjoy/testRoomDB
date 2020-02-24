package com.eebrahimjoy.roomdbtesting.viewmodel;

import androidx.lifecycle.ViewModel;

import com.eebrahimjoy.roomdbtesting.model.State;
import com.eebrahimjoy.roomdbtesting.repository.StateRepository;

import java.util.List;

public class StateViewModel extends ViewModel {

    private StateRepository stateRepository;
    private List<State> stateList;

    public StateViewModel(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> getStateList(String name) {
        return stateRepository.getStateList(name);
    }
}

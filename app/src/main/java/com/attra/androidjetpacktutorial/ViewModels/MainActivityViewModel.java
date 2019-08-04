package com.attra.androidjetpacktutorial.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int count=0;
    private MutableLiveData<Integer> countLiveData=new MutableLiveData<>();


    public MutableLiveData<Integer> getIntialValue(){

        countLiveData.setValue(count);
        return countLiveData;

    }

    public void getIncrementCounter() {

        count=count +1;
        countLiveData.setValue(count);
    }
}

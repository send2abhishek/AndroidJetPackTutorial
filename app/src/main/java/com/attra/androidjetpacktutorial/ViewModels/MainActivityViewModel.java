package com.attra.androidjetpacktutorial.ViewModels;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int count=0;


    public int getIntialValue(){

        return count;
    }

    public int getIncrementCounter() {

        count=count +1;
        return count;
    }
}

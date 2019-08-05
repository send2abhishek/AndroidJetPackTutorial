package com.attra.androidjetpacktutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.attra.androidjetpacktutorial.Models.DataModels;
import com.attra.androidjetpacktutorial.databinding.ActivityDataBinding;

public class DataActivity extends AppCompatActivity {

    private ActivityDataBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_data);
        dataBinding.setDataModel(new MyData("Abhishek Aryan","Abhishek@gmail.com"));
    }
}

package com.attra.androidjetpacktutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.attra.androidjetpacktutorial.ViewModels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView counter;
    private Button increment;
    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        counter=findViewById(R.id.activity_main_counter_text);

        MutableLiveData<Integer> counterLiveData=viewModel.getIntialValue();
        counterLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                counter.setText(String.valueOf(integer));
            }
        });
        //counter.setText(String.valueOf(viewModel.getIntialValue()));
        increment=findViewById(R.id.activity_main_btn_inc);
        increment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        viewModel.getIncrementCounter();
    }


}

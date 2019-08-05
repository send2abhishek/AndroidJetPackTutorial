package com.attra.androidjetpacktutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.attra.androidjetpacktutorial.ViewModels.MainActivityViewModel;
import com.attra.androidjetpacktutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView counter;
    private Button increment;
    private MainActivityViewModel viewModel;
    private HandleClicks clicks;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        clicks=new HandleClicks(this);
        binding.setClickhandlers(clicks);


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


    public void startDataBindingActivity(View view) {

        Intent intent=new Intent(this, DataActivity.class);
        startActivity(intent);
    }

    public class HandleClicks{

        private Context context;

        public HandleClicks(Context context) {
            this.context = context;
        }

        public void getClickBtn(View view){

            Toast.makeText(context,"click buttons",Toast.LENGTH_SHORT).show();
        }
    }
}

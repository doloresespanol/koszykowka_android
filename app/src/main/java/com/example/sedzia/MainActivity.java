package com.example.sedzia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.sedzia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int punkty = 0;
    PunktyViewModel punktyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        punktyViewModel=new ViewModelProvider(this).get(PunktyViewModel.class);
        getSupportActionBar().setTitle("Aplikacja sędziowska");
        punktyViewModel.getPunkty().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                    binding.textView1.setText(String.valueOf(integer));
                    }
                });

        //dzieki bindowaniu widokow nie musimy robic findviewbyid
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //punkty++;
                punktyViewModel.dodajPunkty(1);
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //punkty++;
                punktyViewModel.dodajPunkty(2);
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //punkty++;
                punktyViewModel.dodajPunkty(3);
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //punkty++;
                punktyViewModel.setPunkty(0);
            }
        });
    }
}
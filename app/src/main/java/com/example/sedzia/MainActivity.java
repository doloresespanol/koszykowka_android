package com.example.sedzia;

import androidx.appcompat.app.AppCompatActivity;
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
        binding.textView1.setText(String.valueOf(punktyViewModel.getPunkty()));
        //dzieki bindowaniu widokow nie musimy robic findviewbyid
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //punkty++;
                punktyViewModel.dodajPunkty(1);
                binding.textView1.setText(String.valueOf(punktyViewModel.getPunkty()));
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //punkty++;
                punktyViewModel.dodajPunkty(2);
                binding.textView1.setText(String.valueOf(punktyViewModel.getPunkty()));
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //punkty++;
                punktyViewModel.dodajPunkty(3);
                binding.textView1.setText(String.valueOf(punktyViewModel.getPunkty()));
            }
        });
    }
}
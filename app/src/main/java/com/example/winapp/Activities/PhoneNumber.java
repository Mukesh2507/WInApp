package com.example.winapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.winapp.databinding.ActivityPhoneNumberBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneNumber extends AppCompatActivity {

    //first step for backend is binding
    ActivityPhoneNumberBinding binding;
    //working so we dont need to verify agai and again 1
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());//this will get layout
        setContentView(binding.getRoot());
        //code for stop verify again and again step 2
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(PhoneNumber.this, MainActivity.class);
            startActivity(intent);
            finish();

        }
        getSupportActionBar().hide(); // to hide action bar
        binding.phoneLbl.requestFocus(); // for keyboard
        // for click on continue btn and verifying otp process
        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneNumber.this, OTPActivity.class);  //to to from
                intent.putExtra("phoneNumber", binding.phoneBox.getText().toString());
                startActivity(intent);
            }
        });
    }
}
package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Button bt = findViewById(R.id.button2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("로그인 성공!");
                finish();
            }
        });
    }

    private void showToast (String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    //정보입력
    //confirm
    //go!
}
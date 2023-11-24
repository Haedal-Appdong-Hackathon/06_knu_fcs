package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ChatsHamburgerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test", "hamburger on");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chats_hamburger);
    }
}
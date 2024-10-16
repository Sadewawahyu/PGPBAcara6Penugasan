package com.example.latihan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TabHost tabHost;
    private EditText etUsername, etPassword, email, confirmpassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("register");
        spec.setIndicator("Register");
        spec.setContent(R.id.register);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("login");
        spec.setIndicator("Login");
        spec.setContent(R.id.login);
        tabHost.addTab(spec);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals("register")) {
                    // Tampilkan form register
                    findViewById(R.id.register).setVisibility(View.VISIBLE);
                    findViewById(R.id.login).setVisibility(View.GONE);
                } else if (tabId.equals("login")) {
                    // Tampilkan form login
                    findViewById(R.id.register).setVisibility(View.GONE);
                    findViewById(R.id.login).setVisibility(View.VISIBLE);
                }
            }
        });

        etUsername = findViewById(R.id.username_login);
        etPassword = findViewById(R.id.password_login);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pindah ke SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // Logika serupa untuk tombol Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        TextView tvLogin = findViewById(R.id.tv_login);
        TextView tvRegister = findViewById(R.id.tv_register);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabHost.setCurrentTab(1); // Pindah ke layout "Login"
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabHost.setCurrentTab(0); // Pindah ke layout "Register"
            }
        });
    }

}

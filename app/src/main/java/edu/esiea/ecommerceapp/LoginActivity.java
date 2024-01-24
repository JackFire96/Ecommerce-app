package edu.esiea.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

// LoginActivity.java
public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement login logic here
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if(MainActivity.bdd.login(username,password)){
                    Log.d("TAG","laptet");
                // Create an Intent to start MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                // Start the activity
                startActivity(intent);

                // Finish the current activity to prevent going back to it
                finish();
                // Perform authentication (e.g., send data to a server)
                // Handle the response accordingly
            }}
        });
    }
}

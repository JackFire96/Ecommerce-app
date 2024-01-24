package edu.esiea.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import edu.esiea.ecommerceapp.MainActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement registration logic here
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Assuming 'register' method is a static method in your 'bdd' class
                MainActivity.bdd.register(username, password);

                // Create an Intent to start MainActivity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                // Start the activity
                startActivity(intent);

                // Finish the current activity to prevent going back to it
                finish();
            }
        });
    }
}

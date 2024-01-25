package edu.esiea.ecommerceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    public static FakeBdd bdd;
    private Button buttonLogin;
    private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bdd = new FakeBdd();

        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.bt_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    // Create an Intent to start MainActivity
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                    // Start the activity
                    startActivity(intent);

                    // Finish the current activity to prevent going back to it
                    finish();
                }
        });
                buttonRegister = findViewById(R.id.bt_signup);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start MainActivity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);

                // Start the activity
                startActivity(intent);

                // Finish the current activity to prevent going back to it
                finish();
            }});
    }
}

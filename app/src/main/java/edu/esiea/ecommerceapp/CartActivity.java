package edu.esiea.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// LoginActivity.java
public class CartActivity extends AppCompatActivity {

    private TextView textCartTitle;
    private TextView textCartTotal;
    private Button buttonClear;
    private Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        textCartTitle = findViewById(R.id.textCartTitle);
        textCartTotal = findViewById(R.id.textCartTotal);
        buttonClear = findViewById(R.id.buttonClear);
        buttonPay = findViewById(R.id.buttonPay);

        String username = "Jean";
        double total = 15.75;

        textCartTitle.setText("Panier de " + username);
        textCartTotal.setText("Total : " + String.format("%.2f $", total));

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //panier.clear();
            }
        });

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       /* buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement login logic here
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if(MainActivity.bdd.login(username,password)){
                    Log.d("TAG","laptet");
                    // Create an Intent to start MainActivity
                    Intent intent = new Intent(CartActivity.this, MainActivity.class);

                    // Start the activity
                    startActivity(intent);

                    // Finish the current activity to prevent going back to it
                    finish();
                    // Perform authentication (e.g., send data to a server)
                    // Handle the response accordingly
                }}
        });*/
    }
}

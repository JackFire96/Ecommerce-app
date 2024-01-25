package edu.esiea.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import edu.esiea.ecommerceapp.api.MyApiClient;
import edu.esiea.ecommerceapp.api.MyApiService;
import edu.esiea.ecommerceapp.api.ProductData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
                // Create an Intent to start MainActivity
                //Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                // Start the activity
                //startActivity(intent);
                    Retrofit retrofit = MyApiClient.create();
                    retrofit.create(MyApiService.class).getProduct("4").enqueue(new Callback<ProductData>(){
                        @Override
                        public void onResponse(Call<ProductData> call, Response<ProductData> response){
                            Log.d("la","al23");
                            editTextUsername.setText(response.body().getDescription());
                            Log.d("DescriptionApiProduct",response.body().getDescription());
                        }

                        @Override
                        public void onFailure(Call<ProductData> call, Throwable t){
                            Log.d("la","al25");
                            Log.d("error",t.getMessage());
                        }
                    });
                    Log.d("la","al");
                   // Log.d("MyApiTask", "API Response: " + result);
                // Finish the current activity to prevent going back to it
                //finish();
                // Perform authentication (e.g., send data to a server)
                // Handle the response accordingly
            }}
        });
    }
}

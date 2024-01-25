package edu.esiea.ecommerceapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.esiea.ecommerceapp.adapter.ItemAdapter;
import edu.esiea.ecommerceapp.adapter.ProductAdapter;
import edu.esiea.ecommerceapp.api.ProductData;
import edu.esiea.ecommerceapp.model.Cart;
import edu.esiea.ecommerceapp.model.Product;

// LoginActivity.java
public class HomeActivity extends AppCompatActivity {

    private Button buttonCart;
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //textCartTitle = findViewById(R.id.textCartTitle);
        //textCartTotal = findViewById(R.id.textCartTotal);
        buttonCart = findViewById(R.id.buttonCartSee);
        //buttonPay = findViewById(R.id.buttonPay);

        //String username = "Jean";

        List<Product> productList = new ArrayList<>();
        for (ProductData product : MainActivity.bdd.getProductList()) {
            productList.add(new Product(product.getTitle(), product.getPrice(), product.getDescription(), product.getImages()[0]));
        }
       // productList.add(new Product("T-Shirt blanc", 55.0, "Un T-shirt blanc", ""));
        //productList.add(new Product("Anneau en or", 4000.50, "Un anneau en or", ""));
        this.cart = new Cart(productList);
        afficherListeProduits();
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void afficherListeProduits() {
        RecyclerView recyclerView = findViewById(R.id.featuredProductsRecyclerView);
        ItemAdapter adapter = new ItemAdapter(cart.getProductList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

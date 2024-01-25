package edu.esiea.ecommerceapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.esiea.ecommerceapp.adapter.ProductAdapter;
import edu.esiea.ecommerceapp.api.ProductData;
import edu.esiea.ecommerceapp.model.Cart;
import edu.esiea.ecommerceapp.model.Product;

// LoginActivity.java
public class HomeActivity extends AppCompatActivity {

    private TextView textCartTitle;
    private TextView textCartTotal;
    private Button buttonClear;
    private Button buttonPay;
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //textCartTitle = findViewById(R.id.textCartTitle);
        //textCartTotal = findViewById(R.id.textCartTotal);
        //buttonClear = findViewById(R.id.buttonClear);
        //buttonPay = findViewById(R.id.buttonPay);

        //String username = "Jean";

        List<Product> productList = new ArrayList<>();
        for (ProductData product : MainActivity.bdd.productList) {
            productList.add(new Product(product.getTitle(), product.getPrice(), product.getDescription(), product.getImages()[0]));
        }
        productList.add(new Product("T-Shirt blanc", 55.0, "Un T-shirt blanc", ""));
        productList.add(new Product("Anneau en or", 4000.50, "Un anneau en or", ""));
        this.cart = new Cart(productList);
        afficherListeProduits();
    }
        /*buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                cart.clear();
                textCartTotal.setText("Total : " + String.format("%.2f $", cart.getTotal()));
            }
        });*/





    private void afficherListeProduits() {
        RecyclerView recyclerView = findViewById(R.id.featuredProductsRecyclerView);
        ProductAdapter adapter = new ProductAdapter(cart.getProductList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

package edu.esiea.ecommerceapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.esiea.ecommerceapp.adapter.ProductAdapter;
import edu.esiea.ecommerceapp.api.ProductData;
import edu.esiea.ecommerceapp.model.Cart;
import edu.esiea.ecommerceapp.model.Product;

// LoginActivity.java
public class CartActivity extends AppCompatActivity {

    private TextView textCartTitle;
    private TextView textCartTotal;
    private Button buttonClear;
    private Button buttonPay;
    private Button buttonLeave;
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        textCartTitle = findViewById(R.id.textCartTitle);
        textCartTotal = findViewById(R.id.textCartTotal);
        buttonClear = findViewById(R.id.buttonClear);
        buttonPay = findViewById(R.id.buttonPay);
        buttonLeave = findViewById(R.id.buttonLeave);

        String username = MainActivity.bdd.getUsernameOfLoggedUser();

        List<Product> productList = new ArrayList<>();
        productList = MainActivity.bdd.getProductCart();
        //productList.add(new Product("T-Shirt blanc", 55.0, "Un T-shirt blanc", ""));
        //productList.add(new Product("Anneau en or", 4000.50, "Un anneau en or", ""));

        cart = new Cart(productList);

        cart.calculateTotal();

        textCartTitle.setText("Panier de " + username);
        textCartTotal.setText("Total : " + String.format("%.2f $", cart.getTotal()));

        afficherListeProduits();
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popUp("Vider le panier", "Votre panier a bien été vidé.");

                cart.clear();
                textCartTotal.setText("Total : " + String.format("%.2f $", cart.getTotal()));
            }
        });

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bdd
                String message = "Félicitation ! Vous avez acheté ces articles :";
                for(Product product : cart.getProductList()) {
                    message += "\n- " + product.getName();
                }
                message += "\nPour un total de " + cart.getTotal() + "$.";
                popUp("Merci pour votre achat", message);

                cart.clear();
                textCartTotal.setText("Total : " + String.format("%.2f $", cart.getTotal()));
            }
        });

        buttonLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    private void popUp(String titlePop, String messagePop) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titlePop)
                .setMessage(messagePop)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        goBack();
                    }
                });

        // Affiche la pop-up
        builder.create().show();
    }

    private void afficherListeProduits() {
        RecyclerView recyclerView = findViewById(R.id.productListCart);
        ProductAdapter adapter = new ProductAdapter(cart.getProductList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void goBack() {
        Intent intent = new Intent(CartActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}

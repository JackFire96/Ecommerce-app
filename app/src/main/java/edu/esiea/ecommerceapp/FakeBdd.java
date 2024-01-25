package edu.esiea.ecommerceapp;

import java.util.ArrayList;
import java.util.HashMap;
import android.util.Log;
import edu.esiea.ecommerceapp.api.ProductData;
import edu.esiea.ecommerceapp.model.Product;

public class FakeBdd {
    private HashMap<String,String> bdd;
    private ProductData[] productList;

    public String getUsernameOfLoggedUser() {
        return usernameOfLoggedUser;
    }

    public void setUsernameOfLoggedUser(String usernameOfLoggedUser) {
        this.usernameOfLoggedUser = usernameOfLoggedUser;
    }

    private String usernameOfLoggedUser;

    public HashMap<String, String> getBdd() {
        return bdd;
    }

    public void setBdd(HashMap<String, String> bdd) {
        this.bdd = bdd;
    }

    public ProductData[] getProductList() {
        return productList;
    }

    public void setProductList(ProductData[] productList) {
        this.productList = productList;
    }

    public ArrayList<Product> getProductCart() {
        return productCart;
    }

    public void setProductCart(ArrayList<Product> productCart) {
        this.productCart = productCart;
    }

    private ArrayList<Product> productCart = new ArrayList<>();


    FakeBdd(){
        this.bdd = new HashMap<>();
        this.bdd.put("admin","pass");
        this.bdd.put("client","pass");
        this.productCart = new ArrayList<>();
    }

    public void addProductToCart(Product product){
        productCart.add(product);
    }
    public boolean login(String username, String password){
        Log.d("tag",password+" " + this.bdd.get(username));
        return this.bdd.get(username).equals( password);
    }
    public void register(String username, String password){
        this.bdd.put(username,password);
    }
}

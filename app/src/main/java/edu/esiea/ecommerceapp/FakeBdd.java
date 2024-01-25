package edu.esiea.ecommerceapp;

import java.util.HashMap;
import android.util.Log;

import edu.esiea.ecommerceapp.api.ProductData;

public class FakeBdd {
    HashMap<String,String> bdd;
    ProductData[] productList;

    FakeBdd(){
        this.bdd = new HashMap<>();
        this.bdd.put("admin","pass");
        this.bdd.put("client","pass");
    }
    public boolean login(String username, String password){
        Log.d("tag",password+" " + this.bdd.get(username));
        return this.bdd.get(username).equals( password);
    }
    public void register(String username, String password){
        this.bdd.put(username,password);
    }
}

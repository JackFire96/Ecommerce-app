package edu.esiea.ecommerceapp;

import java.util.HashMap;
import android.util.Log;

public class FakeBdd {
    HashMap<String,String> bdd;

    FakeBdd(){
        this.bdd = new HashMap<>();
    }
    public boolean login(String username, String password){
        Log.d("tag",password+" " + this.bdd.get(username));
        Log.d("tage",(this.bdd.get(username) == password));
        return this.bdd.get(username) == password;
    }
    public void register(String username, String password){
        this.bdd.put(username,password);
    }
}

package edu.esiea.ecommerceapp.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiClient {
    private static final String BASE_URL = "https://api.escuelajs.co";
    //private static final String BASE_URL = "https://reqres.in";

    public static Retrofit create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}

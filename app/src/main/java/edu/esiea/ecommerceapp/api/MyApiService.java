package edu.esiea.ecommerceapp.api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApiService {

    @GET("/products/{uid}")
    Call<ProductData> getProduct(@Path("uid") String uid); // Example endpoint for getting products

    // Add more methods for other API endpoints as needed
}

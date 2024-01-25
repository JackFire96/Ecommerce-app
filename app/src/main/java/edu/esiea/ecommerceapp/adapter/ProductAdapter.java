package edu.esiea.ecommerceapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.esiea.ecommerceapp.R;
import edu.esiea.ecommerceapp.model.Product;
import edu.esiea.ecommerceapp.viewholder.ProductViewHolder;

// ProductAdapter.java
public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productNameTextView.setText(product.getName());
        holder.productPriceTextView.setText(String.format("%.2f €", product.getPrice()));
        //holder.productDescriptionTextView.setText(product.getDescription());
        //holder.productImageView.setImageResource(product.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}


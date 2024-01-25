package edu.esiea.ecommerceapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.esiea.ecommerceapp.MainActivity;
import edu.esiea.ecommerceapp.R;
import edu.esiea.ecommerceapp.model.Product;
import edu.esiea.ecommerceapp.viewholder.ProductViewHolder;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.YourViewHolder> {

    // Other methods in your adapter
    private List<Product> productList;

    public ItemAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void onBindViewHolder(@NonNull YourViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.itemButton.setText("add to cart");
        holder.productNameTextView.setText(product.getName());
        holder.productPriceTextView.setText(String.format("%.2f €", product.getPrice()));

        holder.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.bdd.addProductToCart(product);
            }
            });
       //holder.productDescriptionTextView.setText(product.getDescription());
        //holder.productImageView.setImageResource(product.getImageResourceId());
    }
    @NonNull
    @Override
    public YourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new YourViewHolder(itemView);
    }

    // Other methods in your adapter

    class YourViewHolder extends RecyclerView.ViewHolder {
        Button itemButton;
        public TextView productNameTextView;
        public TextView productPriceTextView;

        YourViewHolder(View itemView) {
            super(itemView);
            itemButton = itemView.findViewById(R.id.itemButton);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            // Set click listener for the button or perform other actions as needed
            itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click for this item
                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return productList.size();
    }
}

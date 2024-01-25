package edu.esiea.ecommerceapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import edu.esiea.ecommerceapp.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    public TextView productNameTextView;
    public TextView productPriceTextView;
    public TextView productDescriptionTextView;
    public ImageView productImageView;

    public ProductViewHolder(View itemView) {
        super(itemView);
        productNameTextView = itemView.findViewById(R.id.productNameTextView);
        productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
        productDescriptionTextView = itemView.findViewById(R.id.productDescriptionTextView);
        //productImageView = itemView.findViewById(R.id.productImageView);
    }
}

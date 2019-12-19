package com.elhady.donation.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.elhady.donationp.Interface.ItemClickListener;
import com.elhady.donationp.R;

/**
 * Created by El-hady on 5/21/2018.
 */
public class DrugsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView drugs_name;
    public ImageView drugs_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DrugsViewHolder(View itemView) {
        super(itemView);

        drugs_name  = (TextView) itemView.findViewById(R.id.drugs_name);
        drugs_image = (ImageView) itemView.findViewById(R.id.drugs_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}

package com.lesenia.mobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.MedicineViewHolder> {

    private final Context context;
    private List<Pharmacy> pharmacyList;

    PharmacyAdapter(Context context, List<Pharmacy> pharmacyList) {
        this.context = context;
        this.pharmacyList = pharmacyList;
    }

    @NonNull
    @Override
    public PharmacyAdapter.MedicineViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                                 final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicine, parent, false);
        return new MedicineViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MedicineViewHolder holder, final int position) {
        Picasso.get().load(pharmacyList.get(position).getPhotoUrl()).into(holder.photoUrl);
        holder.name.setText(pharmacyList.get(position).getName());
        holder.category.setText(pharmacyList.get(position).getCategory());
        holder.producer.setText(pharmacyList.get(position).getProducer());
        holder.price.setText(pharmacyList.get(position).getPrice());
        holder.components.setText(pharmacyList.get(position).getComponents());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemDetails(position);
            }

            private void openItemDetails(int position) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", pharmacyList.get(position).getName());
                intent.putExtra("category", pharmacyList.get(position).getCategory());
                intent.putExtra("producer", pharmacyList.get(position).getProducer());
                intent.putExtra("price", pharmacyList.get(position).getPrice());
                intent.putExtra("components", pharmacyList.get(position).getComponents());
                intent.putExtra("image", pharmacyList.get(position).getPhotoUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (pharmacyList == null)
            return 0;
        return pharmacyList.size();
    }

    class MedicineViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout parentLayout;
        private TextView name;
        private TextView category;
        private TextView producer;
        private TextView price;
        private TextView components;
        private ImageView photoUrl;

        private MedicineViewHolder(final View itemView) {
            super(itemView);

            photoUrl = itemView.findViewById(R.id.item_medicine_image);
            name = itemView.findViewById(R.id.item_medicine_name);
            category = itemView.findViewById(R.id.item_medicine_category);
            producer = itemView.findViewById(R.id.item_medicine_producer);
            price = itemView.findViewById(R.id.item_medicine_price);
            components = itemView.findViewById(R.id.item_medicine_components);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
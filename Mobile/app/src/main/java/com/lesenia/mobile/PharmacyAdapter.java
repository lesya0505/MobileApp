package com.lesenia.mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.MedicineViewHolder> {

<<<<<<< Updated upstream
    private List<Pharmacy> pharmacyList;

  public PharmacyAdapter(List<Pharmacy> pharmacyList){
=======
    private final Context context;
    public List<Pharmacy> pharmacyList;

    public  PharmacyAdapter(Context context, List<Pharmacy> pharmacyList) {
        this.context = context;
>>>>>>> Stashed changes
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
        holder.packaging.setText(pharmacyList.get(position).getPackaging());
        holder.producer.setText(pharmacyList.get(position).getProducer());
        holder.price.setText(pharmacyList.get(position).getPrice());
        holder.components.setText(pharmacyList.get(position).getComponents());
    }

    @Override
    public int getItemCount() {
        if (pharmacyList == null)
            return 0;
        return pharmacyList.size();
    }

    class MedicineViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView category;
        private TextView packaging;
        private TextView producer;
        private TextView price;
        private TextView components;
        private ImageView photoUrl;

        private MedicineViewHolder(final View itemView) {
            super(itemView);

            photoUrl = itemView.findViewById(R.id.item_medicine_image_view);
            name =  itemView.findViewById(R.id.item_medicine_name);
            category = itemView.findViewById(R.id.item_medicine_category);
            packaging =  itemView.findViewById(R.id.item_medicine_packaging);
            producer =  itemView.findViewById(R.id.item_medicine_producer);
            price =  itemView.findViewById(R.id.item_medicine_price);
            components = itemView.findViewById(R.id.item_medicine_components);
        }
    }
}
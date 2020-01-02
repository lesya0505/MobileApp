package com.lesenia.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.lesenia.mobile.PharmacyApi;
import com.lesenia.mobile.RetrofitEx;
import com.lesenia.mobile.Pharmacy;
import com.lesenia.mobile.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class PostMedicineActivity  extends AppCompatActivity {

    private TextInputLayout nameFieldLayout;
    private TextInputLayout categoryFieldLayout;
    private TextInputLayout producerFieldLayout;
    private TextInputLayout priceFieldLayout;
    private TextInputEditText nameField;
    private TextInputEditText categoryField;
    private TextInputEditText producerField;
    private TextInputEditText priceField;
    private Button submitBtn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_post);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        initViews();

        submitBtn.setOnClickListener(view -> onPressSubmitBtn());
    }

    private void onPressSubmitBtn() {
        String name = Objects.requireNonNull(nameField.getText()).toString().trim();
        String category = Objects.requireNonNull(categoryField.getText()).toString().trim();
        String producer = Objects.requireNonNull(producerField.getText()).toString().trim();
        String price = Objects.requireNonNull(priceField.getText()).toString().trim();
        if (isDataValid(name, category, producer, price)) {
            Pharmacy pharmacy = new Pharmacy(name, category, producer, price);
            addPharmacy(pharmacy);
        }
    }

    private void addPharmacy(Pharmacy pharmacy) {
        final PharmacyApi pharmacyApi = getRetrofitEx().getPharmacyApi();
        Call<Pharmacy> call = pharmacyApi.createPharmacy(pharmacy);
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<Pharmacy>() {
            @Override
            public void onResponse(Call<Pharmacy> call, Response<Pharmacy> response) {
                progressBar.setVisibility(View.INVISIBLE);
                startActivity(new Intent(PostMedicineActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<Pharmacy> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                startActivity(new Intent(PostMedicineActivity.this, MainActivity.class));
            }
        });
    }

    private void initViews() {
        nameField = findViewById(R.id.post_medicine_name);
        categoryField = findViewById(R.id.post_medicine_category);
        producerField = findViewById(R.id.post_medicine_producer);
        priceField = findViewById(R.id.post_medicine_price);
        submitBtn = findViewById(R.id.post_medicine_submitBtn);
        progressBar = findViewById(R.id.post_progress_bar);
        nameFieldLayout = findViewById(R.id.post_medicine_name_layout);
        categoryFieldLayout = findViewById(R.id.post_medicine_category_layout);
        producerFieldLayout = findViewById(R.id.post_medicine_producer_layout);
        priceFieldLayout = findViewById(R.id.post_medicine_price_layout);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(PostMedicineActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private RetrofitEx getRetrofitEx() {
        return ((RetrofitEx) Objects.requireNonNull(this.getApplication()));
    }

    private boolean isDataValid(String name, String category, String producer, String price) {
        boolean nameValid = isFieldValid(name, nameFieldLayout);
        boolean categoryValid = isFieldValid(category, categoryFieldLayout);
        boolean producerValid = isFieldValid(producer, producerFieldLayout);
        boolean priceValid = isFieldValid(price, priceFieldLayout);

        return nameValid && categoryValid && producerValid && priceValid;
    }

    private boolean isFieldValid(String field, TextInputLayout fieldLayout) {
        if (field.isEmpty()) {
            fieldLayout.setError(getString(R.string.required));
            fieldLayout.requestFocus();
            return false;
        } else {
            fieldLayout.setError(null);
            return true;
        }
    }
}
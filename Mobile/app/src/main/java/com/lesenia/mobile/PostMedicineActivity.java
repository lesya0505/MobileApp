package com.lesenia.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostMedicineActivity extends AppCompatActivity {

    private TextInputEditText nameField;
    private TextInputEditText categoryField;
    private TextInputEditText producerField;
    private TextInputEditText priceField;
    private TextInputLayout nameFieldLayout;
    private TextInputLayout categoryFieldLayout;
    private TextInputLayout producerFieldLayout;
    private TextInputLayout priceFieldLayout;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_post);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        initViews();

        submitBtn.setOnClickListener(view -> onPressSubmitBtn());
    }

    private void onPressSubmitBtn() {
        String name = Objects.requireNonNull(nameField.getText()).toString();
        String category = Objects.requireNonNull(categoryField.getText()).toString();
        String producer = Objects.requireNonNull(producerField.getText()).toString();
        String price = Objects.requireNonNull(priceField.getText()).toString();
        {
            Pharmacy pharmacy = new Pharmacy(name, category, producer, price);
            addPharmacy(pharmacy);
        }
    }

    private void addPharmacy(Pharmacy pharmacy) {
        final PharmacyApi pharmacyApi = getRetrofitEx().getPharmacyApi();
        Call<Pharmacy> call = pharmacyApi.createPharmacy(pharmacy);
        call.enqueue(new Callback<Pharmacy>() {
            @Override
            public void onResponse(Call<Pharmacy> call, Response<Pharmacy> response) {
                Toast.makeText(PostMedicineActivity.this, getString(R.string.success), Toast.LENGTH_LONG).show();
                startActivity(new Intent(PostMedicineActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<Pharmacy> call, Throwable t) {
                Toast.makeText(PostMedicineActivity.this, getString(R.string.fail), Toast.LENGTH_LONG).show();
                startActivity(new Intent(PostMedicineActivity.this, MainActivity.class));
            }
        });
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

    private void initViews() {
        nameField = findViewById(R.id.post_medicine_name);
        categoryField = findViewById(R.id.post_medicine_category);
        producerField = findViewById(R.id.post_medicine_producer);
        priceField = findViewById(R.id.post_medicine_price);
        submitBtn = findViewById(R.id.post_medicine_submitBtn);
        nameFieldLayout = findViewById(R.id.post_medicine_name_layout);
        categoryFieldLayout = findViewById(R.id.post_medicine_category_layout);
        producerFieldLayout = findViewById(R.id.post_medicine_producer_layout);
        priceFieldLayout = findViewById(R.id.post_medicine_price_layout);
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
        private RetrofitEx getRetrofitEx() {
            return ((RetrofitEx) Objects.requireNonNull(this.getApplication()));
        }
}

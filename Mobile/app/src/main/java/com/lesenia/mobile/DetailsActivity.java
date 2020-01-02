package com.lesenia.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.lesenia.mobile.R;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    private TextView name;
    private TextView category;
    private TextView producer;
    private TextView price;
    private TextView components;
    private ImageView photoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getIncomingIntent();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("name") &&
                getIntent().hasExtra("category") &&
                getIntent().hasExtra("producer") &&
                getIntent().hasExtra("price") &&
                getIntent().hasExtra("components")) {
            String nameInfo = getIntent().getStringExtra("name");
            String categoryInfo = getIntent().getStringExtra("category");
            String producerInfo = getIntent().getStringExtra("producer");
            String priceInfo = getIntent().getStringExtra("price");
            String componentsInfo = getIntent().getStringExtra("components");
            String photoUrlInfo = getIntent().getStringExtra("image");

            setInfo(nameInfo, categoryInfo, producerInfo, priceInfo, componentsInfo, photoUrlInfo);
        }
    }

    private void setInfo(String nameInfo,
                         String categoryInfo,
                         String producerInfo,
                         String priceInfo,
                         String componentsInfo,
                         String photoUrlInfo) {
        initViews();
        name.setText(nameInfo);
        category.setText(categoryInfo);
        producer.setText(producerInfo);
        price.setText(priceInfo);
        components.setText(componentsInfo);
        Picasso.get().load(photoUrlInfo).into(photoUrl);
    }

    private void initViews() {
        name = findViewById(R.id.details_name);
        category = findViewById(R.id.details_category);
        producer = findViewById(R.id.details_producer);
        price = findViewById(R.id.details_price);
        components = findViewById(R.id.details_components);
        photoUrl = findViewById(R.id.details_image);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

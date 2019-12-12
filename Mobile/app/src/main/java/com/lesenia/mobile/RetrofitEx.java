package com.lesenia.mobile;

import android.annotation.SuppressLint;
import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("Registered")
public class RetrofitEx extends Application {

    private PharmacyApi pharmacyApi;
    private FirebaseAuth auth;

    public void onCreate() {
        super.onCreate();
        auth = FirebaseAuth.getInstance();
        pharmacyApi = createPharmacyApi();
    }

    public FirebaseAuth getAuth() {
        return auth;
    }

    public PharmacyApi getPharmacyApi() {
        return pharmacyApi;
    }

    private PharmacyApi createPharmacyApi() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-mobile-88bce.cloudfunctions.net/pharmacy/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PharmacyApi.class);
    }
}
package com.lesenia.mobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PharmacyApi {
    @GET("pharmacy")
    Call<List<Pharmacy>> getPharmacy();
}

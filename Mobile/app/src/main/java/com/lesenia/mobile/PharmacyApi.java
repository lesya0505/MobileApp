package com.lesenia.mobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PharmacyApi {
    @GET("pharmacy")
    Call<List<Pharmacy>> getPharmacy();

    @POST("pharmacy")
    Call<Pharmacy> createPharmacy(@Body Pharmacy pharmacy);
}
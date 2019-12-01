package com.lesenia.mobile;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayout linearLayout;
    private PharmacyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        initViews();
        registerNetworkMonitoring();
        loadPharmacy();
    }

    private void registerNetworkMonitoring() {
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_ACTION");
        NetworkChangeReceiver receiver = new NetworkChangeReceiver(linearLayout);
        this.registerReceiver(receiver, filter);
    }

    private void initViews(){
        recyclerView = findViewById(R.id.data_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        linearLayout = findViewById(R.id.linearLayout);
        swipeRefreshLayout = findViewById(R.id.data_list_swipe_refresh);
        setupSwipeToRefresh();
    }

    private void loadPharmacy(){
        swipeRefreshLayout.setRefreshing(true);
        final PharmacyApi pharmacyApi = getApp().getPharmacyApi();
        final Call<List<Pharmacy>> call = pharmacyApi.getPharmacy();

        call.enqueue(new Callback<List<Pharmacy>>() {
            @Override
            public void onResponse( Call<List<Pharmacy>> call,
                                    Response<List<Pharmacy>> response) {
                adapter = new PharmacyAdapter(response.body());
                recyclerView.setAdapter(adapter);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Pharmacy>> call, Throwable t) {
                Snackbar.make(linearLayout, R.string.failure, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void setupSwipeToRefresh(){
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        loadPharmacy();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
    }

    private App getApp(){
        return ((App) getApplication());
    }
}

package com.lesenia.mobile;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.google.android.material.snackbar.Snackbar;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private View view;

    public NetworkChangeReceiver(View view) {
        super();
        this.view = view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    public void onReceive(Context context, Intent intent) {
        if (!isOnline(context)) {
            Snackbar.make(view, R.string.no_internet, Snackbar.LENGTH_LONG).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        }

        NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return capabilities != null &&
                (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI));
    }
}
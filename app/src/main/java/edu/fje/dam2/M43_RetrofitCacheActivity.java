package edu.fje.dam2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

/**
 * Classe que demostra la personalització amb Retrofit, OkHttp i cau en disc
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 26.11.2018
 * @version 2.0, 1/10/2020 actualització a API30
 * @version 3.0, 1/11/2026 actualització a Retrofit + OkHttp
 */

public class M43_RetrofitCacheActivity extends AppCompatActivity {

    public interface ApiService {
        @GET("/")
        Call<String> getData();
    }

    @Override
    protected void onCreate(Bundle instanciaDesada) {
        super.onCreate(instanciaDesada);
        setContentView(R.layout.m42_retrofit_basic);
        final TextView textSortida = findViewById(R.id.sortida);

        // Gestió de la cau amb OkHttp (1MB)
        File cacheDir = new File(getCacheDir(), "http_cache");
        Cache cache = new Cache(cacheDir, 1024 * 1024);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:8000/")
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getData().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    textSortida.setText("Resposta ok (Cache/OkHttp)!");
                } else {
                    textSortida.setText("no funciona!");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                textSortida.setText("no funciona!");
            }
        });
    }
}

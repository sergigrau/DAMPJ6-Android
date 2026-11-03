package edu.fje.dam2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Classe que demostra el funcionament de Retrofit amb objectes JSON i Gson
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 26.11.2018
 * @version 2.0, 1/1/2021 actualització a API30
 * @version 3.0, 1/11/2026 actualització a Retrofit + OkHttp
 */

public class M44_RetrofitJsonActivity extends AppCompatActivity {

    public interface ApiService {
        @GET("/")
        Call<JsonObject> getData(@Query("nom") String nom);
    }

    @Override
    protected void onCreate(Bundle instanciaDesada) {
        super.onCreate(instanciaDesada);
        setContentView(R.layout.m42_retrofit_basic);
        final TextView textSortida = findViewById(R.id.sortida);

        File cacheDir = new File(getCacheDir(), "http_cache");
        Cache cache = new Cache(cacheDir, 1024 * 1024);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:8000/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getData("sergi").enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        JsonObject json = response.body();
                        String data = json.has("data") ? json.get("data").getAsString() : json.toString();
                        textSortida.setText("resposta: " + data);
                    } catch (Exception e) {
                        textSortida.setText("resposta: " + response.body().toString());
                    }
                } else {
                    textSortida.setText("problema:");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                textSortida.setText("problema:");
                t.printStackTrace();
            }
        });
    }
}

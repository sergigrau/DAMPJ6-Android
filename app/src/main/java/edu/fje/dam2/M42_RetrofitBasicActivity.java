package edu.fje.dam2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

/**
 * Classe que demostra el funcionament bàsic amb Retrofit i OkHttp
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 26.11.2018
 * @version 2.0, 10.1.21 actualització a API30
 * @version 3.0, 1/11/2026 actualització a Retrofit + OkHttp
 */

public class M42_RetrofitBasicActivity extends AppCompatActivity {

    public interface ApiService {
        @GET("/")
        Call<String> getData();
    }

    @Override
    protected void onCreate(Bundle instanciaDesada) {
        super.onCreate(instanciaDesada);
        setContentView(R.layout.m42_volley_basic);
        final TextView textSortida = findViewById(R.id.sortida);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:8000/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getData().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() && response.body() != null) {
                    textSortida.setText("La resposta és: " + response.body());
                } else {
                    textSortida.setText("Resposta error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                textSortida.setText("no funciona!");
            }
        });
    }
}

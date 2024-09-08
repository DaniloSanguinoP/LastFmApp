package com.example.lastfmapp.dataAccess;

import static com.example.lastfmapp.constants.AppConstant.BASE_URL;

import com.example.lastfmapp.data.interactors.LoggingInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;

    // Constructor privado para evitar la creación de múltiples instancias
    private RetrofitClient() {
    }

    // Método público estático para obtener la instancia de Retrofit
    public static Retrofit getInstance() {
        if (retrofit == null) {
            LoggingInterceptor loggingInterceptor = new LoggingInterceptor();

            // Si necesitas también logs detallados del HTTP
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Crear el cliente OkHttp y agregar los interceptores
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor) // Interceptor personalizado
                    .addInterceptor(httpLoggingInterceptor) // Para logs detallados
                    .build();
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

}

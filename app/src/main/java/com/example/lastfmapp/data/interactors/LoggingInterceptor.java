package com.example.lastfmapp.data.interactors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;

public class LoggingInterceptor implements Interceptor {

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // Obtener la URL de la solicitud
        String url = request.url().toString();
        System.out.println("Request URL: " + url);

        // Realizar la solicitud y capturar la respuesta
        okhttp3.Response response = chain.proceed(request);

        // Obtener la respuesta en formato de texto
        String responseBody = response.body() != null ? response.body().string() : "Response body is null";
        System.out.println("Response: " + responseBody);

        // Devuelve una nueva respuesta con el body original para que Retrofit pueda consumirlo
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(response.body().contentType(), responseBody))
                .build();
    }
}

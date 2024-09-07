package com.example.lastfmapp.data.interactors;

import static com.example.lastfmapp.constants.AppConstant.API_KEY;
import static com.example.lastfmapp.constants.AppConstant.BASE_URL;
import static com.example.lastfmapp.constants.AppConstant.LIMIT;
import static com.example.lastfmapp.constants.AppConstant.LOCATION;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.lastfmapp.data.model.Artists;
import com.example.lastfmapp.data.model.TopArtistsResponse;
import com.example.lastfmapp.retrofit.ApiRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtistsInteractor {

    public ArtistsInteractor() {

    }

    //Obtener artistas
    public MutableLiveData<ArrayList<Artists>> getTopArtists() {

        MutableLiveData<ArrayList<Artists>> artistsData = new MutableLiveData<>();

        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiRequest apiRequest = retrofit.create(ApiRequest.class);
            Call<TopArtistsResponse> artistisRequestCall = apiRequest.getArtists(LOCATION, API_KEY, LIMIT);

            artistisRequestCall.enqueue(new Callback<TopArtistsResponse>() {
                @Override
                public void onResponse(Call<TopArtistsResponse> call, Response<TopArtistsResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {

                        artistsData.setValue(response.body().getTopartists().getArtist());

                    } else {
                        Log.e("ERROR", "onResponse: " + response.errorBody());
                    }

                }

                @Override
                public void onFailure(Call<TopArtistsResponse> call, Throwable t) {
                    Log.e("ERROR", "onFailure: " + t);
                }
            });

        } catch (Exception e) {
            Log.e("ERROR", "Exception: " + e);
        }
        return artistsData;
    }
}

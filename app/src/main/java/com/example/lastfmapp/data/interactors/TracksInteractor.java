package com.example.lastfmapp.data.interactors;

import static com.example.lastfmapp.constants.AppConstant.API_KEY;
import static com.example.lastfmapp.constants.AppConstant.LIMIT_TRACKS;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.lastfmapp.data.model.TopTracksResponse;
import com.example.lastfmapp.data.model.Tracks;
import com.example.lastfmapp.dataAccess.ApiRequest;
import com.example.lastfmapp.dataAccess.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TracksInteractor {

    public TracksInteractor() {
    }

    /**Obtiene la lista de las canciones del servio.*/
    public MutableLiveData<List<Tracks>> getTopTracks(String artistName) {

        MutableLiveData<List<Tracks>> tracksData = new MutableLiveData<>();

        try {
            Retrofit retrofit = RetrofitClient.getInstance();

            ApiRequest apiRequest = retrofit.create(ApiRequest.class);
            Call<TopTracksResponse> tracksRequestCall = apiRequest.getTracks(artistName, API_KEY, LIMIT_TRACKS);

            tracksRequestCall.enqueue(new Callback<TopTracksResponse>() {
                @Override
                public void onResponse(Call<TopTracksResponse> call, Response<TopTracksResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {

                        tracksData.setValue(response.body().getTopTracks().getTracks());

                    } else {
                        Log.e("ERROR", "onResponse: " + response.errorBody());
                    }

                }

                @Override
                public void onFailure(Call<TopTracksResponse> call, Throwable t) {
                    Log.e("ERROR", "onFailure: " + t);
                }
            });

        } catch (Exception e) {
            Log.e("ERROR", "Exception: " + e);
        }
        return tracksData;
    }

}


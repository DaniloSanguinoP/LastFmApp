package com.example.lastfmapp.retrofit;

import com.example.lastfmapp.data.model.Artists;
import com.example.lastfmapp.data.model.TopArtistsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("?method=geo.gettopartists&format=json")
    Call<TopArtistsResponse> getArtists(
            @Query("country") String country,
            @Query("api_key") String apiKey,
            @Query("limit") int limit
    );
}

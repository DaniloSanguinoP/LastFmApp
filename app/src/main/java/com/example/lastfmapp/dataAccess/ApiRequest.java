package com.example.lastfmapp.dataAccess;

import com.example.lastfmapp.constants.AppConstant;
import com.example.lastfmapp.data.model.TopArtistsResponse;
import com.example.lastfmapp.data.model.TopTracksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("?method=geo.gettopartists&format=json")
    Call<TopArtistsResponse> getArtists(
            @Query(AppConstant.COUNTRY_PARAM) String country,
            @Query(AppConstant.API_KEY_PARAM) String apiKey,
            @Query(AppConstant.LIMIT_PARAM) int limit
    );

    @GET("?method=artist.gettoptracks&format=json")
    Call<TopTracksResponse> getTracks(
            @Query(AppConstant.ARTIST_PARAM) String artistName,
            @Query(AppConstant.API_KEY_PARAM) String apiKey,
            @Query(AppConstant.LIMIT_PARAM) int limit
    );

}

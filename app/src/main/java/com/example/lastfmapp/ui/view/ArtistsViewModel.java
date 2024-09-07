package com.example.lastfmapp.ui.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lastfmapp.data.interactors.ArtistsInteractor;
import com.example.lastfmapp.data.model.Artists;

import java.util.ArrayList;

public class ArtistsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Artists>> artists;
    private ArtistsInteractor artistsInteractor;

    public ArtistsViewModel() {
        artistsInteractor = new ArtistsInteractor();
    }

    public LiveData<ArrayList<Artists>> getTopArtists() {
        if (artists == null) {
            artists = artistsInteractor.getTopArtists();
        }
        return artists;
    }

}
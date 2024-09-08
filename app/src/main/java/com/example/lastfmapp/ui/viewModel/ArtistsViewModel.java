package com.example.lastfmapp.ui.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lastfmapp.data.interactors.ArtistsInteractor;
import com.example.lastfmapp.data.model.Artists;

import java.util.List;

public class ArtistsViewModel extends ViewModel {

    private MutableLiveData<List<Artists>> artists;
    private ArtistsInteractor artistsInteractor;

    public ArtistsViewModel() {
        artistsInteractor = new ArtistsInteractor();
    }

    public LiveData<List<Artists>> getArtists() {
        return artists;
    }

    public LiveData<List<Artists>> getTopArtists() {
        if (artists == null) {
            artists = artistsInteractor.getTopArtists();
        }
        return artists;
    }

}
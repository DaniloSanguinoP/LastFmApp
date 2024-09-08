package com.example.lastfmapp.ui.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lastfmapp.data.interactors.TracksInteractor;
import com.example.lastfmapp.data.model.Tracks;

import java.util.List;

public class TrackViewModel extends ViewModel {

    private MutableLiveData<List<Tracks>> track;
    private TracksInteractor tracksInteractor;

    public TrackViewModel() {
        tracksInteractor = new TracksInteractor();
    }

    public LiveData<List<Tracks>> getTopTrack(String artistName) {
        if(track == null) {
            track = tracksInteractor.getTopTracks(artistName);
        }
        return track;
    }
}
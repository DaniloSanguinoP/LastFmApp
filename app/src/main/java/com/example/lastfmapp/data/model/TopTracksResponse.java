package com.example.lastfmapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopTracksResponse {

    @SerializedName("toptracks")
    private TopTracks topTracks;

    public static class TopTracks {
        @SerializedName("track")
        private List<Tracks> tracks;

        public List<Tracks> getTracks() {
            return tracks;
        }

        public void setTracks(List<Tracks> tracks) {
            this.tracks = tracks;
        }

    }


    public TopTracks getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(TopTracks topTracks) {
        this.topTracks = topTracks;
    }
}

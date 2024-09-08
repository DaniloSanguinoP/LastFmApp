package com.example.lastfmapp.data.model;

import java.util.List;

public class TopArtistsResponse {
    private TopArtists topartists;

    public static class TopArtists {
        private List<Artists> artist;

        // Getters y Setters
        public List<Artists> getArtist() {
            return artist;
        }

        public void setArtist(List<Artists> artist) {
            this.artist = artist;
        }
    }

    // Getters y Setters
    public TopArtists getTopartists() {
        return topartists;
    }

    public void setTopartists(TopArtists topartists) {
        this.topartists = topartists;
    }
}

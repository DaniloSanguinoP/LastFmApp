package com.example.lastfmapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopTracksResponse {

    @SerializedName("toptracks")
    private TopTracks topTracks;

    public static class TopTracks {
        @SerializedName("track")
        private List<Tracks> tracks;

        @SerializedName("@attr")
        private Attr attr;

        public List<Tracks> getTracks() {
            return tracks;
        }

        public void setTracks(List<Tracks> tracks) {
            this.tracks = tracks;
        }

        public Attr getAttr() {
            return attr;
        }

        public void setAttr(Attr attr) {
            this.attr = attr;
        }

        public static class Attr {
            private String artist;
            private String page;
            private String total;
            private String totalPages;
            private String perPage;

            public String getArtist() {
                return artist;
            }

            public void setArtist(String artist) {
                this.artist = artist;
            }

            public String getPage() {
                return page;
            }

            public void setPage(String page) {
                this.page = page;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getTotalPages() {
                return totalPages;
            }

            public void setTotalPages(String totalPages) {
                this.totalPages = totalPages;
            }

            public String getPerPage() {
                return perPage;
            }

            public void setPerPage(String perPage) {
                this.perPage = perPage;
            }
        }
    }


    public TopTracks getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(TopTracks topTracks) {
        this.topTracks = topTracks;
    }
}

package com.example.lastfmapp.data.model;

import java.util.List;

public class TopArtistsResponse {
    private TopArtists topartists;

    public static class TopArtists {
        private List<Artists> artist;
        private Attr attr;

        public static class Attr {
            private String country;
            private String page;
            private String total;
            private String totalPages;
            private String perPage;

            // Getters y Setters

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
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

        // Getters y Setters
        public List<Artists> getArtist() {
            return artist;
        }

        public void setArtist(List<Artists> artist) {
            this.artist = artist;
        }

        public Attr getAttr() {
            return attr;
        }

        public void setAttr(Attr attr) {
            this.attr = attr;
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

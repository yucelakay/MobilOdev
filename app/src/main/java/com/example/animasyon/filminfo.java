package com.example.animasyon;


public class filminfo {

      String filmAdi;
      String filmYil;
      String filmurl;

    public filminfo(String filmAdi, String filmYil, String filmurl) {
        this.filmAdi = filmAdi;
        this.filmYil = filmYil;
        this.filmurl = filmurl;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getFilmYil() {
        return filmYil;
    }

    public void setFilmYil(String filmYil) {
        this.filmYil = filmYil;
    }

    public String getFilmurl() {
        return filmurl;
    }

    public void setFilmurl(String filmurl) {
        this.filmurl = filmurl;
    }
}

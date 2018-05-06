package com.example.huseyincengiz.obsswatering.Models;

/**
 * Created by HuseyinCengiz on 5.05.2018.
 */

public class Sebze {

    public String sebzeAdi;
    public int photoId;
    public int baslangicKonumu;
    public int bitisKonumu;
    public int tour;

    public Sebze() {
    }

    public Sebze(String sebzeAdi, int photoId, int baslangicKonumu, int bitisKonumu, int tour) {
        this.sebzeAdi = sebzeAdi;
        this.photoId = photoId;
        this.baslangicKonumu = baslangicKonumu;
        this.bitisKonumu = bitisKonumu;
        this.tour = tour;
    }

    public String getSebzeAdi() {
        return sebzeAdi;
    }

    public void setSebzeAdi(String sebzeAdi) {
        this.sebzeAdi = sebzeAdi;
    }

    public int getBaslangicKonumu() {
        return baslangicKonumu;
    }

    public void setBaslangicKonumu(int baslangicKonumu) {
        this.baslangicKonumu = baslangicKonumu;
    }

    public int getBitisKonumu() {
        return bitisKonumu;
    }

    public void setBitisKonumu(int bitisKonumu) {
        this.bitisKonumu = bitisKonumu;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getPhotoUrl() {
        return photoId;
    }

    public void setPhotoUrl(int photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "{"+"\"start\""+":" + baslangicKonumu +
                ","+"\"end\""+":" + bitisKonumu +
                ","+"\"tour\""+":" + tour +
                '}';
    }
}

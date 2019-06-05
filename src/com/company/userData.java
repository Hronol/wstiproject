package com.company;

public class userData{
    private String imie, nazwisko, nazwaCzesci;
    private int rocznik, nip;
    private static int idKlienta = 0;
    private static int idJob = 0;

    public userData() {
        imie = " ";
        nazwisko = " ";
        nazwaCzesci = " ";
        rocznik = 0;
        nip = 0;
        idJob = ++idKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwaCzesci() {
        return nazwaCzesci;
    }

    public void setNazwaCzesci(String nazwaCzesci) {
        this.nazwaCzesci = nazwaCzesci;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public int getIdKlienta() {
        return idKlienta;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }


}

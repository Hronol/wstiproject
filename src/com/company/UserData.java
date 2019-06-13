package com.company;


public class UserData {
    private String imie, nazwisko;
    private int nip;
    private static int idKlienta = 0;
    private static int idJob = 0;

    public UserData(String imie, String nazwisko, int nip) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nip = nip;
    }

    public UserData(){
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public int getNip(){
        return nip;
    }

    public void createUser(UserData user){
        return new UserData();
    }

}

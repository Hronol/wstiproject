package com.company;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class UserData {
    private String imie, nazwisko;
    private int nip;
    private static int idKlienta = 0;
    private static int idJob = 0;

    private UserData(String imie, String nazwisko, int nip) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nip = nip;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String imie, nazwisko;
        private int nip;
    }

    UserBuilder(){
    }

    public UserBuilder imie(String imie){
        this.imie = imie;
    }

    public UserBuilder nazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }

    public UserBuilder nip(int nip){
        this.nip = nip;
    }

    public UserData (){
        return new UserData(imie, nazwisko, nip);
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

    @Override
    public String toString(){
        return "Klient: "+imie+" "+nazwisko+" "+nip;
    }
}

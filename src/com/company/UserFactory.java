package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFactory extends UserService{

    private Scanner wpisz;
    private String wpiszString;
    private int i;
    private List<UserData> nowyUser;

    UserFactory() {
        wpisz = new Scanner(System.in);
    }

    private void dodajDaneGlowne(){
        i++;
        setImie(wpisz.nextLine());
        setNazwisko(wpisz.nextLine());
        setNip(wpisz.nextInt());
    }

    public void wyswietlDaneGlowne(){
    }

    private void dodajDaneDodatkowe(){
        setNazwaCzesci(wpisz.nextLine());
        setNazwaUslugi(wpisz.nextLine());
        setKwota1(wpisz.nextDouble());
    }

    public void createUser(){
        UserData userdata = new UserData();
        dodajDaneGlowne();
        dodajDaneDodatkowe();
        nowyUser.add(userdata);

    }

    public void dodajDoListy(){

    }



}

package com.company;

import java.util.*;


public class UserRepository {

    public List<UserData> lista = new ArrayList<UserData>();
    public Scanner wpisz = new Scanner(System.in);
    public String szablonNIP = "(\\d{10})";
    public String sprawdzNIP = "";
    private boolean done = false;

    public void addUser(UserData userData) {
        lista.add(userData);
    }

    public void addUser(String Imie, String Nazwisko, String Nip) {
        UserData tmp = new UserData(Imie, Nazwisko, Nip);
        lista.add(tmp);
    }

    public void wpiszUsera() {
        done = false;
        wpisz = new Scanner(System.in);
        UserData tmp = new UserData();
        System.out.print("Podaj imie:\t");
        tmp.setImie(wpisz.nextLine());
        System.out.print("Podaj nazwisko:\t");
        tmp.setNazwisko(wpisz.nextLine());
        while (!done) {
            try {
                System.out.print("Podaj nip:\t");
                sprawdzNIP = wpisz.nextLine();
                if (sprawdzNIP.matches(szablonNIP)) {
                    tmp.setNip(sprawdzNIP);
                    addUser(tmp);
                    done = true;
                    System.out.println("\nWpisano klienta!\n\n");
                } else {
                    System.out.println("\nBłąd wprowadzania danych - wpisz same cyfry\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nBłąd wprowadzania danych - wpisz same cyfry\n\n");
            }
        }
    }

    public String displayAllUsers(int element) {
        String tmp = "";

        if (element < 0 || element > lista.size()-1)
        {
            tmp += "\nNie istnieje element o danym indeksie "+element+"\n\n";
        }
        else
        {
            tmp+= "\nKlient nr: "+(element+1)+"\n";
            tmp+= "Imie\t\t"+lista.get(element).getImie()+"\n";
            tmp+= "Nazwisko\t"+lista.get(element).getNazwisko()+"\n";
            tmp+= "Nip\t\t\t"+lista.get(element).getNip()+"\n";
        }
        return tmp;
    }

    public String displayOneUser(int element){
        String tmp = "";

        tmp+= "\nKlient nr: "+(element+1)+"\n";
        tmp+= "Imie\t\t"+lista.get(element).getImie()+"\n";
        tmp+= "Nazwisko\t"+lista.get(element).getNazwisko()+"\n";
        tmp+= "Nip\t\t\t"+lista.get(element).getNip()+"\n";
        System.out.println(tmp);
        return tmp;
    }

    public void edytujKlienta(int element){
        done = false;
        System.out.println("\nEdytowanie klienta:\n\n");
        wpisz = new Scanner(System.in);
        UserData tmp = new UserData();
        System.out.print("Podaj imie:\t");
        tmp.setImie(wpisz.nextLine());
        System.out.print("Podaj nazwisko:\t");
        tmp.setNazwisko(wpisz.nextLine());
        while (!done) {
            try {
                System.out.print("Podaj nip:\t");
                sprawdzNIP = wpisz.nextLine();
                if (sprawdzNIP.matches(szablonNIP)) {
                    tmp.setNip(sprawdzNIP);
                    addUser(tmp);
                    done = true;
                    System.out.println("\nWpisano klienta!\n\n");
                } else {
                    System.out.println("\nBłąd wprowadzania danych - wpisz same cyfry\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nBłąd wprowadzania danych - wpisz same cyfry\n\n");
            }
        }
    }

    public void usunKlienta(int element){

        if(lista.size() > 0) {
            lista.remove(element);
        }
        else{
            System.out.println("\nLista pusta\n\n");
        }
    }

}
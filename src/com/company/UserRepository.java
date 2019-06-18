package com.company;

import java.util.*;

public class UserRepository {

    public List<UserData> lista = new ArrayList<UserData>();
    public Scanner wpisz = new Scanner(System.in);


    public void addUser(UserData userData) {
        lista.add(userData);
    }

    public void addUser(String Imie, String Nazwisko, int Nip) {
        UserData tmp = new UserData(Imie, Nazwisko, Nip);
        lista.add(tmp);
    }

    public void usunUsera(){
        lista.remove(0);
    }

    public void wpiszUsera(){
        UserData tmp = new UserData();
        System.out.print("Podaj imie:\t");
        tmp.setImie(wpisz.nextLine());
        System.out.print("Podaj nazwisko:\t");
        tmp.setNazwisko(wpisz.nextLine());
        System.out.print("Podaj nip:\t");
        tmp.setNip(wpisz.nextInt());
        addUser(tmp);

    }

    public void sortuj(){
        //Collections.sort(lista);
    }

    public String displayUser(int element) {
        String tmp = "";

        if (element < 0 || element > lista.size()-1)
        {
            tmp += "Nie istnieje element o danym indeksie "+element;
        }
        else
        {
            tmp+= "Klient nr: "+(element+1)+"\n";
            tmp+= "Imie\t\t"+lista.get(element).getImie()+"\n";
            tmp+= "Nazwisko\t"+lista.get(element).getNazwisko()+"\n";
            tmp+= "Nip\t\t\t"+lista.get(element).getNip()+"\n";
        }

        return tmp;
    }
}
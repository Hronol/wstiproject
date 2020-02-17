package com.company;

import java.util.*;


public class UserRepository {

    public List<UserData> lista = new ArrayList<UserData>();
    public Scanner wpisz = new Scanner(System.in);
    public String szablonNIP = "(\\d{10})";
    public String sprawdzCyfry = "";
    public String szablonPesel = "(\\d{11})";
    private boolean done = false;

    public void addUser(UserData userData) {
        lista.add(userData);
    }

    public void addUser(String Imie, String Nazwisko, String Nip, String Pesel, String NazwaFirmy) {
        UserData tmp = new UserData(Imie, Nazwisko, Nip, Pesel, NazwaFirmy);
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
            System.out.print("Podaj nip:\t");
            sprawdzCyfry = wpisz.nextLine();
            if (sprawdzCyfry.matches(szablonNIP)) {
                tmp.setNip(sprawdzCyfry);
                done = true;
            } else {
                System.out.println("\nBłąd wprowadzania danych - wpisz same cyfry\n\n");
            }
        }
        done = false;
        while (!done){
            System.out.print("Podaj pesel:\t");
            sprawdzCyfry = wpisz.nextLine();
            if (sprawdzCyfry.matches(szablonPesel)) {
                tmp.setPesel(sprawdzCyfry);
                done = true;
            } else {
                System.out.println("\nBłąd wprowadzania danych - wpisz same cyfry\n\n");
            }
        }
        System.out.print("Podaj nazwę firmy:\t");
        tmp.setNazwaFirmy(wpisz.nextLine());
        addUser(tmp);
        System.out.println("\nWpisano klienta!\n\n");
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
            tmp+= "Imie\t\t\t\t"+lista.get(element).getImie()+"\n";
            tmp+= "Nazwisko\t\t\t"+lista.get(element).getNazwisko()+"\n";
            tmp+= "Nip\t\t\t\t"+lista.get(element).getNip()+"\n";
            tmp+= "Pesel\t\t\t"+lista.get(element).getPesel()+"\n";
            tmp+= "Nazwa firmy\t\t\t"+lista.get(element).getNazwaFirmy()+"\n";
        }
        return tmp;
    }

    public String displayOneUser(int element){
        String tmp = "";

        tmp+= "\nKlient nr: "+(element+1)+"\n";
        tmp+= "Imie\t\t\t"+lista.get(element).getImie()+"\n";
        tmp+= "Nazwisko\t\t"+lista.get(element).getNazwisko()+"\n";
        tmp+= "Nip\t\t\t\t"+lista.get(element).getNip()+"\n";
        tmp+= "Pesel\t\t\t"+lista.get(element).getPesel()+"\n";
        tmp+= "Nazwa firmy\t\t"+lista.get(element).getNazwaFirmy()+"\n";
        System.out.println(tmp);
        return tmp;
    }

    public void edytujKlienta(int element){

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
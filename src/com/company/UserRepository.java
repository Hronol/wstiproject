package com.company;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<UserData> lista = new ArrayList<UserData>();


    public void addUser(UserData userData)
    {
        lista.add(userData);
    }

    public void addUser(String Imie, String Nazwisko, int Nip)
    {
        UserData tmp = new UserData(Imie, Nazwisko, Nip);

        lista.add(tmp);
    }

    public String displayUser(int element)
    {
        String tmp = "";

        if (element < 0 || element > lista.size()-1)
        {
            tmp += "Nie istnieje element o danym indeksie "+element;
        }
        else
        {
            tmp+= "Imie\t\t"+lista.get(element).getImie()+"\n";
            tmp+= "Nazwisko\t"+lista.get(element).getNazwisko()+"\n";
            tmp+= "Nip\t\t\t"+lista.get(element).getNip()+"\n";
        }

        return tmp;
    }
}
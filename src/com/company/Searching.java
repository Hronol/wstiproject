package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Searching {
    public Scanner wpisz = new Scanner(System.in);
    UserRepository userRepository = new UserRepository();
    public String pick;

    public void wyszukajPoImieniu(List<UserData> lista){
        wpisz = new Scanner(System.in);
        pick = wpisz.nextLine();
        List<UserData> result = lista.stream()
                .filter(a -> a.getImie().toLowerCase().contains(pick))
                .collect(Collectors.toList());
        }
}

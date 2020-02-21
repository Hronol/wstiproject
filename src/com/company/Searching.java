package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Searching {
    public Scanner wpisz = new Scanner(System.in);
    int i = 0, x = 0;
    double z=0.0, y=0.0;
    public ArrayList<Integer> tabHit;
    public String pick;

    public ArrayList<Integer> wyszukajPoImieniu(List<UserData> lista) {
        tabHit = new ArrayList<>();
        System.out.print("\nWpisz część nazwy do wyszukania: ");
        wpisz = new Scanner(System.in);
        pick = wpisz.nextLine();

        List<UserData> result = lista.stream()
                .filter(a -> a.getImie().toLowerCase().contains(pick))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            while (i < result.size()) {
                x = lista.indexOf(result.get(i));
                tabHit.add(x);
                i++;
            }
        } else {
            System.out.println("\nBrak wyników wyszukiwania\n");
        }
        return (tabHit);
    }

    public ArrayList<Integer> wyszukajPoNazwisku(List<UserData> lista) {
        tabHit = new ArrayList<>();
        System.out.print("\nWpisz część nazwy do wyszukania: ");
        wpisz = new Scanner(System.in);
        pick = wpisz.nextLine();
        List<UserData> result = lista.stream()
                .filter(a -> a.getNazwisko().toLowerCase().contains(pick))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            while (i < result.size()) {
                x = lista.indexOf(result.get(i));
                tabHit.add(x);
                i++;
            }
        } else {
            System.out.println("\nBrak wyników wyszukiwania\n");
        }
        return (tabHit);
    }

    public ArrayList<Integer> wyszukajPoNipie(List<UserData> lista) {
        tabHit = new ArrayList<>();
        System.out.print("\nWpisz część nazwy do wyszukania: ");
        wpisz = new Scanner(System.in);
        pick = wpisz.nextLine();
        List<UserData> result = lista.stream()
                .filter(a -> a.getNip().toLowerCase().contains(pick))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            while (i < result.size()) {
                x = lista.indexOf(result.get(i));
                tabHit.add(x);
                i++;
            }
        } else {
            System.out.println("\nBrak wyników wyszukiwania\n");
        }
        return (tabHit);
    }

    public ArrayList<Integer> wyszukajPoUsludze(List<Orders> lista) {
        tabHit = new ArrayList<>();
        System.out.print("\nWpisz część nazwy do wyszukania: ");
        wpisz = new Scanner(System.in);
        pick = wpisz.nextLine();

        List<Orders> result = lista.stream()
                .filter(a -> a.getNazwaUslugi().toLowerCase().contains(pick))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            while (i < result.size()) {
                x = lista.indexOf(result.get(i));
                tabHit.add(x);
                i++;
            }
        } else {
            System.out.println("\nBrak wyników wyszukiwania\n");
        }
        return (tabHit);
    }

    public ArrayList<Integer> wyszukajPoKwocie(List<Orders> lista) {
        tabHit = new ArrayList<>();
        System.out.print("\nWpisz przedział kwot: \nOd: ");
        while (!wpisz.hasNextDouble()){
            System.out.println("Niepoprawna kwota - zachowaj odpowiedni format\n");
            wpisz.next();
        }
        z = wpisz.nextDouble();
        System.out.print("\nDo: ");
        while (!wpisz.hasNextDouble()){
            System.out.println("Niepoprawna kwota - zachowaj odpowiedni format\n");
            wpisz.next();
        }
        y = wpisz.nextDouble();

        List<Orders> result = lista.stream()
                .filter(a -> a.getKwota1() >= z)
                .filter(a -> a.getKwota1() <= y)
                .collect(Collectors.toList());

        if (result.size() > 0) {
            while (i < result.size()) {
                x = lista.indexOf(result.get(i));
                tabHit.add(x);
                i++;
            }
        } else {
            System.out.println("\nBrak wyników wyszukiwania\n");
        }
        return (tabHit);
    }
}



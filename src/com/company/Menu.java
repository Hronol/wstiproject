package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public boolean flag = false;
    public Scanner wpisz = new Scanner(System.in);
    public String pick, koniec;
    public int i=0, j=0, x=0;
    public ArrayList<Integer> tab = new ArrayList<Integer>();
    UserRepository user = new UserRepository();
    FileOperations plik = new FileOperations();
    Sorting sort = new Sorting();
    Searching search = new Searching();

    public void wyswietlaj() {
        for (int i = 0; i < user.lista.size(); i++)
            System.out.println(user.displayAllUsers(i));
    }

    public void menuStart() {

        String menu = "1. Zarządzaj klientami"
                + "\n2. Historia transakcji"
                + "\n3. Zapisz/wczytaj"
                + "\n4. Zakończ program"
                + "\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4") {
                flag = true;
            } else {
                switch (pick) {
                    case "1":
                        zarzadzajKlientami();
                        break;
                    case "2":

                        break;
                    case "3":
                        zapiszWczytaj();
                        break;
                    case "4": {
                        System.out.println("Czy na pewno chcesz wyjść z programu? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            System.exit(0);
                        } else
                            flag = false;
                        break;
                    }
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        } while (!flag);
    }

    public void zarzadzajKlientami() {

        String menu = "1. Dodaj"
                + "\n2. Przeglądaj/edytuj pojedynczo"
                + "\n3. Przegladaj wszystkich"
                + "\n4. Wróć"
                + "\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4") {
                flag = true;
            } else {
                switch (pick) {
                    case "1":
                        user.wpiszUsera();
                        break;
                    case "2":
                        pojedynczoKlienci();
                        break;
                    case "3":
                        wyswietlaj();
                        sortujListe();
                        break;
                    case "4":
                        menuStart();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        } while (!flag);

    }

    public void pojedynczoKlienci() {


        String menu = "1. Wyszukaj"
                + "\n2. 1 do przodu"
                + "\n3. 1 do tyłu"
                + "\n4. Edytuj"
                + "\n5. Usuń"
                + "\n6. Wróć"
                + "\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4") {
                flag = true;
            } else {
                switch (pick) {
                    case "1":
                        wyszukiwarka();
                        break;
                    case "2":
                        if (i < user.lista.size()){
                            j=i;
                            user.displayOneUser(i);
                            i++;
                        } else {
                            i = 0;
                            j=i;
                            user.displayOneUser(i);
                        }
                        break;
                    case "3":
                        if (i > 0){
                            j=i;
                            user.displayOneUser(i);
                            i--;
                        } else {
                            i = user.lista.size();
                            j=i;
                            user.displayOneUser(i);
                        }
                        break;
                    case "4":
                        user.edytujKlienta(j);
                        break;
                    case "5":
                        System.out.println("\nUWAGA! Czy napewno chcesz usunąć klienta nr: "+j+" ? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            user.usunKlienta(j);
                        } else {
                            System.out.println("\nZapis został cofnięty");
                        }
                        break;
                    case "6":
                        zarzadzajKlientami();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        } while (!flag);

    }

    public void wyszukiwarka() {


        String menu = "1. Wyszukaj po imieniu"
                + "\n2. Wyszukaj po nazwisku"
                + "\n3. Wyszukaj po nipie"
                + "\n4. Wróć"
                + "\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4") {
                flag = true;
            } else {
                switch (pick) {
                    case "1":
                        x=0;
                        tab = search.wyszukajPoImieniu(user.lista);
                        user.displayOneUser(tab.get(x));
                        while (x < tab.size()){
                            System.out.println("\n1. 1 do przodu\n2. 1 do tyłu\n3. Wróc");
                            pick = wpisz.nextLine();
                            switch (pick){
                                case "1":
                                    x++;
                                    if (x >= tab.size()){
                                        x=0;
                                        user.displayOneUser(tab.get(x));
                                    } else
                                        user.displayOneUser(tab.get(x));
                                    break;
                                case "2":
                                    x--;
                                    if (x < 0){
                                        x=tab.size()-1;
                                        user.displayOneUser(tab.get(x));
                                    } else
                                        user.displayOneUser(tab.get(x));
                                    break;
                                case "3":
                                    wyszukiwarka();
                                    break;
                            }
                        }
                        break;
                    case "2":
                        x=0;
                        tab = search.wyszukajPoNazwisku(user.lista);
                        user.displayOneUser(tab.get(x));
                        while (x < tab.size()){
                            System.out.println("\n1. 1 do przodu\n2. 1 do tyłu\n3. Wróc");
                            pick = wpisz.nextLine();
                            switch (pick){
                                case "1":
                                    x++;
                                    if (x >= tab.size()){
                                        x=0;
                                        user.displayOneUser(tab.get(x));
                                    } else
                                        user.displayOneUser(tab.get(x));
                                    break;
                                case "2":
                                    x--;
                                    if (x < 0){
                                        x=tab.size()-1;
                                        user.displayOneUser(tab.get(x));
                                    } else
                                        user.displayOneUser(tab.get(x));
                                    break;
                                case "3":
                                    wyszukiwarka();
                                    break;
                            }
                        }
                        break;
                    case "3":
                        x=0;
                        tab = search.wyszukajPoNipie(user.lista);
                        user.displayOneUser(tab.get(x));
                        while (x < tab.size()){
                            System.out.println("\n1. 1 do przodu\n2. 1 do tyłu\n3. Wróc");
                            pick = wpisz.nextLine();
                            switch (pick){
                                case "1":
                                    x++;
                                    if (x >= tab.size()){
                                        x=0;
                                        user.displayOneUser(tab.get(x));
                                    } else
                                        user.displayOneUser(tab.get(x));
                                    break;
                                case "2":
                                    x--;
                                    if (x < 0){
                                        x=tab.size()-1;
                                        user.displayOneUser(tab.get(x));
                                    } else
                                        user.displayOneUser(tab.get(x));
                                    break;
                                case "3":
                                    wyszukiwarka();
                                    break;
                            }
                        }
                        break;
                    case "4":
                        zarzadzajKlientami();
                        break;
                    default:
                        System.out.println("\nBłąd wprowadzania danych. Spróbuj ponownie.\n\n");
                        break;
                }
            }
        } while (!flag);

    }

    public void zapiszWczytaj(){

        String menu = "1. Zapisz zmiany do pliku"
                + "\n2. Exportuj plik do CSV"
                + "\n3. Wczytaj z pliku"
                + "\n4. Dodaj pusty plik"
                + "\n5. Wróć"
                + "\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4") {
                flag = true;
            } else {
                switch (pick) {
                    case "1":
                        System.out.println("\nUWAGA! Czy napewno chcesz nadpisać bazę danych? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            plik.zapiszDoPliku(user.lista);
                        } else {
                            System.out.println("\nZapis został cofnięty");
                        }
                        break;
                    case "2":
                        System.out.println("\nUWAGA! Czy napewno chcesz nadpisać plik CSV? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            plik.zapiszCSV(user.lista);
                        } else {
                            System.out.println("\nExport został cofnięty");
                        }
                        break;
                    case "3":
                        plik.wczytajZPliku(user.lista);
                        break;
                    case "4":
                        plik.tworzPlik();
                        break;
                    case "5":
                        menuStart();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;

                }
            }
        } while (!flag);
    }



    public void sortujListe() {


        String menu = "1. Sortuj po imieniu ASC"
                +"\n2. Sortuj po imieniu DSC"
                +"\n3. Sortuj po nazwisku ASC"
                +"\n4. Sortuj po nazwisku DSC"
                +"\n5. Sortuj po nipie ASC"
                +"\n6. Sortuj po nipie DSC"
                +"\n7. Sortuj po peselu ASC"
                +"\n8. Sortuj po peselu DSC"
                +"\n9. Wróć"
                +"\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4"){
                flag=true;
            }
            else {
                switch (pick) {
                    case "1":
                        sort.sortujeImieAsc(user.lista);
                        wyswietlaj();
                        break;
                    case "2":
                        sort.sortujeImieDsc(user.lista);
                        wyswietlaj();
                        break;
                    case "3":
                        sort.sortujNazwiskoAsc(user.lista);
                        wyswietlaj();
                        break;
                    case "4":
                        sort.sortujNazwiskoDsc(user.lista);
                        wyswietlaj();
                        break;
                    case "5":
                        sort.sortujNIPAsc(user.lista);
                        wyswietlaj();
                        break;
                    case "6":
                        sort.sortujNIPDsc(user.lista);
                        wyswietlaj();
                        break;
                    case "7":
                        sort.sortujPeselAsc(user.lista);
                        wyswietlaj();
                        break;
                    case "8":
                        sort.sortujPeselDsc(user.lista);
                        wyswietlaj();
                        break;
                    case "9":
                        zarzadzajKlientami();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        }while (!flag);
    }


}

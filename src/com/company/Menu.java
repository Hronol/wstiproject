package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    public boolean flag = false;
    public Scanner wpisz = new Scanner(System.in);
    public String pick, koniec;
    public int i=0;
    UserRepository user = new UserRepository();
    FileOperations plik = new FileOperations();
    Sorting sort = new Sorting();
    Searching search = new Searching();

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

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

        clearScreen();

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
                        i++;
                        if (i >= user.lista.size()){
                            System.out.println("Poza zakresem bazy");
                        } else
                            user.displayOneUser(i);
                        break;
                    case "3":
                        i--;
                        if (i < 0){
                            System.out.println("Poza zakresem bazy");
                        } else
                            user.displayOneUser(i);
                        break;
                    case "4":

                        break;
                    case "5":

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
                        search.wyszukajPoImieniu(user.lista);

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":
                        zarzadzajKlientami();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        } while (!flag);

    }

    public void zapiszWczytaj(){

        String menu = "1. Zapisz zmiany do pliku"
                + "\n2. Wczytaj z pliku"
                + "\n3. Dodaj pusty plik"
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
                        plik.zapiszDoPliku(user.lista);
                        break;
                    case "2":
                        plik.wczytajZPliku(user.lista);
                        break;
                    case "3":
                        plik.tworzPlik();
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



    public void sortujListe() {


        String menu = "1. Sortuj po imieniu ASC"
                +"\n2. Sortuj po imieniu DSC"
                +"\n3. Sortuj po nazwisku ASC"
                +"\n4. Sortuj po nazwisku DSC"
                +"\n5. Sortuj po nipie ASC"
                +"\n6. Sortuj po nipie DSC"
                +"\n7. Wróć"
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

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    case "6":

                        break;
                    case "7":
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

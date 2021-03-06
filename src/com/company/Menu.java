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
    OrdersRepository orders = new OrdersRepository();
    Sorting sort = new Sorting();
    Searching search = new Searching();

    public void wyswietlAllUsers() {
        for (int i = 0; i < user.lista.size(); i++)
            System.out.println(user.displayAllUsers(i));
    }

    public void wyswietlAllZamowienia() {
        for (int i = 0; i < orders.ordersList.size(); i++)
            System.out.println(orders.displayAllOrders(i));
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
                        historiaTransakcji();
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
                        wyswietlAllUsers();
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

        String menu = "1. Zapisz zmiany"
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
                        zapiszZmianyMenu();
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
                        wczytajZmianyMenu();
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

    public void zapiszZmianyMenu(){

        String menu = "1. Zapisz zmiany klientów"
                + "\n2 Zapisz zmiany zamówień"
                + "\n3. Zapisz wszystko"
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
                        System.out.println("\nUWAGA! Czy napewno chcesz nadpisać bazę danych? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            plik.zapiszKlientow(user.lista);
                        } else {
                            System.out.println("\nZapis został cofnięty");
                        }
                        break;
                    case "2":
                        System.out.println("\nUWAGA! Czy napewno chcesz nadpisać plik CSV? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            plik.zapiszZamowienia(orders.ordersList);
                        } else {
                            System.out.println("\nZapis został cofnięty");
                        }
                        break;
                    case "3":
                        plik.zapiszWszystko(user.lista, orders.ordersList);
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

    public void wczytajZmianyMenu(){

        String menu = "1. Wczytaj klientów"
                + "\n2 Wczytaj zamówienia"
                + "\n3. Wczytaj wszystko"
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
                        plik.wczytajKlientow(user.lista);
                        break;
                    case "2":
                        plik.wczytajZamowienia(orders.ordersList);
                        break;
                    case "3":
                        plik.wczytajWszystko(user.lista, orders.ordersList);
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
                        wyswietlAllUsers();
                        break;
                    case "2":
                        sort.sortujeImieDsc(user.lista);
                        wyswietlAllUsers();
                        break;
                    case "3":
                        sort.sortujNazwiskoAsc(user.lista);
                        wyswietlAllUsers();
                        break;
                    case "4":
                        sort.sortujNazwiskoDsc(user.lista);
                        wyswietlAllUsers();
                        break;
                    case "5":
                        sort.sortujNIPAsc(user.lista);
                        wyswietlAllUsers();
                        break;
                    case "6":
                        sort.sortujNIPDsc(user.lista);
                        wyswietlAllUsers();
                        break;
                    case "7":
                        sort.sortujPeselAsc(user.lista);
                        wyswietlAllUsers();
                        break;
                    case "8":
                        sort.sortujPeselDsc(user.lista);
                        wyswietlAllUsers();
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

    public void historiaTransakcji() {

        String menu = "1. Dodaj"
                + "\n2. Przeglądaj/edytuj pojedynczo"
                + "\n3. Przegladaj wszystkie"
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
                        orders.dodajZamowienie();
                        break;
                    case "2":
                        pojedynczoTransakcje();
                        break;
                    case "3":
                        wyswietlAllZamowienia();
                        sortujListeZamowien();
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

    public void pojedynczoTransakcje() {


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
                        wyszukiwarkaZamowien();
                        break;
                    case "2":
                        if (i < orders.ordersList.size()){
                            j=i;
                            orders.displayOneOrder(i);
                            i++;
                        } else {
                            i = 0;
                            j=i;
                            orders.displayOneOrder(i);
                        }
                        break;
                    case "3":
                        if (i > 0){
                            j=i;
                            orders.displayOneOrder(i);
                            i--;
                        } else {
                            i = orders.ordersList.size();
                            j=i;
                            orders.displayOneOrder(i);
                        }
                        break;
                    case "4":
                        orders.edytujZamowienie(j);
                        break;
                    case "5":
                        System.out.println("\nUWAGA! Czy napewno chcesz usunąć zamówienie nr: "+j+" ? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            orders.usuńZamówienie(j);
                        } else {
                            System.out.println("\nCzynnośc została cofnięta");
                        }
                        break;
                    case "6":
                        historiaTransakcji();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        } while (!flag);

    }

    public void wyszukiwarkaZamowien() {


        String menu = "1. Wyszukaj po nazwie usługi"
                + "\n2. Wyszukaj po kwocie"
                + "\n3. Wróć"
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
                        tab = search.wyszukajPoUsludze(orders.ordersList);
                        orders.displayOneOrder(tab.get(x));
                        while (x < tab.size()){
                            System.out.println("\n1. 1 do przodu\n2. 1 do tyłu\n3. Wróc");
                            pick = wpisz.nextLine();
                            switch (pick){
                                case "1":
                                    x++;
                                    if (x >= tab.size()){
                                        x=0;
                                        orders.displayOneOrder(tab.get(x));
                                    } else
                                        orders.displayOneOrder(tab.get(x));
                                    break;
                                case "2":
                                    x--;
                                    if (x < 0){
                                        x=tab.size()-1;
                                        orders.displayOneOrder(tab.get(x));
                                    } else
                                        orders.displayOneOrder(tab.get(x));
                                    break;
                                case "3":
                                    wyszukiwarkaZamowien();
                                    break;
                            }
                        }
                        break;
                    case "2":
                        x=0;
                        tab = search.wyszukajPoKwocie(orders.ordersList);
                        orders.displayOneOrder(tab.get(x));
                        while (x < tab.size()){
                            System.out.println("\n1. 1 do przodu\n2. 1 do tyłu\n3. Wróc");
                            pick = wpisz.nextLine();
                            switch (pick){
                                case "1":
                                    x++;
                                    if (x >= tab.size()){
                                        x=0;
                                        orders.displayOneOrder(tab.get(x));
                                    } else
                                        orders.displayOneOrder(tab.get(x));
                                    break;
                                case "2":
                                    x--;
                                    if (x < 0){
                                        x=tab.size()-1;
                                        orders.displayOneOrder(tab.get(x));
                                    } else
                                        orders.displayOneOrder(tab.get(x));
                                    break;
                                case "3":
                                    wyszukiwarkaZamowien();
                                    break;
                            }
                        }
                        break;
                    case "3":
                        historiaTransakcji();
                        break;
                    default:
                        System.out.println("\nBłąd wprowadzania danych. Spróbuj ponownie.\n\n");
                        break;
                }
            }
        } while (!flag);

    }

    public void sortujListeZamowien() {

        String menu = "1. Sortuj po nazwie usługi ASC"
                +"\n2. Sortuj po nazwie usługi DSC"
                +"\n3. Sortuj po kwocie ASC"
                +"\n4. Sortuj po kwocie DSC"
                +"\n5. Wróć"
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
                        sort.sortujNazweUslugiAsc(orders.ordersList);
                        wyswietlAllZamowienia();
                        break;
                    case "2":
                        sort.sortujNazweUslugiDsc(orders.ordersList);
                        wyswietlAllZamowienia();
                        break;
                    case "3":
                        sort.sortujKwotaAsc(orders.ordersList);
                        wyswietlAllZamowienia();
                        break;
                    case "4":
                        sort.sortujKwotaDsc(orders.ordersList);
                        wyswietlAllZamowienia();
                        break;
                    case "5":
                        historiaTransakcji();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        }while (!flag);
    }

}

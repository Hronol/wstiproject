package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public void sortujeImieAsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getImie));
    }

    public void sortujeImieDsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getImie).reversed());
    }

    public void sortujNazwiskoAsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNazwisko));
    }

    public void sortujNazwiskoDsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNazwisko).reversed());
    }

    public void sortujNIPAsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNip));
    }

    public void sortujNIPDsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNip).reversed());
    }

    public void sortujPeselAsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getPesel));
    }

    public void sortujPeselDsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getPesel).reversed());
    }

    public void sortujNazweUslugiAsc(List<Orders> list) {
        Collections.sort(list, Comparator.comparing(Orders::getNazwaUslugi));
    }

    public void sortujNazweUslugiDsc(List<Orders> list) {
        Collections.sort(list, Comparator.comparing(Orders::getNazwaUslugi).reversed());
    }

    public void sortujKwotaAsc(List<Orders> list) {
        Collections.sort(list, Comparator.comparing(Orders::getKwota1));
    }

    public void sortujKwotaDsc(List<Orders> list) {
        Collections.sort(list, Comparator.comparing(Orders::getKwota1).reversed());
    }

}

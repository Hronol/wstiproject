package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

 //https://stackoverflow.com/questions/18895915/how-to-sort-an-array-of-objects-in-java
    //https://www.baeldung.com/java-8-comparator-comparing
    // reverse ogarnac

    public void sortujeImieAsc(List<UserData> list) {
        Collections.sort(list);
    }

    public void sortujeImieDsc(List<UserData> list) {
       // Collections.sort(list);
        Collections.reverse(list);
    }

    public void sortujNazwiskoAsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNazwisko));
    }

    public void sortujNazwiskoDsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNazwisko));
    }

    public void sortujNIPAsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNip));
    }

    public void sortujNIPDsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getNip));
    }

    public void sortujPeselAsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getPesel));
    }

    public void sortujPeselDsc(List<UserData> list) {
        Collections.sort(list, Comparator.comparing(UserData::getPesel));
    }

}

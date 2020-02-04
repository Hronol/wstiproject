package com.company;

import java.util.Collections;
import java.util.List;

public class Sorting {

    UserRepository userRepository = new UserRepository(UserData);

    public void sortujeImieAsc(List<UserData> list){
        Collections.sort(list);
    }

    public void sortujeImieDsc(List<UserData> list){
        Collections.sort(list);
        Collections.reverse(list);
    }

    public void sortujNazwiskoAsc(List<UserData> list) {
        userRepository.
    }



}

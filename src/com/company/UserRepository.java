package com.company;

import java.util.List;

public interface UserRepository {

    UserData create(UserData userData);

    List<UserData> createList();

}

package com.company;

public class AddUser {

    private UserRepository repository;

    public AddUser(UserRepository repository){
        this.repository = repository;
    }

    public UserData create(UserData userData){
        var userToSave = UserData.builder()
                .imie(userData.getImie())
                .nazwisko(userData.getNazwisko())
                .nip(userData.getNip())
                return repository.create(userToSave);
    }
}

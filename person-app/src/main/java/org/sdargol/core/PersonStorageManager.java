package org.sdargol.core;

import org.sdargol.dto.Person;

public class PersonStorageManager {
    private final static Storage<Person> persons = Storage.create();

    public static Storage<Person> getInstance(){
        return persons;
    }
}

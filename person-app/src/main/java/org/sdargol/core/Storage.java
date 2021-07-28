package org.sdargol.core;

import org.sdargol.dto.Person;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final static List<Person> persons = new ArrayList<>();

    public static List<Person> getPersonsStorage(){
        return persons;
    }
}

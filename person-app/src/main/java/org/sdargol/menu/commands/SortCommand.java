package org.sdargol.menu.commands;

import org.sdargol.core.Storage;
import org.sdargol.dto.Person;

import java.util.Comparator;

public class SortCommand {
    public static ICommand get(){
        return () -> Storage.getPersonsStorage().sort(Comparator.comparing(Person::getLastName));
    }
}

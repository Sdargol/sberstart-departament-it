package org.sdargol.menu.commands;

import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.ICommand;

import java.util.Comparator;

public class SortCommand {
    public static ICommand<Storage<Person>> get(){
        return (src) -> src.getStorage().sort(Comparator.comparing(Person::getLastName));
    }
}

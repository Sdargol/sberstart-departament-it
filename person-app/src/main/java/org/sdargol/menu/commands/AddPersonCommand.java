package org.sdargol.menu.commands;

import org.sdargol.core.ScannerManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;

import java.util.List;
import java.util.Scanner;

public class AddPersonCommand {
    public static ICommand get(){
        return () -> {
            Scanner scanner = ScannerManager.get();
            List<Person> persons = Storage.getPersonsStorage();

            System.out.print("Enter first name: ");
            String firstName = scanner.next();
            System.out.print("Enter last name: ");
            String lastName = scanner.next();

            Person person = Person.getBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .build();

            persons.add(person);
        };
    }
}



package org.sdargol.menu.commands;

import org.sdargol.core.ScannerManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.ICommand;

import java.util.Scanner;

public class AddPersonCommand {
    public static ICommand<Storage<Person>> get(){
        return (src) -> {
            Scanner scanner = ScannerManager.get();

            System.out.print("Enter first name: ");
            String firstName = scanner.next();
            System.out.print("Enter last name: ");
            String lastName = scanner.next();

            Person person = Person.getBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .build();

            src.getStorage().add(person);
        };
    }
}



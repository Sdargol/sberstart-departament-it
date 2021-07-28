package org.sdargol.menu.commands;

import org.sdargol.core.Storage;

public class ShowCommand{
    public static ICommand get(){
        return () -> Storage.getPersonsStorage().forEach(System.out::println);
    }
}

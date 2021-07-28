package org.sdargol.menu;

import org.sdargol.menu.commands.AddPersonCommand;
import org.sdargol.menu.commands.ICommand;
import org.sdargol.menu.commands.ShowCommand;
import org.sdargol.menu.commands.SortCommand;

import java.util.HashMap;

public final class Menu {
    public final static String ADD_PERSON = "add";
    public final static String SHOW = "show";
    public final static String SORT = "sort";
    public final static String EXIT = "exit";

    private final HashMap<String, ICommand> commands = new HashMap<>();

    public Menu() {
        commands.put(ADD_PERSON, AddPersonCommand.get());
        commands.put(SHOW, ShowCommand.get());
        commands.put(SORT, SortCommand.get());
    }

    public String execute(String str){
        if(commands.containsKey(str)){
            System.out.println("команда есть");
            commands.get(str).execute();
            return "ok";
        }

        System.out.println("команды нет");
        return "not found";
    }
}

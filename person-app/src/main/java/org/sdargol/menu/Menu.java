package org.sdargol.menu;

import org.sdargol.core.PersonStorageManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.AddPersonCommand;
import org.sdargol.menu.commands.SortUniqueCommand;
import org.sdargol.menu.commands.core.ICommand;
import org.sdargol.menu.commands.ShowCommand;
import org.sdargol.menu.commands.SortCommand;
import org.sdargol.render.RenderManager;
import org.sdargol.render.RenderTaskCreator;

import java.util.HashMap;

public final class Menu {
    public final static String ADD_PERSON = "add";
    public final static String SHOW = "show";
    public final static String SORT = "sort";
    public final static String UNIQUE = "unique";
    public final static String EXIT = "exit";

    private final HashMap<String, ICommand<Storage<Person>>> commands = new HashMap<>();

    public Menu() {
        commands.put(ADD_PERSON, AddPersonCommand.get());
        commands.put(SHOW, ShowCommand.get());
        commands.put(SORT, SortCommand.get());
        commands.put(UNIQUE, SortUniqueCommand.get());
    }

    public boolean execute(String str){
        if(str.equals(EXIT)){
            return false;
        }

        if(commands.containsKey(str)){
            commands.get(str).execute(PersonStorageManager.get());
            return true;
        }

        RenderManager.getRender().offer(RenderTaskCreator.create("menu", "Command not found"));
        return true;
    }
}

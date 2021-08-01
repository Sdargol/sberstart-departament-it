package org.sdargol.menu;

import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.*;
import org.sdargol.menu.commands.core.*;
import org.sdargol.render.RenderManager;
import org.sdargol.render.RenderTaskCreator;

import java.util.HashMap;

public final class Menu {
    public final static String ADD_PERSON = "add";
    public final static String SHOW = "show";
    public final static String SORT = "sort";
    public final static String UNIQUE = "unique";
    public final static String SAVE = "save";
    public final static String READ = "read";
    public final static String EXIT = "exit";

    private final HashMap<String, ICommand<Storage<Person>>> commands = new HashMap<>();
    private final CommandsQueue commandsQueue = CommandsQueue.getInstance();
    private final MenuItemManager menuItemManager = new MenuItemManager();

    public Menu() {
        /*commands.put(ADD_PERSON, AddPersonCommand.get());
        commands.put(SHOW, ShowCommand.get());
        commands.put(SORT, SortCommand.get());
        commands.put(UNIQUE, SortUniqueCommand.get());*/

        menuItemManager.add(new MenuItem<>(ADD_PERSON, AddPersonCommand.get()));
        menuItemManager.add(new MenuItem<>(SHOW, ShowCommand.get()));
        menuItemManager.add(new MenuItem<>(SORT, SortCommand.get()));
        menuItemManager.add(new MenuItem<>(UNIQUE, SortUniqueCommand.get()));
        menuItemManager.add(new MenuItem<>(SAVE, SaveStorageCommand.get()));
        menuItemManager.add(new MenuItem<>(READ, ReadStorageFromFileCommand.get()));
    }

    public boolean execute(String str){
        if(str.contains(EXIT)){
            return false;
        }

        int numCommandsAdded = menuItemManager.addCommandsToQueue(str);

        if(numCommandsAdded == 0){
            RenderManager.getRender().offer(RenderTaskCreator.create("menu", "Command not found"));
            return true;
        }

        commandsQueue.execute();

        /*if(commands.containsKey(str)){
            commands.get(str).execute(PersonStorageManager.getInstance());
            return true;
        }*/

        return true;
    }
}

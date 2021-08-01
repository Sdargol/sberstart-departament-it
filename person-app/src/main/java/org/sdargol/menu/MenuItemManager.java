package org.sdargol.menu;

import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.CommandsQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuItemManager {
    private final List<MenuItem<Storage<Person>>> items = new ArrayList<>();
    private final CommandsQueue commandsQueue = CommandsQueue.getInstance();

    public boolean add(MenuItem<Storage<Person>> item){
        return items.add(item);
    }

    public int addCommandsToQueue(String com){
        AtomicInteger numAddCommands = new AtomicInteger();

        String[] arrCommands = com.split("\\s");

        for (String c : arrCommands) {
            for (MenuItem<Storage<Person>> item : items) {
                if(c.contains(item.getName())){
                    commandsQueue.offer(item.getCommand());
                    numAddCommands.set(numAddCommands.incrementAndGet());
                    break;
                }
            }
        }

        return numAddCommands.get();
    }
}

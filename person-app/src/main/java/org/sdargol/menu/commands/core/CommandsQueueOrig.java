package org.sdargol.menu.commands.core;

import org.sdargol.core.PersonStorageManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CommandsQueueOrig {
    private final ConcurrentLinkedQueue<ICommand<Storage<Person>>> commandsQueue;
    private final Storage<Person> storage = PersonStorageManager.getInstance();

    private final static CommandsQueueOrig COMMANDS_QUEUE = new CommandsQueueOrig();

    private CommandsQueueOrig() {
        this.commandsQueue = new ConcurrentLinkedQueue<>();
    }

    public static CommandsQueueOrig getInstance(){
        return COMMANDS_QUEUE;
    }

    @Deprecated
    public boolean offer(ICommand<Storage<Person>> command){
        return commandsQueue.offer(command);
    }

    @Deprecated
    public void execute(){
        while(!commandsQueue.isEmpty()){
            commandsQueue.poll().execute(storage);
        }
    }
}

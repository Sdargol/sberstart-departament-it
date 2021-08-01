package org.sdargol.menu.commands.core;

import org.sdargol.core.PersonStorageManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ACommandsQueue<T> {
    protected final ConcurrentLinkedQueue<ICommand<T>> commandsQueue;
    protected final Storage<Person> storage;

    protected ACommandsQueue() {
        this.commandsQueue = new ConcurrentLinkedQueue<>();
        this.storage = PersonStorageManager.getInstance();
    }

    public boolean offer(ICommand<T> command){
        return commandsQueue.offer(command);
    }

    public abstract void execute();
}

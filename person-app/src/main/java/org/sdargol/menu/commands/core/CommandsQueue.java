package org.sdargol.menu.commands.core;

import org.sdargol.core.Storage;
import org.sdargol.dto.Person;

public class CommandsQueue extends ACommandsQueue<Storage<Person>>  {
    private final static CommandsQueue COMMANDS_QUEUE = new CommandsQueue();

    public static CommandsQueue getInstance(){
        return COMMANDS_QUEUE;
    }

    @Override
    public void execute(){
        while(!commandsQueue.isEmpty()){
            commandsQueue.poll().execute(storage);
        }
    }
}

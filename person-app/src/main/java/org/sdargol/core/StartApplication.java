package org.sdargol.core;

import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.CommandsQueue;
import org.sdargol.menu.commands.core.ICommand;
import org.sdargol.render.RenderManager;
import org.sdargol.render.RenderTaskCreator;

import java.util.function.Consumer;

public class StartApplication {
    private final CommandsQueue commandsQueue = CommandsQueue.getInstance();

    public boolean init(String[] args){
        boolean b = parseArgs(args);

        if(!b){
            System.out.println("Error init");
        }

        return b;
    }

    private boolean parseArgs(String[] args){
        Consumer<String> msg = (m) -> RenderManager.getRender().offer(RenderTaskCreator.create("init", m));

        if(args.length <= 1){
            msg.accept("Args length = " + args.length);
            return true;
        }

        boolean result = false;

        if(args.length % 2 == 0){
            msg.accept("Args ok, length = " + args.length);
            for (int i = 0; i < args.length; i = i + 2) {
                Person person = new Person(args[i], args[i + 1]);
                result = commandsQueue.offer(createAddPersonCommand(person));
            }

        }

        if( (args.length >= 3) && !(args.length % 2 == 0) ){
            msg.accept("Args > 3, length = " + args.length);
            for (int i = 0; i < args.length; i = i + 2) {
                if(i + 1 >= args.length) {
                    break;
                }
                Person person = new Person(args[i], args[i + 1]);
                result = commandsQueue.offer(createAddPersonCommand(person));
            }
        }

        commandsQueue.execute();

        return result;
    }

    private ICommand<Storage<Person>> createAddPersonCommand(final Person person){
        return (src)->src.getStorage().add(person);
    }

}

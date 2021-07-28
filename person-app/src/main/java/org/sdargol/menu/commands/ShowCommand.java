package org.sdargol.menu.commands;

import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.ICommand;
import org.sdargol.render.RenderManager;

public class ShowCommand{
    public static ICommand<Storage<Person>> get(){
        return (src) -> RenderManager.getRender().offer(
                () -> src.getStorage().forEach(System.out::println)
        );
    }
}

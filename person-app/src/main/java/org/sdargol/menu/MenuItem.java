package org.sdargol.menu;

import org.sdargol.menu.commands.core.ICommand;

public class MenuItem<T> {
    private final String name;
    private final ICommand<T> command;

    public MenuItem(String name, ICommand<T> command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public ICommand<T> getCommand() {
        return command;
    }
}

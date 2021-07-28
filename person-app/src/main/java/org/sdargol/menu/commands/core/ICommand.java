package org.sdargol.menu.commands.core;

public interface ICommand<T> {
    void execute(T src);
}

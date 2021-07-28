package org.sdargol.menu.commands;

import org.sdargol.core.PersonStorageManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.ICommand;
import org.sdargol.render.RenderManager;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortUniqueCommand {
    private final static int cacheHashCode = PersonStorageManager.get().hashCode();

    public static ICommand<Storage<Person>> get(){
        return (src) -> {
            Collection<Person> persons = src.getStorage().stream()
                    .collect(Collectors.toMap(
                            Person::getLastName,
                            Function.identity(),
                            BinaryOperator.maxBy(Comparator.comparing(Person::getLastName))
                    ))
                    .values()
                    .stream()
                    .sorted(Comparator.comparing(Person::getLastName))
                    .collect(Collectors.toList());

            RenderManager.getRender()
                    .offer(
                            () -> persons.forEach(System.out::println)
                    );
        };
    }
}

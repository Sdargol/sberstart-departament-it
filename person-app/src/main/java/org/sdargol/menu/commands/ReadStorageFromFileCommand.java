package org.sdargol.menu.commands;

import org.sdargol.core.PersonStorageManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.ICommand;
import org.sdargol.render.RenderManager;
import org.sdargol.render.RenderTaskCreator;
import org.sdargol.utils.FilesUtil;
import org.sdargol.utils.exceptions.NotSupportFieldByMappingException;

import java.util.List;

public class ReadStorageFromFileCommand {
    public static String FILENAME = "db";
    public static ICommand<Storage<Person>> get(){
        return (src) -> {
            try {
                List<Person> db = FilesUtil.read(FILENAME, Person.class);
                PersonStorageManager.getInstance().setStorage(db);
            } catch (NotSupportFieldByMappingException e) {
                e.printStackTrace();
                String error = e.getMessage() +" Class: " + e.getClassName() + ", Field: " + e.getFieldName();
                RenderManager.getRender().offer(RenderTaskCreator.create("error", error));
            }
        };
    }
}

package org.sdargol.menu.commands;

import org.sdargol.core.PersonStorageManager;
import org.sdargol.core.Storage;
import org.sdargol.dto.Person;
import org.sdargol.menu.commands.core.ICommand;
import org.sdargol.render.RenderManager;
import org.sdargol.render.RenderTaskCreator;
import org.sdargol.utils.FilesUtil;
import org.sdargol.utils.exceptions.NotSupportFieldByMappingException;

public class SaveStorageCommand {
    public static String FILENAME = "db";
    public static ICommand<Storage<Person>> get(){
        return (src) -> {
            try {
                FilesUtil.write(PersonStorageManager.getInstance().getStorage(), Person.class, FILENAME);
            } catch (NotSupportFieldByMappingException e) {
                e.printStackTrace();
                String error = e.getMessage() +" Class: " + e.getClassName() + ", Field: " + e.getFieldName();
                RenderManager.getRender().offer(RenderTaskCreator.create("error", error));
            }
        };
    }
}

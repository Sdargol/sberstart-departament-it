package org.sdargol;

import org.sdargol.core.ScannerManager;
import org.sdargol.core.StartApplication;
import org.sdargol.dto.Person;
import org.sdargol.menu.Menu;
import org.sdargol.menu.commands.core.CommandsQueueOrig;
import org.sdargol.render.Render;
import org.sdargol.render.RenderManager;
import org.sdargol.utils.FilesUtil;
import org.sdargol.utils.exceptions.NotSupportFieldByMappingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        StartApplication startApplication = new StartApplication();
        Scanner scanner = ScannerManager.getInstance();
        Render render = RenderManager.getRender();
        Menu menu = new Menu();

        /*scheduled.scheduleWithFixedDelay(
                () -> r.offer(
                        () -> System.out.println("scheduled")
                ),
                100,
                150,
                TimeUnit.MILLISECONDS);*/

        startApplication.init(args);
        Render.print("system", "Person app version 0.0.1", true);
        render.start();

        boolean b;
        do {
            Render.print("system", "Enter command: ", false);
            String str = scanner.nextLine();
            b = menu.execute(str);
            render.start();
        } while (b);

        ScannerManager.close();
        //scheduled.shutdown();

    }
}

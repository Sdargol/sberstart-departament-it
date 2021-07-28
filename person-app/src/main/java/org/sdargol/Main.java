package org.sdargol;

import org.sdargol.core.ScannerManager;
import org.sdargol.menu.Menu;
import org.sdargol.render.Render;
import org.sdargol.render.RenderManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        Scanner scanner = ScannerManager.get();
        Render r = RenderManager.getRender();
        Menu menu = new Menu();

        /*scheduled.scheduleWithFixedDelay(
                () -> r.offer(
                        () -> System.out.println("scheduled")
                ),
                100,
                150,
                TimeUnit.MILLISECONDS);*/

        System.out.println("[SYSTEM]: Person app version 0.0.1");

        boolean b = true;
        do {
            System.out.print("[SYSTEM]: Enter command: ");
            String str = scanner.next();
            b = menu.execute(str);
            r.start();
        } while (b);

        ScannerManager.close();
        //scheduled.shutdown();

    }
}

package org.sdargol;

import org.sdargol.core.ScannerManager;
import org.sdargol.dto.Person;
import org.sdargol.dto.builders.PersonBuilder;
import org.sdargol.menu.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = ScannerManager.get();
        Menu menu = new Menu();

        System.out.println("[SYSTEM]: Person app version 0.0.1");

        boolean b = true;
        do {
            System.out.print("[SYSTEM]: Enter command: ");
            String str = scanner.next();
            menu.execute(str);
            b = !str.equals("exit");

        } while (b);

        ScannerManager.close();
    }
}

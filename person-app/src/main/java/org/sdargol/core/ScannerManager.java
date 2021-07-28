package org.sdargol.core;

import java.util.Scanner;

public class ScannerManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner get(){
        return scanner;
    }

    public static void close(){
        scanner.close();
    }
}

package app.view;

import app.controllers.ViewController;

import java.io.Console;
import java.util.Scanner;
import java.util.function.Supplier;

public final class View {

    public static boolean isInTerminal;
    public static final Scanner scanner;
    public static final Console console;
    private static final ViewController controller;

    static {
        scanner = new Scanner(System.in);
        console = System.console();
        isInTerminal = console != null;
        controller = new ViewController();
    }

    private View() {}

    public static void pass() {}

    public static void exit() {
        System.out.println("Saliendo...");
        scanner.close();
        System.exit(0);
    }

    public static void waitForEnter() {
        System.out.print("Presione enter para continuar...");
        scanner.nextLine();
    }

    public static void printLine(char s, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(s);
        }
        System.out.println();
    }

    public static void printLine(int len) {
        printLine('-', len);
    }

    public static void clear() {
        if (isInTerminal) {
            System.out.print("\033\143");
        } else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    public static <T> T input(Supplier<T> scan) {
        return input("", scan);
    }

    public static <T> T input(
        String question,
        Supplier<T> scan,
        String errorMsg,
        boolean flush
    ) {
        return controller.safeInput(question, scan, errorMsg, flush);
    }

    public static <T> T input(String question, Supplier<T> scan) {
        return input(question, scan, "Valor inválido", true);
    }

    public static String nextPassword() {
        if (isInTerminal) {
            return new String(console.readPassword());
        } else {
            return scanner.nextLine();
        }
    }
}

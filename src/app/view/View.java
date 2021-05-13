package app.view;

import java.io.Console;
import java.util.Scanner;
import java.util.function.Supplier;

public final class View {

    public static boolean isInTerminal;
    public static final Scanner scanner;
    public static final Console console;

    static {
        scanner = new Scanner(System.in);
        console = System.console();
        isInTerminal = console != null;
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

    /**
     * Ask a user for input and verify it's a valid one by catching the exception, if there is any.
     *
     * @param scan Scan method to ask user for input.
     * @param <T> The type of the returned and the scan method.
     * @return An object given users input for a scan method.
     */
    public static <T> T input(Supplier<T> scan) {
        return input("", scan);
    }

    /**
     * Ask a user for input and verify it's a valid one by catching the exception, if there is any.
     *
     * @param question A String to print as a question.
     * @param scan Scan method to ask user for input.
     * @param errorMsg A String for error message to show in case of an Exception.
     * @param flush A boolean for flushing or not after asking the data for keyboard.
     * @param <T> The type of the returned and the scan method.
     * @return An object given users input for a scan method.
     */
    public static <T> T input(
        String question,
        Supplier<T> scan,
        String errorMsg,
        boolean flush
    ) {
        boolean hasError;
        T data = null;
        do {
            try {
                System.out.print(question);
                data = scan.get();
                hasError = false;
            } catch (Exception exception) {
                System.out.println(Color.RED + errorMsg + Color.NORMAL);
                hasError = true;
            }
            if (flush) {
                View.scanner.nextLine();
            }
        } while (hasError);

        return data;
    }

    /**
     * Ask a user for input and verify it's a valid one by catching the exception, if there is any.
     *
     * @param question A String to print as a question.
     * @param scan Scan method to ask user for input.
     * @param <T> The type of the returned and the scan method.
     * @return An object given users input for a scan method.
     */
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

package app.controllers;

import java.util.Scanner;
import java.util.function.Supplier;

public class ViewController {

    private final Scanner scanner;

    public ViewController() {
        this.scanner = new Scanner(System.in);
    }

    public <T> T saveInput(
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
                System.out.println(errorMsg);
                if (flush) {
                    scanner.nextLine();
                }
                hasError = true;
            }
        } while (hasError);

        return data;
    }
}

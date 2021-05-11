package app.controllers;

import app.views.View;
import java.util.function.Supplier;

public class ViewController {

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
                hasError = true;
            }
            if (flush) {
                View.scanner.nextLine();
            }
        } while (hasError);

        return data;
    }
}

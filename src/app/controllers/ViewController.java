package app.controllers;

import app.views.Color;
import app.views.View;
import java.util.function.Supplier;

public class ViewController {

    /**
     *
     * @param question
     * @param scan
     * @param errorMsg
     * @param flush
     * @param <T>
     * @return
     */
    public <T> T safeInput(
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
}

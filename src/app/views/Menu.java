package app.views;

import java.util.*;
import lombok.Getter;

public class Menu {

    private final String title;
    private final Map<String, Runnable> options;
    private final Scanner scanner;

    @Getter
    private final List<String> optionKeys;

    private final Box box;

    public Menu(String title, Map<String, Runnable> options) {
        this.title = title;
        this.options = options;
        this.scanner = new Scanner(System.in);
        this.optionKeys = new ArrayList<>(options.keySet());
        this.box = new Box();
    }

    public Menu(Map<String, Runnable> options) {
        this("Menu", options);
    }

    public void display() {
        showTitle();
        box.in(optionKeys);
        menuInput();
    }

    public void showTitle() {
        int menuWidth = (box.longestString(optionKeys) + 8);
        int space = (menuWidth - title.length()) / 2;
        space = Math.max(space, 0);
        String titleSpace = new String(new char[space]).replace("\0", " ");
        System.out.printf("%s%s\n\n", titleSpace, title);
    }

    public void menuInput() {
        boolean hasException;
        int choice = 0;

        do {
            try {
                System.out.print("\nEscoja una opcion: ");
                choice = scanner.nextInt();
                if (choice > options.size() - 2 || choice < 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                hasException = false;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.printf(
                    "Se requiere valor entero, entre 0 - %d.\n",
                    options.size() - 2
                );
                scanner.nextLine();
                hasException = true;
            }
        } while (hasException);

        executeOption(choice);
    }

    private void executeOption(int choice) {
        int index = ((choice != 0) ? choice : optionKeys.size()) - 1;
        String key = optionKeys.get(index);
        options.get(key).run();
    }
}

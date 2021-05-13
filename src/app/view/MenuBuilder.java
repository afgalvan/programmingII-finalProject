package app.view;

import lombok.Getter;

import java.util.*;

public class MenuBuilder {

    private final String title;
    private final Map<String, Runnable> options;
    private final Scanner scanner;

    @Getter
    private final List<String> optionKeys;

    private final Box box;

    /**
     * API for create simple terminal based menus.
     *
     * @param title A String of the the menu title.
     * @param options The map with the key-value menu option.
     */
    public MenuBuilder(String title, Map<String, Runnable> options) {
        this.title = title;
        this.options = options;
        this.scanner = new Scanner(System.in);
        this.optionKeys = new ArrayList<>(options.keySet());
        this.box = new Box();
    }

    public MenuBuilder(Map<String, Runnable> options) {
        this("Menu", options);
    }

    /**
     * Show the whole menu in the terminal or console.
     */
    public void display() {
        showTitle();
        box.in(optionKeys);
        menuInput();
    }

    /**
     * Display the title centered with the menu as reference.
     */
    public void showTitle() {
        int menuWidth = (box.longestString(optionKeys) + 8);
        int space = (menuWidth - title.length()) / 2;
        space = Math.max(space, 0);
        String titleSpace = new String(new char[space]).replace("\0", " ");
        System.out.printf("%s%S%s%s\n\n", Color.WHITE, titleSpace, Color.NORMAL, title);
    }

    /**
     * Receive by keyboard the choice of the user for the current menu.
     */
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
                    Color.RED +
                    "Se requiere valor entero, entre 0 - %d.\n" +
                    Color.NORMAL,
                    options.size() - 2
                );
                scanner.nextLine();
                hasException = true;
            }
        } while (hasException);

        executeOption(choice);
    }

    /**
     * Execute the choice of the menu by using his index to access to the map value runnable.
     * @param choice integer of the choice in the menu.
     */
    private void executeOption(int choice) {
        int index = ((choice != 0) ? choice : optionKeys.size()) - 1;
        String key = optionKeys.get(index);
        options.get(key).run();
    }
}

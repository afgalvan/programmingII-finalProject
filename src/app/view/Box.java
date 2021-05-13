package app.view;

import app.controllers.TableController;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;

@Getter
public class Box {

    private int width;

    public int longestString(List<String> list) {
        return list.stream().max(Comparator.comparing(String::length)).get().length();
    }

    public void horizontalRule(int lineLen) {
        System.out.print("+");
        String line = new String(new char[lineLen]).replace('\0', '-');
        System.out.print(line);
        System.out.println("+");
    }

    private void displaySpace(int spaceBetween) {
        String space = TableController.voidSpaceOf(spaceBetween);
        System.out.print(space);
        System.out.println(" |");
    }

    protected void in(List<String> elements) {
        width = longestString(elements);

        horizontalRule(width + 6);

        AtomicInteger index = new AtomicInteger(1);
        elements.forEach(
            element -> {
                String elementIndex = index.getAndIncrement() + ".";

                if (
                    element.equals("Salir") ||
                    element.equals("Volver") ||
                    element.equals("Cerrar Sesion")
                ) {
                    elementIndex = "0.";
                } else if (element.isEmpty()) {
                    elementIndex = " ";
                }

                System.out.printf("| %3s %s", elementIndex, element);
                int spaceBetween = width - element.length();
                displaySpace(spaceBetween);
            }
        );

        horizontalRule(width + 6);
    }
}

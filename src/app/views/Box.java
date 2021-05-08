package app.views;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;

@Getter
public class Box {

    private int width;

    public int longestString(List<String> list) {
        return list
            .stream()
            .max(Comparator.comparing(String::length))
            .get()
            .length();
    }

    private void horizontalRule(int lineLen) {
        System.out.print("+");
        String line = new String(new char[lineLen + 6]).replace('\0', '-');
        System.out.print(line);
        System.out.println("+");
    }

    private void displaySpace(int spaceBetween) {
        String space = new String(new char[spaceBetween]).replace("\0", " ");
        System.out.print(space);
        System.out.println(" |");
    }

    protected void in(List<String> elements) {
        width = longestString(elements);

        horizontalRule(width);

        AtomicInteger index = new AtomicInteger(1);
        elements.forEach(
            element -> {
                String elementIndex = index.getAndIncrement() + ".";

                if (element.equals("Salir") || element.equals("Volver")) {
                    elementIndex = "0.";
                } else if (element.isEmpty()) {
                    elementIndex = " ";
                }

                System.out.printf("| %3s %s", elementIndex, element);
                int spaceBetween = width - element.length();
                displaySpace(spaceBetween);
            }
        );

        horizontalRule(width);
    }
}

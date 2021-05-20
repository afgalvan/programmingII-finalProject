package app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 */
public class TableController {

    private static final TableController instance = new TableController();

    private TableController() {}

    public static TableController getInstance() {
        return instance;
    }

    /**
     *
     * @param columnWidths
     * @return
     */
    public int computeTableWidth(List<Integer> columnWidths) {
        int divisorsCount = 3;
        int firstDivisor = 1;

        // prettier-ignore-start
        return (columnWidths.stream().mapToInt(e -> e).sum()
            + divisorsCount * columnWidths.size()) - firstDivisor;
        // prettier-ignore-end
    }

    /**
     *
     * @param list
     * @return
     */
    public int length(List<String> list) {
        // prettier-ignore-start
        return list.stream()
            .map(s -> " | ".length() + s.length())
            .collect(Collectors.toList())
            .stream()
            .mapToInt(r -> r)
            .sum() - 1;
        // prettier-ignore-end
    }

    /**
     *
     * @param table
     * @return
     */
    public List<Integer> computeColumnsWidth(List<List<String>> table) {
        AtomicInteger max = new AtomicInteger();
        List<Integer> widthsArray = new ArrayList<>();

        for (int i = 0; i < table.get(0).size(); i++) {
            int rowIndex = i;
            max.set(0);
            table.forEach(
                row -> {
                    int wordLen = row.get(rowIndex).length();
                    if (wordLen > max.get()) {
                        max.set(wordLen);
                    }
                }
            );

            widthsArray.add(max.intValue());
        }

        return widthsArray;
    }

    /**
     *
     * @param spaceWidth
     * @return
     */
    public static String voidSpaceOf(int spaceWidth) {
        return new String(new char[spaceWidth]).replace('\0', ' ');
    }
}

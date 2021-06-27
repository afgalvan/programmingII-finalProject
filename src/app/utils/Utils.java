package app.utils;

public final class Utils {

    private Utils() {}

    public static boolean containsIgnoreCase(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }
}

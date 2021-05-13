package app.view;

public enum Color {
    RED("\033[1;31m"),
    GREEN("\033[1;32m"),
    YELLOW("\033[1;33m"),
    BLUE("\033[1;34m"),
    PURPLE("\033[1;35m"),
    WHITE("\033[1;97m"),
    NORMAL("\033[0m");

    private final String color;

    /**
     * Color enum for showing on console apps.
     *
     * @param _color the color to show.
     */
    Color(String _color) {
        this.color = _color;
    }

    /**
     * Get the color per se.
     *
     * @return A {@code String} with the ANSI code color.
     */
    @Override
    public String toString() {
        return color;
    }
}

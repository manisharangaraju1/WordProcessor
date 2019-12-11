import java.awt.*;

public class Run {
    private int startIndex;
    private int endIndex;
    private Font font;

    public Run(int startIndex, int endIndex, Font font) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.font = font;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public Font getFont() {
        return font;
    }

    public String toString() {
        return this.startIndex + " " + this.endIndex;
    }
}

import java.awt.*;

public class Unicode extends CharacterFlyweight {
    private final char unicode;

    public Unicode(char unicode) {
        this.unicode = unicode;
    }

    @Override
    public String setFont(Font font) {
        return font.toString();
    }
}

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private static FontFactory fontFactory;

    private Map<String, Font> fontMap;

    private FontFactory() {
        fontMap = new HashMap<>();
    }

    public Font getFont(String fontName, int fontStyle, int fontSize) {
        if (!fontMap.containsKey(fontName + fontStyle + fontSize)) {
            fontMap.put(fontName + fontStyle + fontSize, new Font(fontName, fontStyle, fontSize));
        }
        return fontMap.get(fontName + fontStyle + fontSize);
    }

    public static FontFactory getFontFactoryInstance() {
        if (fontFactory == null) {
            fontFactory = new FontFactory();
        }
        return fontFactory;
    }
}

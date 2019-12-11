import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FontFactoryTest {
    FontFactory fontFactory = FontFactory.getFontFactoryInstance();

    @Test
    void getFont() {
        Font font = fontFactory.getFont("TIMES NEW ROMAN" , Font.ITALIC , 10);
        Font fontTest = fontFactory.getFont("TIMES NEW ROMAN" , Font.ITALIC , 10);
        assertTrue(font == fontTest);
    }

    @Test
    void getFontFactoryInstance() {
        FontFactory fontFactoryTest = FontFactory.getFontFactoryInstance();
        assertTrue(fontFactoryTest == fontFactory);
    }

}
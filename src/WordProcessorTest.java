import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

class WordProcessorTest {
    @Test
    public void parseTextTest() {
        double memory = new SizeofUtil(){
            @Override
            protected int create() {
                WordProcessor wordProcessor = new WordProcessor();
                RunArray runArray = new RunArray();
                FontFactory aFontFactory = FontFactory.getFontFactoryInstance();

                Font fontOne = aFontFactory.getFont("TIMES NEW ROMAN",Font.ITALIC,10);
                RunArray aRun = new RunArray();
                aRun.addRun(0,14,fontOne);
                wordProcessor.parseText("ABCdvf ABCDABC", runArray);

                return 1;
            }
        }.averageBytes();

        double memoryWithoutFlyweight = new SizeofUtil(){
            @Override
            protected int create() {
                WordProcessor wordProcessor = new WordProcessor();
                String testNonFlyweightString = "ABCdvf ABCDABC";
                List<Font> fonts = new ArrayList<>();
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));
                fonts.add(new Font("TIMES NEW ROMAN", Font.ITALIC, 10));

                wordProcessor.parseNonFlyweightText(testNonFlyweightString, fonts);
                return 1;
            }
        }.averageBytes();
        assertTrue(memoryWithoutFlyweight > memory);
    }
}
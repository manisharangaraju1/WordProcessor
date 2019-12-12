import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

class MemoryTest {
    @Test
    void testMemoryConsumption() {
        double memory = new SizeofUtil(){
            @Override
            protected int create() {
                CharacterFactory characterFactory = CharacterFactory.getTextCharacterFactoryInstance();
                FontFactory aFontFactory = FontFactory.getFontFactoryInstance();
                Font fontOne = aFontFactory.getFont("TIMES NEW ROMAN",Font.ITALIC,10);
                RunArray runArray = new RunArray();
                runArray.addRun(0,14,fontOne);
                String text = "ABCdvf ABCDABC";

                for(int textIndex=0;textIndex<text.length();textIndex++){
                    characterFactory.saveChar(text.charAt(textIndex));
                }
                return 1;
            }
        }.averageBytes();

        double memoryWithoutFlyweight = new SizeofUtil(){
            @Override
            protected int create() {
                String testNonFlyweightString = "ABCdvf ABCDABC";
                List<Font> fonts = new ArrayList<>();
                List<NonFlyweightUnicode> characterArray = new ArrayList<>();
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

                for (int index=0;index<testNonFlyweightString.length();index++) {
                    characterArray.add(new NonFlyweightUnicode(testNonFlyweightString.charAt(index), fonts.get(index)));
                }
                return 1;
            }
        }.averageBytes();
        System.out.println("Flyweight : " + memory);
        System.out.println("Non-Flyweight : " + memoryWithoutFlyweight);
        assertTrue(memoryWithoutFlyweight > memory);
    }
}
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
                WordProcessor wordProcessor = new WordProcessor(CharacterFactory.getTextCharacterFactoryInstance());
                RunArray runArray = new RunArray();
                Font fontOne = FontFactory.getFontFactoryInstance().getFont("TIMES NEW ROMAN", Font.ITALIC, 10);
                runArray.addRun(0, 3, fontOne);
                runArray.appendRun(11, fontOne);
                wordProcessor.parseText("ABC ABCDABCABC", runArray);
                return 1;
            }
        }.averageBytes();

        double memoryWithoutFlyweight = new SizeofUtil(){
            @Override
            protected int create() {
                List<NonFlyweightUnicode> characterArray = new ArrayList<>();
                String text = "ABC ABCDABCABC";
                for (char c : text.toCharArray()) {
                    Font fontOne = FontFactory.getFontFactoryInstance().getFont("TIMES NEW ROMAN", Font.ITALIC, 10);
                    characterArray.add(new NonFlyweightUnicode(c, fontOne));
                }
                return 1;
            }
        }.averageBytes();

        assertTrue(memoryWithoutFlyweight < memory);
    }


}
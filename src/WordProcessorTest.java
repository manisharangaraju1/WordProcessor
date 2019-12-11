import org.junit.jupiter.api.Test;

import java.awt.*;

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
                Font fontTwo = FontFactory.getFontFactoryInstance().getFont("ARIAL", Font.BOLD, 12);
                runArray.addRun(0, 3, fontOne);
                runArray.addRun(4, 5, fontTwo);
                runArray.appendRun(11, fontOne);
                wordProcessor.parseText("ABC ABCDABCABC", runArray);
                return 1;
            }
        }.averageBytes();
        assertTrue(memory == 1668.0);
    }


}
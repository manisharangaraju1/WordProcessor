import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WordProcessor {

    private  CharacterFactory characterFactory;

    public WordProcessor(CharacterFactory characterFactory) {
        this.characterFactory = characterFactory;
    }

    public void parseText(String text, RunArray runArray) {
        for(int textIndex=0;textIndex<text.length();textIndex++){
            Unicode unicode = characterFactory.getChar(text.charAt(textIndex));
            Font textFont = runArray.getFont(textIndex);
            unicode.setFont(textFont);
        }
    }

    public static void main(String[] args) {
        double memory = new SizeofUtil(){
            @Override
            protected int create() {
                FontFactory fontFactory = FontFactory.getFontFactoryInstance();
                WordProcessor wordProcessor = new WordProcessor(CharacterFactory.getTextCharacterFactoryInstance());
                RunArray runArray = new RunArray();
                Font fontOne = fontFactory.getFont("TIMES NEW ROMAN", Font.ITALIC, 10);
                runArray.addRun(0, 14, fontOne);
                wordProcessor.parseText("ABC ABCDABCABC", runArray);
                return 1;
            }
        }.averageBytes();
        System.out.println("With flyweight : " + memory);

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
        System.out.println("memoryWithoutFlyweight : " + memoryWithoutFlyweight);
    }
}

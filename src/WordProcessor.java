import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WordProcessor {

    private  CharacterFactory characterFactory;

    public WordProcessor() {
        this.characterFactory = CharacterFactory.getTextCharacterFactoryInstance();
    }

    public void parseText(String text, RunArray runArray) {
        for(int textIndex=0;textIndex<text.length();textIndex++){
            characterFactory.saveChar(text.charAt(textIndex));
        }
    }

    public void parseNonFlyweightText(String text, List<Font> fonts) {
        List<NonFlyweightUnicode> characterArray = new ArrayList<>();
        for (int index=0;index<text.length();index++)
            characterArray.add(new NonFlyweightUnicode(text.charAt(index), fonts.get(index)));
    }
}

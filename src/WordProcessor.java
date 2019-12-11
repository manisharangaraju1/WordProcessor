import java.awt.*;

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
}

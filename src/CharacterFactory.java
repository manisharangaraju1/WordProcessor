import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private  Map<Character, Unicode> characterUnicodeMap = new HashMap<>();
    private static CharacterFactory characterFactory;

    private CharacterFactory() {
    }

    public Unicode getChar(Character character){
        if(!characterUnicodeMap.containsKey(character)) {
            characterUnicodeMap.put(character,  new Unicode(character));
        }
        return characterUnicodeMap.get(character);
    }

    public static CharacterFactory getTextCharacterFactoryInstance() {
        if(characterFactory == null) {
            characterFactory = new CharacterFactory();
        }
        return characterFactory;
    }
}

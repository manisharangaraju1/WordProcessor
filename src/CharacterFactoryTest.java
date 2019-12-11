import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class CharacterFactoryTest {
    CharacterFactory characterFactory = CharacterFactory.getTextCharacterFactoryInstance();

    @Test
    void getChar() {
        String testCharacterFactoryString = "ABC ABCD";
        for (char c : testCharacterFactoryString.toCharArray()) {
            characterFactory.saveChar(c);
        }
        assertTrue(characterFactory.saveChar(testCharacterFactoryString.charAt(0)) ==
                characterFactory.saveChar(testCharacterFactoryString.charAt(4)));
    }

    @Test
    void testTextCharacterFactoryInstance() {
        CharacterFactory characterFactoryTest = CharacterFactory.getTextCharacterFactoryInstance();
        assertTrue(characterFactoryTest == characterFactory);
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class CharacterFactoryTest {
    CharacterFactory characterFactory = CharacterFactory.getTextCharacterFactoryInstance();

    @Test
    void getChar() {
        String testCharacterFactoryString = "ABC ABCD";
        for (char c : testCharacterFactoryString.toCharArray()) {
            characterFactory.getChar(c);
        }
        assertTrue(characterFactory.getChar(testCharacterFactoryString.charAt(0)) ==
                characterFactory.getChar(testCharacterFactoryString.charAt(4)));
    }

    @Test
    void testTextCharacterFactoryInstance() {
        CharacterFactory characterFactoryTest = CharacterFactory.getTextCharacterFactoryInstance();
        assertTrue(characterFactoryTest == characterFactory);
    }
}
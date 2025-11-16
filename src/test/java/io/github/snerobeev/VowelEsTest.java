package io.github.snerobeev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VowelEsTest {
    VowelEs vowelEs = new VowelEs();

    @DisplayName("Invalid Vowels Es")
    @ParameterizedTest
    @ValueSource(
        chars = {'a', 'A', 'á', 'e', 'E', 'é', 'i', 'I', 'í', 'o', 'O', 'ó', 'u', 'U', 'ú', 'ü'})
    void testInvalidVowelEs(char vowel) {

        assertTrue(vowelEs.isVowel(vowel));
    }

    @DisplayName("Invalid Consonants Es")
    @ParameterizedTest
    @ValueSource(
        chars = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'})
    void testInvalidConsonantEs(char consonant) {

        assertFalse(vowelEs.isVowel(consonant));
    }

    @DisplayName("Invalid Symbols")
    @ParameterizedTest
    @ValueSource(
        chars = {
            ' ', '.', ',', ';', ':', '?', '!', '—', '-', '(', ')', '[', ']', '{', '}', '<', '>',
            '/', '|', '@', '#', '$', '%', '^', '&', '*', '+', '=', '~', '`', '_'
        })
    void testInvalidSymbolRu(char symbol) {

        assertFalse(vowelEs.isVowel(symbol));
    }

    @DisplayName("Checking Sentence Positive ES")
    @Test
    void testWithSentencePositiveEs() {
        var es = VowelFactory.getVowelChecker("es");
        String wordEs = "Que tengas suerte en el examen.";
        boolean[] expected =
            {
                false, true, true, false, false, true, false, false, true, false, false,
                false, true, true, false, false, true, false, true, false, false, true, false, false,
                true, false, true, false, true, false, false
            };

        int i = 0;

        for (char ch : wordEs.toCharArray()) {
            boolean actual = es.isVowel(ch);

            Assertions.assertEquals(expected[i], actual);
            i++;
        }
    }

    @DisplayName("Mix char RU ES HU positive test")
    @ParameterizedTest
    @ValueSource(
        strings = {"Он aquí ö>"})
    void testMixCharRuEsHuPositive(String sentence) {
        var es = VowelFactory.getVowelChecker("es");
        boolean[] expected = {false, false, false, true, false, true, true, false, false, false};
        int i = 0;

        for (char ch : sentence.toCharArray()) {
            boolean actual = es.isVowel(ch);

            Assertions.assertEquals(expected[i], actual);
            i++;
        }
    }

}

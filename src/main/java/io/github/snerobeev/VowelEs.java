package io.github.snerobeev;

import java.util.Set;

/**
 * @author Alexandra Yaitskaya
 * @version 1.0.1
 * @see VowelCheckable
 * @since 2025-11-11
 */

public class VowelEs implements VowelCheckable {
    public static final Set<Character> VOWELS = Set.of('a', 'A', 'á', 'e', 'E', 'é', 'i', 'I', 'í', 'o', 'O', 'ó', 'u', 'U', 'ú', 'ü');

    @Override
    public boolean isVowel(char ch) {
        return VOWELS.contains(ch);
    }

}
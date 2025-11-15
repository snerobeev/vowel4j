package io.github.snerobeev;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sergei Nerobeev
 * @version 1.0.1
 * @see VowelCheckable
 * @since 2025-09-15
 * A factory class for creating {@link VowelCheckable} instances based on a specified language.
 * <p>
 * This class provides a static method to obtain a vowel checking service for various
 * supported languages, ensuring that the provided language code is a valid ISO language.
 * The factory simplifies the creation of language-specific logic by hiding the
 * implementation details.
 */
public class VowelFactory {
  /**
   * A set of all ISO-639-1 language codes supported by Java.
   * This is used to validate the input language format.
   */
  private static final Set<String> SUPPORTED_LANGUAGES = Arrays
      .stream(Locale.getISOLanguages())
      .collect(Collectors.toUnmodifiableSet());

  /**
   * Validates if a given language code is a valid ISO language format.
   *
   * @param lang The language code to validate.
   * @return {@code true} if the language is a valid ISO language, {@code false} otherwise.
   */
  private static boolean isValidLanguage(String lang) {
    return lang != null && SUPPORTED_LANGUAGES.contains(lang);
  }

  /**
   * Returns a {@link VowelCheckable} instance for the specified language.
   * <p>
   * This method supports a limited set of languages (e.g., Russian, English, Hungarian, Spanish).
   * If an unsupported language is requested, an exception is thrown with a link to
   * the GitHub repository where new languages can be contributed.
   *
   * @param language The ISO language code (e.g., "ru", "en", "hu", "es").
   * @return A concrete implementation of {@link VowelCheckable} for the given language.
   * @throws IllegalArgumentException if the language format is invalid or if the language
   *                                  is not currently supported by the factory.
   * @see <a href="https://github.com/Sergei-Nerobeev/vowel4j">GitHub Repository</a>
   */
  public static VowelCheckable getVowelChecker(String language) {
    if (!isValidLanguage(language)) {
      throw new IllegalArgumentException(
          "Unsupported format: " + language + ". Supported ISO languages format: " + SUPPORTED_LANGUAGES);
    }

    return switch (language) {
      case "ru" -> new VowelRu();
      case "en" -> new VowelEn();
      case "hu" -> new VowelHu();
      case "es" -> new VowelEs();
      default -> throw new IllegalArgumentException("Unsupported language.You can add your language here: " +
                                                        "https://github.com/Sergei-Nerobeev/vowel4j");
    };
  }
}



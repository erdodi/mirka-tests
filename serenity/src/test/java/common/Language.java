package common;

/** Created by milos.lukac on 12/1/2016. */
public enum Language {
  ENGLISH("English"),
  DEUTSCH("Deutsch");

  private final String language;

  Language(final String language) {
    this.language = language;
  }

  @Override
  public String toString() {
    return language;
  }
}

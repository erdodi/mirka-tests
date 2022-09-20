package common;

@SuppressWarnings("unused")
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

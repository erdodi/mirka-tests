package user.input.tutorial;

public class tutorialEnumeratory {
  enum Farby {
    CERVENA,
    ZELENA,
    CIERNA,
    MODRA,
    ZLTA
  };

  public static void main(String[] args) {
    Farby farbicka = Farby.CIERNA;
    if (farbicka == Farby.ZELENA) System.out.println("Mam rada zelenu farbu.");
  }
}

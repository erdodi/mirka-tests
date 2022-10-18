package user.input.tutorial;

public class tutorialRekurzia {

  public static void main(String[] args) {
    System.out.println(faktorialSlucka(6));
    System.out.println(faktorialRekurzie(6));
  }

  public static int faktorialSlucka(int cislo) {
    for (int s = cislo - 1; s > 0; s--) {
      cislo *= s;
    }
    return cislo;
  }

  public static int faktorialRekurzie(int cislo) {
    if (cislo == 1) return 1;

    return cislo * faktorialRekurzie(cislo - 1);
  }
}

package user.input.tutorial;

public class tutorialPole {

  public static void main(String[] args) {
    int[] cisla = new int[4];
    cisla[0] = 0;
    cisla[1] = 2;
    cisla[2] = 4;
    cisla[3] = 6;
    pole(cisla);
  }

  public static void pole(int[] celeCisla) {
    for (int m = 0; m < celeCisla.length; m++) {
      celeCisla[m] += 5;
      System.out.println(celeCisla[m]);
    }
  }
}

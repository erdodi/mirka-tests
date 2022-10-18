package user.input.tutorial;

import java.util.Random;

public class TutorialPoleMethod {

  public static void main(String[] args) {

    int[] cisla = new int[1];
    // cisla[0] = 0;
    cisla = pole(cisla);
    System.out.println((cisla[0]));
  }

  public static int[] pole(int[] celeCisla) {
    Random rd = new Random(20);
    int[] novePole = celeCisla;
    for (int m = 0; m < novePole.length; m++) {
      novePole[m] = rd.nextInt();
    }
    return novePole;
  }
}

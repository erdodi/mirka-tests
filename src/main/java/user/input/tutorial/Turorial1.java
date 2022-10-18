package user.input.tutorial;

import java.util.Scanner;

public class Turorial1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Zadajte meno: ");
    String meno;
    meno = in.nextLine();
    System.out.println("Zadajte vek: ");
    String vek;
    vek = in.nextLine();
    pozdrav(meno, vek);
    System.out.println(scitaj(20, 30));
    System.exit(0);
  }

  public static void pozdrav(String arg, String vek) {
    System.out.println("Ahoj " + arg + " (" + vek + ") !");
  }

  public static int scitaj(int arg1, int arg2) {
    int temp = arg1 + arg2;
    return temp;
  }
}

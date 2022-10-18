package kalkulacka;

import java.util.Scanner;

public class kalkulacka {

  static boolean ukoncit = false;
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    while (!ukoncit) {
      ukazMenu();
    }
    System.out.println("Program Kalkulacka sa ukoncuje.");
  }

  public static void ukazMenu() {
    System.out.print("1) Scitat\n2) Odcitat\n0) Ukoncit\nZadajte vasu volbu: ");
    switch (in.nextInt()) {
      case 1:
        scitaj();
        break;
      case 2:
        odcitaj();
        break;
      case 0:
        ukoncit = true;
        break;
      default:
        ukazMenu("Neplatna volba! Zadajte znovu. ");
    }
  }

  public static void ukazMenu(String sprava) {
    System.out.println(sprava);
    ukazMenu();
  }

  public static void scitaj() {
    System.out.print("Zadajte prvy scitanec: ");
    int prvy = in.nextInt();
    System.out.print("Zadajte druhy scitanec: ");
    int druhy = in.nextInt();
    System.out.println("Vysledok je: " + (prvy + druhy) + "\n\n");
  }

  public static void odcitaj() {
    System.out.print("Zadajte mensenec: ");
    int mensenec = in.nextInt();
    System.out.print("Zadajte mensitel: ");
    int mensitel = in.nextInt();
    System.out.println("Vysledok je: " + (mensenec - mensitel) + "\n\n");
  }
}

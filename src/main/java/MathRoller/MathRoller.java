package MathRoller;

import java.util.Random;
import java.util.Scanner;

public class MathRoller {

  public static void main(String[] args) {

    // TODO KE:
    //  pridat dalsi vstupny parameter pre urcenie maximalneho suctu
    final Scanner in = new Scanner(System.in);
    // final Random rd = new Random(20);

    System.out.println("How many examples should I generate? ");
    int count;
    count = in.nextInt();

    generujZoznamPrikladov(count);
  }

  public static void generujZoznamPrikladov(int count) {

    final Random rd = new Random(20);
    final String[] prikladyZiak = new String[count];
    // pole kde ukladam string zoznam prikladov pre ziaka
    // pole stringov s nazvom prikladyZiak dlzky count ktoru zadame na vstupe zo scaneru
    final String[] prikladyUcitel = new String[count];
    // pole kde ukladam zoznam prikladov pre ucitela cize je to pole prikladyZiak + vysledok

    for (int i = 0; i < count; i++) {
      int firstNumber = rd.nextInt(20);
      int secondNumber = (rd.nextInt(20 - firstNumber));
      int sucet = firstNumber + secondNumber;
      prikladyZiak[i] = firstNumber + " + " + secondNumber + " = ?";
      prikladyUcitel[i] = firstNumber + " + " + secondNumber + " = " + sucet;
    }

    // TODO KE:
    //  prerobit s pouzitim List-u
    //  BONUS: vypis nie pouzitim for-u, ale Java 8 forEach a lambdy :-)
    //  NAPOVEDA: ziskaj zavolanim metody Napoveda.dajNapovedu()
    System.out.println("Príklady pre žiaka: ");
    for (int j = 0; j < count; j++) {
      int poradie = j + 1;
      System.out.println("%s. %s ".formatted(poradie, prikladyZiak[j]));
    }

    System.out.println("\n" + "Príklady pre ucitela: ");
    for (int k = 0; k < count; k++) {
      int poradie = k + 1;
      System.out.println("%s. %s ".formatted(poradie, prikladyUcitel[k]));
    }
  }
}

package MathRoller;

import entities.Napoveda;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MathRollerList {

  public static void main(String[] args) {

    // TODO KE:
    //  pridat dalsi vstupny parameter pre urcenie maximalneho suctu
    final Scanner in = new Scanner(System.in);
    // final Random rd = new Random(20);

    System.out.println("How many examples should I generate? ");
    int count;
    count = in.nextInt();

    System.out.println("Enter the maximum amount: ");
    int maxSum;
    maxSum = in.nextInt();

    generujZoznamPrikladov(count, maxSum);
    Napoveda.dajNapovedu();
  }

  public static void generujZoznamPrikladov(int count, int maxSum) {

    final Random rd = new Random(maxSum);
    final ArrayList<String> prikladyZiak = new ArrayList<String>();
    // objekt List kde ukladam string zoznam prikladov pre ziaka
    // List stringov s nazvom prikladyZiak dlzky count ktoru zadame na vstupe zo scaneru
    final ArrayList<String> prikladyUcitel = new ArrayList<String>();
    // objekt List kde ukladam zoznam prikladov pre ucitela cize je to pole prikladyZiak + vysledok

    for (int i = 0; i < count; i++) {
      int firstNumber = rd.nextInt(maxSum + 1);
      int secondNumber = (rd.nextInt(maxSum + 1 - firstNumber));
      int sucet = firstNumber + secondNumber;
      prikladyZiak.add(i + 1 + ". " + firstNumber + " + " + secondNumber + " = ?");
      prikladyUcitel.add(i + 1 + ". " + firstNumber + " + " + secondNumber + " = " + sucet);
    }

    // TODO KE:
    //  prerobit s pouzitim List-u
    //  BONUS: vypis nie pouzitim for-u, ale Java 8 forEach a lambdy :-)
    //  NAPOVEDA: ziskaj zavolanim metody Napoveda.dajNapovedu()
    System.out.println("Príklady pre žiaka: ");
    prikladyZiak.forEach(System.out::println);

    System.out.println("\n" + "Príklady pre ucitela: ");
    prikladyUcitel.forEach(System.out::println);
  }
}

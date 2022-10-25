package MathRoller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MathRollerList {

  public static void main(String[] args) {

    final Scanner in = new Scanner(System.in);
    // final Random rd = new Random(20);

    System.out.println("Generator prikladov na scitanie a odcitanie do XXX");

    System.out.println("Zadajte hodnotu XXX: ");
    int maxSum;
    maxSum = in.nextInt();

    System.out.println("How many examples should I generate? ");
    int count;
    count = in.nextInt();

    generujZoznamPrikladov(count, maxSum);
  }

  public static void generujZoznamPrikladov(int count, int maxSum) {

    final Random rd = new Random(maxSum);
    final ArrayList<String> prikladyZiak = new ArrayList<String>();
    // objekt List kde ukladam string zoznam prikladov pre ziaka
    // List stringov s nazvom prikladyZiak dlzky count ktoru zadame na vstupe zo scaneru
    final ArrayList<String> prikladyUcitel = new ArrayList<String>();
    // objekt List kde ukladam zoznam prikladov pre ucitela cize je to pole prikladyZiak + vysledok

    for (int i = 0; i < count; i++) {
      int znamienko = rd.nextInt(2);
      int firstNumber = rd.nextInt(maxSum + 1);
      int secondNumber = (rd.nextInt(maxSum + 1 - firstNumber));

      if (znamienko == 0) {
        int sucet = genZoznPriklScit(firstNumber, secondNumber);
        prikladyZiak.add(i + 1 + ". " + firstNumber + " + " + secondNumber + " = ?");
        prikladyUcitel.add(i + 1 + ". " + firstNumber + " + " + secondNumber + " = " + sucet);
      } else {
        if (firstNumber > secondNumber) {
          int rozdiel = genZoznRozdiel(firstNumber, secondNumber);
          prikladyZiak.add(i + 1 + ". " + firstNumber + " - " + secondNumber + " = ?");
          prikladyUcitel.add(i + 1 + ". " + firstNumber + " - " + secondNumber + " = " + rozdiel);
        }
      }
    }

    System.out.println("Príklady pre žiaka: ");
    prikladyZiak.forEach(System.out::println);

    System.out.println("\n" + "Príklady pre ucitela: ");
    prikladyUcitel.forEach(System.out::println);
  }

  public static int genZoznPriklScit(int firstNumber, int secondNumber) {
    int sucet = firstNumber + secondNumber;
    return sucet;
  }

  public static int genZoznRozdiel(int firstNumber, int secondNumber) {
    int rozdiel = firstNumber - secondNumber;
    return rozdiel;
  }
}

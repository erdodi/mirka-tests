package MathRoller;

import java.util.Random;
import java.util.Scanner;

public class MathRoller {

  public static void main(String[] args) {

    final Scanner in = new Scanner(System.in);
    final Random rd = new Random(20);

    System.out.println("How many examples should I generate? ");
    int count;
    count = in.nextInt();

    int randomNumber1;
    randomNumber1 = rd.nextInt(20);

    int randomNumber2;
    randomNumber2 = (rd.nextInt(20)) - randomNumber1;

    // System.out.println(count);
    // System.out.println(randomNumber1);
    // System.out.println(randomNumber2);
    // System.out.println(randomNumber1 + " + " + randomNumber2 + " = ");

    generujZoznam(count, randomNumber1, randomNumber2);
  }

  public static void generujZoznam(int count, int firstNumber, int secondNumber) {
    for (int i = 0; i < count; i++) {
      System.out.println((i + 1) + ". " + firstNumber + " + " + secondNumber + " = ");
    }
  }
}

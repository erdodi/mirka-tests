package MathRollerOop;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MatPrikladClass {

  public static void main(String[] args) {

    final Scanner in = new Scanner(System.in);
    // final Random rd = new Random(20);

    System.out.println("Addition and subtraction examples to ?");

    System.out.println("Enter a value to: ");
    int maxSum;
    maxSum = in.nextInt();

    System.out.println("How many examples should I generate? ");
    int count;
    count = in.nextInt();

    generujZoznamPrikladov(count, maxSum);
  }

  public static void generujZoznamPrikladov(int count, int maxSum) {

    final Random rd = new Random();

    final List<MatPrikladRecord> priklady = new ArrayList<>();
    // objekt List kde ukladam record prikladov
    // List recordov s nazvom priklady dlzky count ktoru zadame na vstupe zo scaneru

    for (int i = 0; i < count; i++) {

      int znamienko = rd.nextInt(2);

      if (znamienko == 0) {
        MatPrikladRecord priklad = genZoznPriklScit(i, maxSum);
        priklady.add(priklad);

      } else {
        MatPrikladRecord priklad = genZoznRozdiel(i, maxSum);
        priklady.add(priklad);
      }
    }
    System.out.println("Priklady pre žiaka: ");
    // priklady.forEach(priklad -> System.out.println(priklad.prikladPreZiaka()));
    for (MatPrikladRecord priklad : priklady) {
      System.out.println(priklad.prikladPreZiaka());
    }

    System.out.println("\n" + "Príklady pre ucitela: ");
    for (MatPrikladRecord priklad : priklady) {
      System.out.println(priklad.prikladPreUcitela());
    }
  }

  public static MatPrikladRecord genZoznPriklScit(int index, int maxSum) {
    int firstNumber = nextInt(0, maxSum + 1);
    int secondNumber = nextInt(0, maxSum + 1 - firstNumber);
    return new MatPrikladRecord(index + 1, Operation.PLUS, firstNumber, secondNumber);
  }

  public static MatPrikladRecord genZoznRozdiel(int index, int maxSum) {
    int firstNumber = nextInt(0, maxSum + 1);
    int secondNumber = nextInt(0, firstNumber + 1);
    return new MatPrikladRecord(index + 1, Operation.MINUS, firstNumber, secondNumber);
  }
}

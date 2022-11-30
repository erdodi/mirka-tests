package GeometricShapes;

import java.util.Scanner;

public class GeometricShapes {

  static boolean finish = false;
  static Scanner in = new Scanner(System.in);

  // opytat sa na final a static rozdiel

  public static void main(String[] args) {
    while (!finish) {
      showMenu();
    }
  }

  public static void showMenu() {
    System.out.print(
        "1) SQUARE\n2) RECTANGLE\n3) CIRCLE\n4) TRIANGLE\n\n0) Finish\n\nEnter your choice: ");
    switch (in.nextInt()) {
      case 1:
        shapeSquare();
        break;
      case 2:
        shapeRectangle();
        break;
      case 3:
        shapeCircle();
        break;
      case 4:
        shapeTriangle();
        break;
      case 0:
        finish = true;
        break;
        // zatial nemam osetrene ak pouzivatel zada ine cislo nez mam v zozname
    }
  }

  public static Square shapeSquare() {
    System.out.print("Enter length of the side a: ");
    int sideA = in.nextInt();
    String nameOfShape = "SQUARE";
    int content = sideA * sideA;
    int circumference = 4 * sideA;
    return new Square(nameOfShape, sideA, content, circumference);
    // System.out.println(Square.protocolSquare();

    // for (Square square : priklady) {
    //  System.out.println(square.protocolSquare());
    // }

  }

  public static Rectangle shapeRectangle() {
    System.out.print("Enter length of the side a: ");
    int sideA = in.nextInt();
    System.out.print("Enter length of the side b: ");
    int sideB = in.nextInt();
    String nameOfShape = "RECTANGLE";
    int content = sideA * sideB;
    int circumference = 2 * (sideA + sideB);
    return new Rectangle(nameOfShape, sideA, sideB, content, circumference);
  }

  public static void shapeCircle() {}

  public static void shapeTriangle() {}
}

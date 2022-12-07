package GeometricShapes;

import java.util.Scanner;

public class GeometricShapes {

  static boolean finish = false;
  static final Scanner in = new Scanner(System.in);
  // opytat sa na final a static rozdiel

  public static void main(String[] args) {
    while (!finish) {
      showMainMenu();
    }
  }

  public static void showMainMenu() {
    System.out.print(
        "1) SQUARE\n2) RECTANGLE\n3) CIRCLE\n4) TRIANGLE\n\n0) Finish\n\nEnter your choice: ");
    switch (in.nextInt()) {
      case 1:
        shapeSquare();
        showMenuContinue();
        break;
      case 2:
        shapeRectangle();
        showMenuContinue();
        break;
      case 3:
        shapeCircle();
        showMenuContinue();
        break;
      case 4:
        shapeTriangle();
        showMenuContinue();
        break;
      case 0:
        finish = true;
        break;
        // zatial nemam osetrene ak pouzivatel zada ine cislo nez mam v zozname
    }
  }

  public static void showMenuContinue() {
    System.out.println("Do you want to continue? Y/N");
    switch (in.next()) {
      case "Y":
        showMainMenu();
        break;
      case "N":
        finish = true;
        break;
        // zatial nemam osetrene ak pouzivatel zada ine cislo nez mam v zozname
    }
  }

  public static void shapeSquare() {
    System.out.print("Enter length of the side a: ");
    int sideA = in.nextInt();
    String nameOfShape = "SQUARE";
    // instancia noveho objektu Square
    Square squareI = new Square(nameOfShape, sideA);
    System.out.println(squareI.protocolSquare());
  }

  public static void shapeRectangle() {
    System.out.print("Enter length of the side a: ");
    int sideA = in.nextInt();
    System.out.print("Enter length of the side b: ");
    int sideB = in.nextInt();
    String nameOfShape = "RECTANGLE";
    // instancia noveho objektu Rectangle
    Rectangle rectangleI = new Rectangle(nameOfShape, sideA, sideB);
    System.out.println(rectangleI.protocolRectangle());
  }

  public static void shapeCircle() {
    System.out.print("Enter radius r: ");
    int radiusR = in.nextInt();
    String nameOfShape = "CIRCLE";
    // instancia noveho objektu Circle
    Circle CircleI = new Circle(nameOfShape, radiusR);
    System.out.println(CircleI.protocolCircle());
  }

  public static void shapeTriangle() {}
}

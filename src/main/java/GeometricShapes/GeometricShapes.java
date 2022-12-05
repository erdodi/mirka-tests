package GeometricShapes;

import java.util.Scanner;

public class GeometricShapes {

  static boolean finish = false;
  static final Scanner in = new Scanner(System.in);

  // opytat sa na final a static rozdiel

  public static void main(String[] args) {
    while (!finish) {
      showMenu();
    }
    // System.out.println();
  }

  // System.out.println(Square.protocolSquare();

  // for (Square square : priklady) {
  //  System.out.println(square.protocolSquare());
  // }

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
    // System.out.println("************END OF PROTOCOL**********************");
  }

  public static Square shapeSquare() {
    System.out.print("Enter length of the side a: ");

    int sideA = in.nextInt();
    String nameOfShape = "SQUARE";
    Square squareI = new Square(nameOfShape, sideA);
    // inicializacia nove objektu record - square
    System.out.println(squareI.protocolSquare(sideA));
    // System.out.println("********NICE PROTOCOL OF GEOMETRIC SHAPES********");

    return new Square(nameOfShape, sideA);
  }

  public static Rectangle shapeRectangle() {
    System.out.print("Enter length of the side a: ");
    int sideA = in.nextInt();
    System.out.print("Enter length of the side b: ");
    int sideB = in.nextInt();
    String nameOfShape = "RECTANGLE";
    Rectangle rectangleI = new Rectangle(nameOfShape, sideA, sideB);
    // inicializacia nove objektu record - Rectangle
    System.out.println(rectangleI.protocolRectangle(sideA, sideB));

    return new Rectangle(nameOfShape, sideA, sideB);
  }

  public static Circle shapeCircle() {
    System.out.print("Enter radius r: ");
    int radiusR = in.nextInt();
    String nameOfShape = "CIRCLE";
    // System.out.println("********NICE PROTOCOL OF GEOMETRIC SHAPES********");

    Circle CircleI = new Circle(nameOfShape, radiusR);
    // inicializacia nove objektu record - Circle
    System.out.println(CircleI.protocolCircle(radiusR));

    return new Circle(nameOfShape, radiusR);
  }

  public static void shapeTriangle() {}
}

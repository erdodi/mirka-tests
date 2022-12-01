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
    System.out.println(
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
    System.out.println("************END OF PROTOCOL**********************");
  }

  public static Square shapeSquare() {
    System.out.print("Enter length of the side a: ");
    int sideA = in.nextInt();
    String nameOfShape = "SQUARE";
    int content = sideA * sideA;
    int circumference = 4 * sideA;
    System.out.println("********NICE PROTOCOL OF GEOMETRIC SHAPES********");
    System.out.print(
        "Name od shape: %s \nLength of the side a: %s \nContent(a*a): %s \nCircumference(4*a): %s \n"
            .formatted(nameOfShape, sideA, content, circumference));
    // shapeSquare().protocolSquare();
    return new Square(nameOfShape, sideA, content, circumference);
  }

  public static Rectangle shapeRectangle() {
    System.out.print("Enter length of the side a: ");
    int sideA = in.nextInt();
    System.out.print("Enter length of the side b: ");
    int sideB = in.nextInt();
    String nameOfShape = "RECTANGLE";
    int content = sideA * sideB;
    int circumference = 2 * (sideA + sideB);
    System.out.println("********NICE PROTOCOL OF GEOMETRIC SHAPES********");
    System.out.print(
        "Name od shape: %s \nLength of the side a: %s \nLength of the side b: %s \nContent: %s \nCircumference: %s \n"
            .formatted(nameOfShape, sideA, sideB, content, circumference));
    return new Rectangle(nameOfShape, sideA, sideB, content, circumference);
  }

  public static Circle shapeCircle() {
    System.out.print("Enter radius r: ");
    int radiusR = in.nextInt();
    String nameOfShape = "CIRCLE";
    double content = Math.PI * radiusR;
    double circumference = 2 * Math.PI * radiusR;
    System.out.println("********NICE PROTOCOL OF GEOMETRIC SHAPES********");
    System.out.print(
        "Name od shape: %s \nLength of radius r: %s \nContent: %02d \nCircumference: %02d \n"
            .formatted(nameOfShape, radiusR, content, circumference));
    // shapeSquare().protocolSquare();
    return new Circle(nameOfShape, radiusR, content, circumference);
  }

  public static void shapeTriangle() {}
}

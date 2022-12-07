package GeometricShapes;

public record Triangle(String nameOfShape, int sideA, int sideB, int sideC, int highA) {

  public String protocolTriangle() {
    double content = sideA / 2 * highA;
    int circumference = sideA + sideB + sideC;
    return "\n********NICE PROTOCOL OF GEOMETRIC SHAPES******** \nName od shape: %s \nLength of the side a: %s \nLength of the side b: %s \nLength of the side c: %s \nLength of high to the side a: %s \nContent: %.02f \nCircumference: %s \n************END OF PROTOCOL**********************\n"
        .formatted(nameOfShape, sideA, sideB, sideC, highA, content, circumference);
  }
}

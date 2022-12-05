package GeometricShapes;

public record Rectangle(String nameOfShape, int sideA, int sideB) {
  public String protocolRectangle(int sideA, int sideB) {

    int content = sideA * sideB;
    int circumference = 2 * (sideA + sideB);
    return "Name od shape: %s \nLength of the side a: %s \nLength of the side b: %s \nContent: %s \nCircumference: %s \n"
        .formatted(nameOfShape, sideA, sideB, content, circumference);
  }
}

package GeometricShapes;

public record Rectangle(String nameOfShape, int sideA, int sideB) {
  public String protocolRectangle() {

    int content = sideA * sideB;
    int circumference = 2 * (sideA + sideB);
    double diagonal = Math.pow(((sideA * sideA) + (sideB * sideB)), (1.0 / 2.0));
    return "\n********NICE PROTOCOL OF GEOMETRIC SHAPES******** \nName od shape: %s \nLength of the side a: %s \nLength of the side b: %s \nContent: %s \nCircumference: %s \nDiagonal: %.02f \n************END OF PROTOCOL**********************\n"
        .formatted(nameOfShape, sideA, sideB, content, circumference, diagonal);
  }
}

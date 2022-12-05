package GeometricShapes;

public record Circle(String nameOfShape, int radius) {
  public String protocolCircle(int radiusR) {

    double content = Math.PI * radiusR;
    double circumference = 2 * Math.PI * radiusR;
    return "Name od shape: %s \nLength of radius r: %s \nContent: %.02f \nCircumference: %.02f \n"
        .formatted(nameOfShape, radiusR, content, circumference);
  }
}

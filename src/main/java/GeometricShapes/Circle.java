package GeometricShapes;

public record Circle(String nameOfShape, int radiusR) {
  public String protocolCircle() {

    int diameter = radiusR * 2;
    double content = Math.PI * radiusR;
    double circumference = 2 * Math.PI * radiusR;
    return "\n********NICE PROTOCOL OF GEOMETRIC SHAPES******** \nName od shape: %s \nLength of radius r: %s \nLength of diameter d: %s \nContent: %.02f \nCircumference: %.02f \n************END OF PROTOCOL**********************\n"
        .formatted(nameOfShape, radiusR, diameter, content, circumference);
  }
}

package GeometricShapes;

// Protokol bude obsahovat pekny vypis
//        nazvu utvaru, rozmerov utvaru a dalsich hodnot, ktore mozno pre dany utvar
//        vypocitat, cize napr. plocha, objem, povrch, sucet hran, povrch stran,
//        uhlopriecky a pod.

public record Square(String nameOfShape, int sideA) {

  public String protocolSquare() {
    int content = sideA * sideA;
    int circumference = 4 * sideA;
    double diagonal = Math.pow(2 * (sideA * sideA), (1.0 / 2.0));
    return "\n********NICE PROTOCOL OF GEOMETRIC SHAPES******** \nName od shape: %s \nLength of the side a: %s \nContent(a*a): %s \nCircumference(4*a): %s \nDiagonal: %.02f \n************END OF PROTOCOL**********************\n"
        .formatted(nameOfShape, sideA, content, circumference, diagonal);
  }
}

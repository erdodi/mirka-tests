package GeometricShapes;

// Protokol bude obsahovat pekny vypis
//        nazvu utvaru, rozmerov utvaru a dalsich hodnot, ktore mozno pre dany utvar
//        vypocitat, cize napr. plocha, objem, povrch, sucet hran, povrch stran,
//        uhlopriecky a pod.

public record Square(String nameOfShape, int sideA) {

  public String protocolSquare() {

    int content = sideA * sideA;
    int circumference = 4 * sideA;
    return "Name od shape: %s \nLength of the side a: %s \nContent(a*a): %s \nCircumference(4*a): %s \n"
        .formatted(nameOfShape, sideA, content, circumference);
  }
}

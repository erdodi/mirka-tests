package GeometricShapes;

// Protokol bude obsahovat pekny vypis
//        nazvu utvaru, rozmerov utvaru a dalsich hodnot, ktore mozno pre dany utvar
//        vypocitat, cize napr. plocha, objem, povrch, sucet hran, povrch stran,
//        uhlopriecky a pod.

public record Square(String nameOfShape, int sideA, int content, int circumference) {

  public String protocolSquare() {
    return "%s %s %s %s ".formatted(nameOfShape, sideA, content, circumference);
  }
}

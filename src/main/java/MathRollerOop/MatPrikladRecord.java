package MathRollerOop;

public record MatPrikladRecord(int order, Operation operation, int firstNumber, int secondNumber) {

  public String prikladPreZiaka() {
    String znamienko;
    if (operation == Operation.PLUS) {
      znamienko = "+";
    } else {
      znamienko = "-";
    }
    return "%s. %s %s %s = ?".formatted(order, firstNumber, znamienko, secondNumber);
  }

  public String prikladPreUcitela() {
    String znamienko;
    int result;
    if (operation == Operation.PLUS) {
      znamienko = "+";
      result = firstNumber + secondNumber;
    } else {
      znamienko = "-";
      result = firstNumber - secondNumber;
    }
    return "%s. %s %s %s = %s".formatted(order, firstNumber, znamienko, secondNumber, result);
  }
}

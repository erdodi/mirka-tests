package MathRollerOop;

public record MatPrikladRecord(
    int order,
    Operation operation,
    Operation operationSec,
    int firstNumber,
    int secondNumber,
    int thirdNumber) {

  public String prikladPreZiaka() {
    String znamienko1;
    String znamienko2;
    if (operation == Operation.PLUS && operationSec == Operation.PLUS) {
      znamienko1 = "+";
      znamienko2 = "+";
    } else {
      if (operation == Operation.PLUS && operationSec == Operation.MINUS) {
        znamienko1 = "+";
        znamienko2 = "-";
      } else {
        if (operation == Operation.MINUS && operationSec == Operation.PLUS) {
          znamienko1 = "-";
          znamienko2 = "+";
        } else {
          znamienko1 = "-";
          znamienko2 = "-";
        }
      }
    }
    return "%s. %s %s %s %s %s = ?"
        .formatted(order, firstNumber, znamienko1, secondNumber, znamienko2, thirdNumber);
  }

  public String prikladPreUcitela() {
    String znamienko1;
    String znamienko2;
    int result;

    if (operation == Operation.PLUS && operationSec == Operation.PLUS) {
      znamienko1 = "+";
      znamienko2 = "+";
      result = firstNumber + secondNumber + thirdNumber;
    } else {
      if (operation == Operation.PLUS && operationSec == Operation.MINUS) {
        znamienko1 = "+";
        znamienko2 = "-";
        result = firstNumber + secondNumber - thirdNumber;
      } else {
        if (operation == Operation.MINUS && operationSec == Operation.PLUS) {
          znamienko1 = "-";
          znamienko2 = "+";
          result = firstNumber - secondNumber + thirdNumber;
        } else {
          znamienko1 = "-";
          znamienko2 = "-";
          result = firstNumber - secondNumber - thirdNumber;
        }
      }
    }
    return "%s. %s %s %s %s %s = %s"
        .formatted(order, firstNumber, znamienko1, secondNumber, znamienko2, thirdNumber, result);
  }
}

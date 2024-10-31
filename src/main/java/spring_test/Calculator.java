package spring_test;

public class Calculator {

    public long calculate(long num1, long num2, String oper) {
        return switch (oper) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new InvalidOperatorException();
        };
    }
}

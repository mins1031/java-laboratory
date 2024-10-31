package spring_test;

import java.util.Scanner;

public class Sample {

    public static void main(String[] args) {
        CalculationRequestReader calculationRequestReader = new CalculationRequestReader();
        CalculationRequest calculationRequest = calculationRequestReader.read();

        long answer = new Calculator().calculate(
                calculationRequest.getNum1(),
                calculationRequest.getNum2(),
                calculationRequest.getOperator()
        );
        System.out.println(answer);
    }
}

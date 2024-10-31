package spring_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 덧셈_연산을_할_수_있다() {
        //given
        long num1 = 2;
        String operator = "+";
        long num2 = 3;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);


        //then
        assertEquals(5, result); // junit assertion
    }
    @Test
    void 뺄셈_연산을_할_수_있다() {
        //given
        long num1 = 2;
        String operator = "-";
        long num2 = 3;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);


        //then
        assertEquals(-1, result); // junit assertion
    }
    @Test
    void 곱셈_연산을_할_수_있다() {
        //given
        long num1 = 2;
        String operator = "*";
        long num2 = 3;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);


        //then
        assertEquals(6, result); // junit assertion
    }

    @Test
    void 나눗셈_연산을_할_수_있다() {
        //given
        long num1 = 2;
        String operator = "/";
        long num2 = 3;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);


        //then
        assertEquals(0, result); // junit assertion
    }

    @Test
    void 잘못된_연산자_요청시_에러가_난다() {
        //given
        long num1 = 2;
        String operator = "x";
        long num2 = 3;
        Calculator calculator = new Calculator();

        //when && then
        assertThrows(
                InvalidOperatorException.class,
                () -> calculator.calculate(num1, num2, operator)
        );
    }

}
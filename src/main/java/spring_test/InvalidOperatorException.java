package spring_test;

public class InvalidOperatorException extends RuntimeException{

    public InvalidOperatorException() {
        super("잘못된 연산자 입니다. 재대로된 연산자를 선택해 주세요");
    }
}

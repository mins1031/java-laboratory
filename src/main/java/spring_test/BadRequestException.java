package spring_test;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("잘못된 요청 사이즈 or 값 입니다");
    }
}

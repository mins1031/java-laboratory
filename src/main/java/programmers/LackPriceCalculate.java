package programmers;

public class LackPriceCalculate {
    private long calculatePrice(int price, int money, int count) {
        long tmp = 0;
        for (int forCount = 1; forCount < count + 1; forCount++) {
            tmp += price * forCount;
        }

        return tmp;
    }

    public long solution(int price, int money, int count) {
        long answer = calculatePrice(price, money, count);
        if (answer < money) {
            return 0;
        }
        return answer - money;
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        long solution = new LackPriceCalculate().solution(price, money, count);
        System.out.println(solution);
    }
}

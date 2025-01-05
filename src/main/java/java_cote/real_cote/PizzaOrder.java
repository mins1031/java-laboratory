package java_cote.real_cote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class PizzaOrder {
    private static class Pizza {
        public String name;
        public int price_S;
        public int price_M;
        public int price_L;

        public Pizza(String name, int price_S, int price_M, int price_L) {
            this.name = name;
            this.price_S = price_S;
            this.price_M = price_M;
            this.price_L = price_L;
        }

        public int getPrice(String size) {
            if ("Small".equals(size)) {
                return this.price_S;
            }

            if ("Medium".equals(size)) {
                return this.price_M;
            }

            return this.price_L;
        }
    }

    private static class PizzaOrderResult {
        public String name;
        public int smallCount;
        public int mediumCount;
        public int largeCount;

        public PizzaOrderResult(String name, int smallCount, int mediumCount, int largeCount) {
            this.name = name;
            this.smallCount = smallCount;
            this.mediumCount = mediumCount;
            this.largeCount = largeCount;
        }

        public void addSmallCount() {
            this.smallCount++;
        }

        public void addMediumCount() {
            this.mediumCount++;
        }

        public void addLargeCount() {
            this.largeCount++;
        }

    }

    private static class OrderItem {
        public String name;
        public String size;
        public int quantity;

        public OrderItem(String name, String size, int quantity) {
            this.name = name;
            this.size = size;
            this.quantity = quantity;
        }
    }

    public int solution(Pizza[] menu, OrderItem[] order) {
        // 이중 최솟값 구하기
        List<Integer> integers = List.of(
                firstDiscount(menu, order),
                secondDiscount(menu, order),
                thirdDiscount(menu, order),
                forthDiscount(menu, order)
        );

        int result = 0;

        for (Integer integer : integers) {
            result = Math.min(result, integer);
        }

        return result;
    }


    public int firstDiscount(Pizza[] menu, OrderItem[] order) {
        Map<String, Pizza> pizzaMap = getPizzaMap(menu);

        int totalOrderPrice = 0;
        int minPizzaPrice = Integer.MAX_VALUE;
        for (OrderItem orderItem : order) {
            Pizza pizza = pizzaMap.get(orderItem.name);
            if ("Small".equals(orderItem.size)) {
                totalOrderPrice += orderItem.quantity * pizza.price_S;
                minPizzaPrice = Math.min(minPizzaPrice, pizza.price_S);
                continue;
            }

            if ("Medium".equals(orderItem.size)) {
                totalOrderPrice += orderItem.quantity * pizza.price_M;
                minPizzaPrice = Math.min(minPizzaPrice, pizza.price_M);
                continue;
            }

            totalOrderPrice += orderItem.quantity * pizza.price_L;
            minPizzaPrice = Math.min(minPizzaPrice, pizza.price_L);
        }

        int sumQuantity = Arrays.stream(order).mapToInt(d -> d.quantity).sum();
        if (sumQuantity < 3) {
            return totalOrderPrice;
        }

        return totalOrderPrice - minPizzaPrice;
    }

    private int secondDiscount(Pizza[] menu, OrderItem[] order) {
        int totalPrice = 0;
        Map<String, Pizza> pizzaMap = getPizzaMap(menu);

        Map<String, List<Integer>> pizzaPriceListMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaPriceListMap.put(pizza.name, new ArrayList<>());
        }

        for (OrderItem orderItem : order) {
            List<Integer> priceListByPizza = pizzaPriceListMap.get(orderItem.name);
            int pizzaSizePrice = pizzaMap.get(orderItem.name)
                    .getPrice(orderItem.size);

            for (int i = 0; i < orderItem.quantity; i++) {
                priceListByPizza.add(pizzaSizePrice);
            }

            pizzaPriceListMap.put(orderItem.name, priceListByPizza);
            totalPrice += orderItem.quantity * pizzaSizePrice;
        }

        int maxDiscountResult = 0;
        for (Map.Entry<String, List<Integer>> pizzaPriceListEntry : pizzaPriceListMap.entrySet()) {
            if (pizzaPriceListEntry.getValue().size() < 5) {
                continue;
            }

            List<Integer> integers = pizzaPriceListEntry.getValue().stream().sorted(Comparator.reverseOrder()).toList();
            int sum = integers.stream().mapToInt(i -> i).sum();
            int sumAfterDiscount = 0;
            for (int i = 0; i < 5; i++) {
                sumAfterDiscount += integers.get(i);
            }
            sumAfterDiscount -= 100;

            maxDiscountResult = Math.max(maxDiscountResult, sumAfterDiscount);
        }

        System.out.println(totalPrice);
        System.out.println(maxDiscountResult);

        return totalPrice - maxDiscountResult;
    }

    private int thirdDiscount(Pizza[] menu, OrderItem[] order) {
        Map<String, PizzaOrderResult> pizzaOrderResultMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaOrderResultMap.put(
                    pizza.name,
                    new PizzaOrderResult(pizza.name, 0,0,0)
            );
        }

        for (OrderItem orderItem : order) {
            PizzaOrderResult pizzaOrderResult = pizzaOrderResultMap.get(orderItem.name);
            if ("Small".equals(orderItem.size)) {
                pizzaOrderResult.smallCount += orderItem.quantity;
                continue;
            }

            if ("Medium".equals(orderItem.size)) {
                pizzaOrderResult.mediumCount += orderItem.quantity;
                continue;
            }

            pizzaOrderResult.largeCount += orderItem.quantity;
        }

        int totalPrice = 0;
        Map<String, Pizza> pizzaMap = getPizzaMap(menu);
        for (Map.Entry<String, PizzaOrderResult> pizzaOrderResultEntry : pizzaOrderResultMap.entrySet()) {
            Pizza pizzaName = pizzaMap.get(pizzaOrderResultEntry.getKey());
            PizzaOrderResult orderResult = pizzaOrderResultEntry.getValue();
            int smallCount = orderResult.smallCount;
            int mediumCount = orderResult.mediumCount;
            int largeCount = orderResult.largeCount;

            int mediumPrice = pizzaName.price_M * mediumCount;
            int restPrice = 0;
            if (largeCount >= smallCount) {
                restPrice += pizzaName.price_L * largeCount;
            } else {
                int restCount= smallCount - largeCount;
                restPrice += pizzaName.price_L * largeCount;
                restPrice += pizzaName.price_S * restCount;
            }

            totalPrice += restPrice + mediumPrice;
        }

        return totalPrice;
    }

    private int forthDiscount(Pizza[] menu, OrderItem[] order) {
        List<Integer> pizzaPriceList = new ArrayList<>();
        for (Pizza pizza : menu) {
            pizzaPriceList.add(Math.abs(pizza.price_L - pizza.price_M));
        }
        List<Integer> reverseList = pizzaPriceList.stream().sorted(Comparator.reverseOrder()).toList();
        Map<String, Integer> pizzaMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaMap.put(pizza.name, 0);
        }

        int totalPrice = 0;
        int largeCount = 0;
        for (OrderItem orderItem : order) {
            if ("Large".equals(orderItem.size)) {
                largeCount++;
            }

            totalPrice += orderItem.quantity * pizzaMap.get(orderItem.name);
        }

        if (largeCount < 3) {
            return totalPrice;
        }

        for (Integer integer : reverseList) {

        }

        return totalPrice;
    }

    private Map<String, Pizza> getPizzaMap(Pizza[] menu) {
        Map<String, Pizza> pizzaMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaMap.put(pizza.name, pizza);
        }
        return pizzaMap;
    }



    public static void main(String[] args) {
        PizzaOrder pizzaOrder = new PizzaOrder();

        // first
//        Pizza[] menu1 = {
//                new Pizza("geek", 7, 5, 10),
//                new Pizza("texas", 8, 9, 13),
//                new Pizza("european", 5, 10, 13)
//        };
//        OrderItem[] order1 = {
//                new OrderItem("texas", "Medium", 1),
//                new OrderItem("european", "Large", 1)
//        };
//        System.out.println(pizzaOrder.firstDiscount(menu1, order1));

//        // second
//        Pizza[] menu2 = {
//                new Pizza("margherita", 90, 80, 100),
//                new Pizza("hawaii", 80, 90, 120),
//                new Pizza("capricciosa", 50, 70, 130),
//                new Pizza("greek", 50, 70, 130)
//        };
//        OrderItem[] order2 = {
//                new OrderItem("greek", "Small", 5),
//                new OrderItem("margherita", "Small", 4),
//                new OrderItem("hawaii", "Large", 1),
//                new OrderItem("margherita", "Medium", 2),
//                new OrderItem("capricciosa", "Small", 7)
//        };
//        System.out.println(pizzaOrder.secondDiscount(menu2, order2));

        // third
        Pizza[] menu3 = {
                new Pizza("margherita", 7, 8, 10),
                new Pizza("hawaii", 8, 9, 12),
                new Pizza("capricciosa", 5, 7, 13),
        };
        OrderItem[] order3 = {
                new OrderItem("margherita", "Small", 3),
                new OrderItem("capricciosa", "Large", 2),
                new OrderItem("hawaii", "Large", 3),
                new OrderItem("margherita", "Large", 1),
                new OrderItem("hawaii", "Medium", 1),
                new OrderItem("capricciosa", "Small", 5),
                new OrderItem("capricciosa", "Medium", 1)
        };
        System.out.println(pizzaOrder.thirdDiscount(menu3, order3));

    }
}

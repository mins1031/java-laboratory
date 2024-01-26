package java_lab.generic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MyParentTest {

    @Test
    void 제네릭과_와일드카드() {
        Integer[] integers = {1, 2, 3};

        //배열은 공변 개념이기 때문에 Object의 하위인 Integer도 사용가능하다
        printArrayByArray(integers);

        //Colletion은 불공변 개념이기 때문에 Object의 하위인 Integer가 사용불가능하다
//        printArrayByCollection(integers); // 컴파일 에러 발생


        Object[] objects = {new Object(), new Object()};
        printArrayByCollection(Arrays.stream(objects).collect(Collectors.toList())); // 이렇게는 가능

        printArrayByRawCollection(Arrays.stream(integers).collect(Collectors.toList()));
        List<String> strings = Arrays.asList("1", "2");
        //casting error 발생
        printArrayByRawCollection(strings);

        printArrayByGenericCollection(Arrays.stream(integers).collect(Collectors.toList()));
//        printArrayByGenericCollection(strings);// 컴파일에러
    }

    void printArrayByArray(Object[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    void printArrayByCollection(Collection<Object> arr) {
        arr.forEach(System.out::println);
    }

    //JDK 1.5 제네릭 등장전 컬렉션의 요소를 활용한 메서드 방식. -> 타입이 보장되지 않아 문제가 발생할 소지가 있다.
    void printArrayByRawCollection(Collection arr) {
        int sum = 0;
        Iterator iterator = arr.iterator();
        for (int i = 0; i < arr.size(); i++) {
            sum += (Integer) iterator.next();
        }
    }

    //제네릭을 사용해 int 외에 다른 타입의 파라미터를 제한. -> 유연성 저하로 와일드카드(?)가 도입되게 됨.
    void printArrayByGenericCollection(Collection<Integer> arr) {
        int sum = 0;
        Iterator iterator = arr.iterator();
        for (int i = 0; i < arr.size(); i++) {
            sum += (Integer) iterator.next();
        }
    }


    //상한 경계 와일드카드
    void printCollection(Collection<? extends MyParent> c) {
        // 컴파일 에러 -> 컬렉션의 타입이 MyParent로 보장된 클래스가 아니라서 하위로 변환 불가능 -> 하위 클래스는 1개이상 존재가능한데 컬렉션에서 이것들을 구분해주지 않기에 컴파일에러 발생.
//        for (MyFirstChild e : c) {
//            System.out.println(e);
//        }

        for (MyParent e : c) {
            System.out.println(e);
        }

        for (MyGrandParent e : c) {
            System.out.println(e);
        }

        for (Object e : c) {
            System.out.println(e);
        }
    }

    void addElement(Collection<? extends MyParent> c) {
//        c.add(new MyFirstChild());        // 불가능(컴파일 에러)
//        c.add(new MyParent());       // 불가능(컴파일 에러)
//        c.add(new MyGrandParent());  // 불가능(컴파일 에러)
//        c.add(new Object());         // 불가능(컴파일 에러)
    }

    //하한 경계 와일드 카드
    void addElementBySuper(Collection<? super MyParent> c) {
        c.add(new MyFirstChild());
        c.add(new MySecondChild());
        c.add(new MyParent());
//        c.add(new MyGrandParent());  // 불가능(컴파일 에러)
//        c.add(new Object());         // 불가능(컴파일 에러)
    }

    void printCollection2(Collection<? super MyParent> c) {
        // 불가능(컴파일 에러)
//        for (MyFirstChild e : c) dd{
//            System.out.println(e);
//        }

        // 불가능(컴파일 에러)
//        for (MyParent e : c) {
//            System.out.println(e);
//        }

        // 불가능(컴파일 에러)
//        for (MyGrandParent e : c) {
//            System.out.println(e);
//        }

        for (Object e : c) {
            System.out.println(e);
        }

        //Object만 가능한건 컬렉션은 MyParent지만 조회시에는 어떤 타입들인지 하나로 정의가 불가능하다 MyParent의 상위타입, 하위타입은 출력시 타입을 보장할수 없지만 object은 부모임이 명확하므로 사용가능하다고 한다. -> 햇갈림
    }


    //햇갈리지만 결국 사용시 베스트 프렉티스는 PECS이다. 결국 get의 용도와 add의 용도를 나누어서 사용해라라는 방식.
    void printOnlyCollection(Collection<? extends MyParent> c) {
        for (MyParent e : c) {
            System.out.println(e);
        }
    }

    void addOnlyElement(Collection<? super MyParent> c) {
        c.add(new MyParent());
    }
}
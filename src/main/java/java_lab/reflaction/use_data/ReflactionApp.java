package java_lab.reflaction.use_data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflactionApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("java_lab.reflaction.use_data.Book");
        Constructor<?> constructorInString = bookClass.getConstructor(String.class);
        Constructor<?> constructorInString2 = bookClass.getConstructor();
        Book myBook = (Book) constructorInString.newInstance("myBook");
        System.out.println(myBook);

        Field a = Book.class.getDeclaredField("A");
        a.setAccessible(true);
        //특정 Book클래스 인스턴스의 필드를 가져오고 싶다면 Field 의 get의 파라미터에 인스턴스를 할다하면 되지만 a는 static 변수기 때문에 굳이 인스턴스가 필요 없다.
        System.out.println(a.get(null));
        a.set(null, "AAAAAA");
        //static 변수값이 바뀜
        System.out.println(a.get(null));

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        //특정 Book클래스 인스턴스의 필드를 가져오고 싶다면 Field 의 get의 파라미터에 인스턴스를 할다하면 되지만 a는 static 변수기 때문에 굳이 인스턴스가 필요 없다.
        System.out.println(b.get(myBook));
        b.set(myBook, "BBBBB");
        //static 변수값이 바뀜
        System.out.println(b.get(myBook));

        System.out.println("Method 실습");

        Method c = Book.class.getDeclaredMethod("c");
        //private 메서드기에 setAccessible true 설정 필요.
        c.setAccessible(true);
        //필드와 동일하게 실행하려는 메서드가 특정 인스턴스의 메서드라면 인스턴스 1파라미터로, 나머지 파리미터는 실행하려는 파라미터를 할당해주면 된다.
        c.invoke(myBook);

        Method d = Book.class.getDeclaredMethod("d");
        d.invoke(myBook);

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(myBook, 1, 2);
        System.out.println(invoke);
    }
}

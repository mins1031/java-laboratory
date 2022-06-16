package reflaction;

import java.lang.reflect.Constructor;

public class ReflactionApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //리플랙션으로 클래스 정보 가져오는 2가지 방법
        Class<Book> bookClass = Book.class;
        Class<?> aClass = Class.forName("reflaction.Book");

        Constructor<Book> constructor = bookClass.getConstructor(null);
        String a = "101011";
        for (String arg : a.split("")) {
            System.out.println(arg);
        }
    }
}

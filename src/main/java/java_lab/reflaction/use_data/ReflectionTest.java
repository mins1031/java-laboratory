package java_lab.reflaction.use_data;

import java.lang.reflect.Constructor;

public class ReflectionTest {

    public int multipleIntegers() {
        int result = 0;
        for (int i = 1; i < 200000; i++) {
            result += i;
        }

        for (int i = 1; i < 300000; i++) {
            result += i;
        }

        for (int i = 1; i < 400000; i++) {
            result += i;
        }

        return result;
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Class<Book> bookClass = Book.class;
        Constructor<Book> constructor = bookClass.getConstructor();
        Book bookByReflection = constructor.newInstance();

        Book normalBook = new Book();

        long reflectionStartTime = System.nanoTime();
        bookByReflection.multipleIntegers();
        long reflectionEndTime = System.nanoTime();
        System.out.println("reflection result = " + (reflectionEndTime - reflectionStartTime));

        long normalStartTime = System.nanoTime();
        normalBook.multipleIntegers();
        long normalEndTime = System.nanoTime();
        System.out.println("normal result = " + (normalEndTime - normalStartTime));
    }
}

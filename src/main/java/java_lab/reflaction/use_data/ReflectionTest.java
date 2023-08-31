package java_lab.reflaction.use_data;

import java.lang.reflect.Constructor;

public class ReflectionTest {

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

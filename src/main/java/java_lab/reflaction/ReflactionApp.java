package java_lab.reflaction;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflactionApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //TODO 리플랙션으로 클래스 정보 가져오는 3가지 방법
        // 첫번째 : 타입으로 조회
        Class<Book> bookClass = Book.class;
        // 두번째 : 생성된 인스턴스로 조회
        Book book = new Book();
        Class<? extends Book> aClass1 = book.getClass();

        // 세번째 : Class.forName()에 패키지 경로를 파라미터로 조회
        Class<?> aClass = Class.forName("java_lab.reflaction.Book");

        //getFields는 public한 필드만 확인할수 있다.
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        System.out.println("1------------");

        //getDeclaredFields는 접근 지정자 상관없이 필드를 확인할수 있다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));

                int modifiers = f.getModifiers();
                System.out.println(Modifier.isPrivate(modifiers));
                System.out.println(Modifier.isPublic(modifiers));
                System.out.println(Modifier.isStatic(modifiers));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("2------------");

        //getMethods는 클래스의 메서드 정보를 확인할수 있다.
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        System.out.println("3------------");

        //getDeclaredConstructors는 클래스의 생성자 정보를 확인할수 있다.
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        System.out.println("------------");

        //getSuperclass는 클래스의 부모 클래스 정보를 확인할수 있다.
        System.out.println(bookClass.getSuperclass());
        System.out.println(MyBook.class.getSuperclass());
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        System.out.println("------------");

        //get 클래스의 부모 클래스 정보를 확인할수 있다.
        Arrays.stream(bookClass.getAnnotations()).forEach(System.out::println);

        System.out.println("------------");


//        Constructor<Book> constructor = bookClass.getConstructor(null);
//        String a = "101011";
//        for (String arg : a.split("")) {
//            System.out.println(arg);
//        }
    }
}

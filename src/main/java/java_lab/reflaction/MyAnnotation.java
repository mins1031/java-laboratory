package java_lab.reflaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션은 원래 컴파일되면 주석처럼 인식한다. 다만 런타임시에도 해당 어노테이션을 인식하게 하고 싶다면 아래 어노테이션인 @Retention(RetentionPolicy.RUNTIME)를 사용한다.
@Retention(RetentionPolicy.RUNTIME)
//어노테이션을 사용할수 있는 위치를 제한하는 어노테이션인 @Target 어노테이션을 설정. 아래는 필드에만 어노테이션을 선언하게 제한하는 코드이다.
@Target({ElementType.TYPE, ElementType.FIELD})
//상속이 되게 허용하는 어노테이션은 아래와 같다. @Inherited없이 MyBook의 어노테이션을 조회하면 아무것도 없음. @Inherited 설정후 조회하면 MyAnnotaion 출력.
@Inherited
public @interface MyAnnotation {
}

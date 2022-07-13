package localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LocalDateTest1 {

    public static void main(String[] args) {
        //LocalDateTime에서 max를 구하는건 더 느린 시간을 찾는 듯하다. 뭔가 int값으로 바꿨을때 빠른시간이 느린시간보다 작기에 이러한 결과가 나오는듯
        LocalDateTime localDateTime = LocalDateTime.of(2020, 3, 15, 3, 14);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 3, 16, 3, 15);
        TempClass tempClass = new TempClass(localDateTime);
        TempClass tempClass2 = new TempClass(localDateTime2);
        List<TempClass> tempClasses = Arrays.asList(tempClass2, tempClass);
        TempClass tempClass1 = tempClasses.stream().max(Comparator.comparing(TempClass::getLocalDateTime)).get();
        System.out.println(tempClass1.equals(tempClass2));
    }
}

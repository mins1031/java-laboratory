package java_lab.callbook.service;

import java_lab.equals_hashcode.BasicStudent;
import java_lab.equals_hashcode.DefinedEqualsAndHashcodeStudent;
import java_lab.equals_hashcode.equals_problum.BasicOrder;
import java_lab.equals_hashcode.equals_problum.DeliveryBasicOrder;
import java_lab.equals_hashcode.hashcode_problem.HashTeam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class EqualsAndHashCodeTest {

    @Test
    public void 기본_Eqauls_HashCode_비교() {
        //given
        BasicStudent minyoung = new BasicStudent("minyoung", 28);
        BasicStudent jungyeon = new BasicStudent("jungyeon", 28);
        BasicStudent minyoung2 = new BasicStudent("minyoung", 28);

        //when then
        System.out.println("minyoung jungyeon equals = " + minyoung.equals(jungyeon));
        System.out.println("minyoung same equals = " + minyoung.equals(minyoung));
        System.out.println("jungyeon minyoung equals = " + jungyeon.equals(minyoung));
        System.out.println("jungyeon same equals = " + jungyeon.equals(jungyeon));
        System.out.println("minyoung minyoung2 equals = " + minyoung.equals(minyoung2));
        // 타고 올라갔을때 equals는 결국 == 로 주소값으로 비교한다.

        System.out.println("minyoung hashcode = " + minyoung.hashCode());
        System.out.println("minyoung hashcode2 = " + minyoung.hashCode());
        System.out.println("jungyeon hashcode = " + jungyeon.hashCode());
        System.out.println("jungyeon hashcode2 = " + jungyeon.hashCode());
        System.out.println("minyoung2 hashcode = " + minyoung2.hashCode());
        System.out.println("minyoung2 hashcode2 = " + minyoung2.hashCode());
        //hashcode는 native 메서드라 보기가 좀 빡쌤. C언어 모름..

        Assertions.assertTrue(minyoung.equals(minyoung));
        Assertions.assertTrue(jungyeon.equals(jungyeon));
        Assertions.assertFalse(minyoung.equals(jungyeon));
        Assertions.assertFalse(jungyeon.equals(minyoung));
        Assertions.assertFalse(minyoung.equals(minyoung2));

        Assertions.assertEquals(minyoung.hashCode(), minyoung.hashCode());
        Assertions.assertNotEquals(minyoung.hashCode(), minyoung2.hashCode());
    }

    @Test
    public void 정의된_Eqauls_HashCode_비교() {
        //given
        DefinedEqualsAndHashcodeStudent minyoung = new DefinedEqualsAndHashcodeStudent("minyoung", 28);
        DefinedEqualsAndHashcodeStudent jungyeon = new DefinedEqualsAndHashcodeStudent("jungyeon", 28);
        DefinedEqualsAndHashcodeStudent minyoung2 = new DefinedEqualsAndHashcodeStudent("minyoung", 28);

        //when && then
        //equals 정의후 minyoung과 minyoung2가 동등해졌다.
        Assertions.assertTrue(minyoung.equals(minyoung2));
        Assertions.assertFalse(minyoung.equals(jungyeon));
        Assertions.assertFalse(jungyeon.equals(minyoung));

        //hashcode 정의후 minyoung과 minyoung2의 해시코드값이 동등해졌다.
        Assertions.assertEquals(minyoung.hashCode(), minyoung.hashCode());
        Assertions.assertEquals(minyoung.hashCode(), minyoung2.hashCode());
    }

    @Test
    public void 상속으로_잘못된_Equals_예시() {
        //given
        BasicOrder basicOrder = new BasicOrder("basicOrder", 10000);
        DeliveryBasicOrder deliveryBasicOrder = new DeliveryBasicOrder("basicOrder", 10000, 50);


        //when
        boolean basicOrderResult = basicOrder.equals(deliveryBasicOrder);
        boolean deliveryOrderResult = deliveryBasicOrder.equals(basicOrderResult);

        //then
        Assertions.assertTrue(basicOrderResult);
        Assertions.assertFalse(deliveryOrderResult);
    }

    @DisplayName("")
    @Test
    public void Equals만구현() {
        //given
        Map<HashTeam,String> leaders = new HashMap<>();
        String expectTeamLeader = "Anne";
        leaders.put(new HashTeam("New York", "development"), expectTeamLeader);
        leaders.put(new HashTeam("Boston", "development"), "Brian");
        leaders.put(new HashTeam("Boston", "marketing"), "Charlie");

        //when
        HashTeam myTeam = new HashTeam("New York", "development");
        String myTeamLeader = leaders.get(myTeam);

        //then
        Assertions.assertFalse(expectTeamLeader.equals(myTeamLeader));
    }
}

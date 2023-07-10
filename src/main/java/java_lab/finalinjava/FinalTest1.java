package java_lab.finalinjava;

public class FinalTest1 {

    public static void main(String[] args) {
        final int i = 5;
//        i = 4;

        int i1 = 5;
        Integer i2 = new Integer(5);

        final MemberDto memberDto = new MemberDto("id1", "name", 25);
//        memberDto = new MemberDto("id2", "name2", 29); => 안됨 새로운 객체를 할당할수 없음
        System.out.println(memberDto.toString());
        memberDto.name = "name2";
        memberDto.age = 28;
//        memberDto.id = "id2"; => 역시 예상대로 내부 필드도 final이라 변경안되고 위의 name,age는 필드가 final이 아니라서 변경가능.
        System.out.println(memberDto.toString());
    }

}

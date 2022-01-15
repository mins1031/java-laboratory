package inheritance.inheritance1;

import inheritance.inheritance1.exClass.Child;
import inheritance.inheritance1.exClass.Parent;

public class InheritanceEx1 {
    /**
     * 상속시 부모클래스를 타입으로 자식 클래스를 생성한경우 -> Parent parent = new Child() 이런 형태일때  parent의 내용 말고 child의 내용을 사용할수 있는지 없는 지 햇갈려서 구현
     * */

    public static void checkParameter(Parent parent) {
        parent.isParent();
    }

    public static void main(String[] args) {
        Parent childHaveParentType = new Child();
        Child childHaveChildType = new Child();

        childHaveChildType.isChild();
        childHaveParentType.isParent();
        //=> 부모타입으로 자식을 구현한 경우 자식의 내용을 사용 블가 -> 그러면 추상클래스는? -> 마찬가지... 다만 Child의 내용을 가지고 Parent에 할당된 내용밖에 사용하지 못한다.
        // 결국 child에서 isParent를 오버라이드 받아 사용했다면 오버라이딩 한 isParent가 실행된다.
        checkParameter(childHaveChildType);
    }
}

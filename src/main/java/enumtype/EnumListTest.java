package enumtype;

import java.util.ArrayList;
import java.util.List;

public class EnumListTest {

    public static void main(String[] args) {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ANIMATION);
        roles.add(Role.ART_DIRECTION);
        roles.add(Role.APP_DESIGN);

        roles.stream().forEach(role -> System.out.println("role: " + role.getDesc()));

    }

}

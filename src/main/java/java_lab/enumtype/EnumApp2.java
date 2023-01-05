package java_lab.enumtype;

import java.util.Arrays;

public class EnumApp2 {

    public static void main(String[] args) {
        String rawRoleName = "WEB_DESIGN";

        Role role = Role.valueOf(rawRoleName);
        System.out.println(role);
        if (role.equals(Role.WEB_DESIGN)) {
            System.out.println("같은 문자열로 enum 추출가능");
        }

        Role role2 = Arrays.stream(Role.values())
                .filter(role1 -> role1.equals(rawRoleName))
                .findAny().orElse(null);

        System.out.println(role2);

    }

}

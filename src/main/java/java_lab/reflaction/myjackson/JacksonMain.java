package java_lab.reflaction.myjackson;

import java.util.ArrayList;
import java.util.Arrays;

public class JacksonMain {

    public static void main(String[] args) throws ReflectiveOperationException {
        MyJackson myJackson = new MyJackson();
        User user = new User("min", 28.82, Arrays.asList("string1", "string2"), Arrays.asList(25.6, 3.14, 179.8));
        String serializedUserToJson = myJackson.serialize(user);
        System.out.println("serialize result = " + serializedUserToJson);

        String requestJson = "" +
                "{\n" +
                "    \"name\" : \"min\",\n" +
                "    \"age\" : 28.82,\n" +
                "    \"stringList\" : [ \n" +
                "        \"string1\",\n" +
                "        \"string2\",\n" +
                "    ], \n" +
                "    \"doubleList\" : [ \n" +
                "        25.6,\n" +
                "        3.14,\n" +
                "        179.8,\n" +
                "    ], \n" +
                "}";
        System.out.println(User.class.getName());
        User deserializeUser = (User) myJackson.deserialize(requestJson, User.class);
        System.out.println(user);
    }
}

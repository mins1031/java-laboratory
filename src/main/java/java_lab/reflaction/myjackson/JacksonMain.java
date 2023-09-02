package java_lab.reflaction.myjackson;

import java.util.ArrayList;
import java.util.Arrays;

public class JacksonMain {

    public static void main(String[] args) throws IllegalAccessException {
        MyJackson myJackson = new MyJackson();
        User user = new User("min", 28.82, Arrays.asList("string1", "string2"), Arrays.asList(25.6, 3.14, 179.8));
        String serializedUserToJson = myJackson.serialize(user);
        System.out.println(serializedUserToJson);
    }
}

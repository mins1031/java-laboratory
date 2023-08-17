package java_lab.reference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import static org.junit.jupiter.api.Assertions.*;

class ChatRoomTest {

    @DisplayName("")
    @Test
    void weakReference_list_test() throws InterruptedException {
        //given
        ChatRoom chatRoom = new ChatRoom();
        User min = new User("min");
        User yeon = new User("yeon");

        chatRoom.addUser(min);
        chatRoom.addUser(yeon);

        chatRoom.sendMessage("hello!");

        //when
//        min = null;
        System.gc();
        Thread.sleep(5000L);

        //then
        List<WeakReference<User>> users = chatRoom.getUsers();
        assertTrue(users.size() == 2);
    }

    @Test
    void WeakHashMap_Test() throws InterruptedException {
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImageFirst = new BigImage("foo");
        UniqueImageName imageNameFirst = new UniqueImageName("name_of_big_image");

        BigImage bigImageSecond = new BigImage("foo_2");
        UniqueImageName imageNameSecond = new UniqueImageName("name_of_big_image_2");

        map.put(imageNameFirst, bigImageFirst);
        map.put(imageNameSecond, bigImageSecond);

        assertTrue(map.containsKey(imageNameFirst));
        assertTrue(map.containsKey(imageNameSecond));

        imageNameFirst = null;
        System.gc();
        Thread.sleep(2000);

        Assertions.assertEquals(map.size(), 1);
        Assertions.assertFalse(map.containsKey(imageNameFirst));
        Assertions.assertTrue(map.containsKey(imageNameSecond));
    }

    @DisplayName("")
    @Test
    public void name() {
        HashMap<String, Integer> scoreCache = new HashMap<>();
        scoreCache.put("min", 90);
        scoreCache.put("yoon", 80);
        scoreCache.put("pyo", 70);

        System.out.println(scoreCache.get("min"));
        System.out.println(scoreCache.get("test"));
    }

}
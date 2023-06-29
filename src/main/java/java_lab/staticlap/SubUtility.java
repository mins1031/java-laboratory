package java_lab.staticlap;

public class SubUtility extends SuperUtility {

    public static String echoIt(String data) {
        return data;
    }

    public String echoItNotStatic(String data) {
        return "no static" + data;
    }
}

package java_lab.staticlap;

import jdk.nashorn.internal.objects.annotations.Getter;


public class Cache {

    private int viewCount;

    public Cache(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getViewCount() {
        return viewCount;
    }
}

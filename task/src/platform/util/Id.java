package platform.util;

public class Id {
    private static volatile Integer id = 0;

    public static Integer getNextId() {
        return ++id;
    }
}

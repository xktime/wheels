package SingletonPattern;

public class SingletonPatternImpl {
    private static final Object lock = new Object();//锁定对象

    private static SingletonPatternImpl singletonPattern = null;

    private SingletonPatternImpl() {
    }

    public static SingletonPatternImpl getMe() {
        if (singletonPattern == null) {
            synchronized (lock) {
                if (singletonPattern == null) {
                    singletonPattern = new SingletonPatternImpl();
                }
            }
        }
        return singletonPattern;
    }
}

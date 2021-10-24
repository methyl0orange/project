package singletonModel.hungerSingleton;

/**
 * static final 天生线程安全
 */
public class Singleton2 {
    private Singleton2(){}
    private static final Singleton2 singleton2=new Singleton2();
    public static Singleton2 getInstance(){
        return singleton2;
    }
}

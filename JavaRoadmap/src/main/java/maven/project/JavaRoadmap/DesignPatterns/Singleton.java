package maven.project.JavaRoadmap.DesignPatterns;


public class Singleton {
    private String text;
    private Singleton(String text){
        this.text=text;
    }

//  volatile keyword is used to indicate that variable's value will be
//  modified by different threads. When variable is declared volatile
//  it ensures that all threads see the most recent value written to that
//  variable
    private static volatile Singleton singleton;

    public static Singleton createSingleton(String text){
        if(singleton==null){
//            a synchronized keyword creates a synchronized block or method
//            ensuring that only one thread can execute the synchronized
//            code at any given time
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton(text);
                }
            }
        }
        return singleton;
    }

    @Override
    public String toString() {
        return "SingletonEx{" +
                "text='" + text + '\'' +
                '}';
    }
}
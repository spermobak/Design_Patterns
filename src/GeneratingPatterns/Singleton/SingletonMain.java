package GeneratingPatterns.AbstractFactory.Singleton;

/*Гарантирует что у класса будет только один экземпляр,
и предоставляет ему глобальную точку доступа*/

public class SingletonMain {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();

        singleton.name = "Semen";
        System.out.println(singleton1.name);
        singleton.name = "Ivan";
        System.out.println(singleton2.name);
    }
}

class Singleton {
    String name = null;

    static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getSingleton() {
        return singleton;
    }
}
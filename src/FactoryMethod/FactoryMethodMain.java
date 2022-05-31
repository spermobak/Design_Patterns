package FactoryMethod;

/*Определяет интерфейс для создания объекта,
 но оставляет подклассам решение о том,
 экземпляры какого класса должны создаваться*/

interface Product {
    void exist();
}

class Toy implements Product {
    public void exist() {
        System.out.println("I make you happy");
    }
}

class Gun implements Product {
    public void exist() {
        System.out.println("I make you dead");
    }
}

abstract class Creator {
    public abstract Product factoryMethod();
}

class ToyFactory extends Creator {
    @Override
    public Product factoryMethod() {
        return new Toy();
    }
}

class GunFactory extends Creator {
    @Override
    public Product factoryMethod() {
        return new Gun();
    }
}

public class FactoryMethodMain {
    public static void main(String[] args) {
        Creator[] creators = {new ToyFactory(), new GunFactory()};
        for (Creator creator : creators) {
            Product product = creator.factoryMethod();
            product.exist();
        }
    }
}
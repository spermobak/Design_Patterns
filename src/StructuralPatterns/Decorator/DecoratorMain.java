package StructuralPatterns.Decorator;

/*Динамически добавляет объекту новые обзанности*/

public class DecoratorMain {
    public static void main(String... s) {
        Decorator c = new DecoratorHello(new DecoratorComma(new DecoratorSpace(new MainComponent())));
        c.doOperation();
        c.newOperation();
    }
}
interface InterfaceComponent {
    void doOperation();
}

class MainComponent implements InterfaceComponent {

    @Override
    public void doOperation() {
        System.out.print("World!");
    }
}

abstract class Decorator implements InterfaceComponent {
    protected InterfaceComponent component;

    public Decorator (InterfaceComponent component) {
        this.component = component;
    }

    @Override
    public void doOperation() {
        component.doOperation();
    }

    public void newOperation() {
        System.out.println("Do Nothing");
    }
}

class DecoratorSpace extends Decorator {

    public DecoratorSpace(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void doOperation() {
        System.out.print(" ");
        super.doOperation();
    }

    @Override
    public void newOperation() {
        System.out.println("\nNew space operation");
    }
}

class DecoratorComma extends Decorator {

    public DecoratorComma(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void doOperation() {
        System.out.print(",");
        super.doOperation();
    }

    @Override
    public void newOperation() {
        System.out.println("\nNew comma operation");
    }
}

class DecoratorHello extends Decorator {

    public DecoratorHello(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void doOperation() {
        System.out.print("Hello");
        super.doOperation();
    }

    @Override
    public void newOperation() {
        System.out.println("\nNew hello operation");
    }
}



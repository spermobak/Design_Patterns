package StructuralPatterns.Adapter;

/*Преобрзует интерфейс одного класса в другой интерфейс*/
public class AdapterMain {

    public static void main(String[] args) {
        Chief chief = new ChiefAdapter();
        Object key = chief.makeBreakfast();
    }

}

interface Chief {

    Object makeBreakfast();

    Object makeDinner();

    Object makeSupper();

}

class Plumber {

    public Object getPipe() {
        return new Object();
    }

    public Object getKey() {
        return new Object();
    }

    public Object getScrewDriver() {
        return new Object();
    }

}


class ChiefAdapter implements Chief {

    private final Plumber plumber = new Plumber();

    @Override
    public Object makeBreakfast() {
        return plumber.getKey();
    }

    @Override
    public Object makeDinner() {
        return plumber.getScrewDriver();
    }

    @Override
    public Object makeSupper() {
        return plumber.getPipe();
    }

}


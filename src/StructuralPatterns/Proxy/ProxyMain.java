package StructuralPatterns.Proxy;

/*Является суррогатом другого объекта и контролирует доступ к нему*/

public class ProxyMain {
    public static void main(String[] args) {
        // Create math proxy
        IMath action = new MathProxy();

        // Do the math
        System.out.println("4 + 2 = " + action.add(4, 2));
        System.out.println("4 - 2 = " + action.sub(4, 2));
        System.out.println("4 * 2 = " + action.mul(4, 2));
        System.out.println("4 / 2 = " + action.div(4, 2));
    }
}
/**
 * "Subject"
 */
interface IMath {

    double add(double x, double y);

    double sub(double x, double y);

    double mul(double x, double y);

    double div(double x, double y);
}

/**
 * "Real Subject"
 */
class Math implements IMath {

    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        return x / y;
    }
}

/**
 * "Proxy Object"
 */
class MathProxy implements IMath {

    private Math math;

    public double add(double x, double y) {
        lazyInitMath();
        return math.add(x, y);
    }

    public double sub(double x, double y) {
        lazyInitMath();
        return math.sub(x, y);
    }

    public double mul(double x, double y) {
        lazyInitMath();
        return math.mul(x, y);
    }

    public double div(double x, double y) {
        lazyInitMath();
        return math.div(x, y);
    }

    private void lazyInitMath() {
        if (math == null) {
            math = new Math();
        }
    }
}
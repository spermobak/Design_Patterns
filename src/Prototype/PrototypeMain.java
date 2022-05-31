package Prototype;

/*создает клоны объекта по заданному прототипу*/

public class PrototypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        ShadowCloning shadowCloning = new ShadowCloning();
        shadowCloning.setHero(new Naruto());
        Hero hero = shadowCloning.getClone();
        hero.scream();
    }
}

class Hero implements Cloneable {

    void scream() {
    }

    @Override
    protected Hero clone() throws CloneNotSupportedException {
        return (Hero) super.clone();
    }
}

class Naruto extends Hero {
    public void scream() {
        System.out.println("NARUUUTOO");
    }
}

class ShadowCloning {
    private Hero hero;

    public Hero getClone() throws CloneNotSupportedException {
        return hero.clone();
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
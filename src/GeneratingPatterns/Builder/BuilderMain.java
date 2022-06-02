package GeneratingPatterns.Builder;

/*Отделяет конструирование объекта от его представления*/

public class BuilderMain {
    public static void main(String[] args) {
        Cake napoleon = new Cake.Builder("Napoleon").setTaste("honey").setCalories(1355).build();
        Cake anthill = new Cake.Builder("Anthill").setCalories(1248).build();
        System.out.println(napoleon.getName() + " " + napoleon.getCalories() + " " + napoleon.getTaste());
        System.out.println(anthill.getName() + " " + anthill.getCalories());

    }
}

class Cake {
    private final String name;
    private final String taste;
    private final int calories;

    //etc...

    public String getName() {
        return name;
    }

    public String getTaste() {
        return taste;
    }

    public int getCalories() {
        return calories;
    }

    private Cake(Builder builder) {
        this.name = builder.name;
        this.taste = builder.taste;
        this.calories = builder.calories;
    }

    static class Builder {
        private String name;
        private String taste;
        private int calories;

        public Builder(String name) {
            this.name = name;
        }

        public String getTaste() {
            return taste;
        }

        public Builder setTaste(String taste) {
            this.taste = taste;
            return this;
        }

        public int getCalories() {
            return calories;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Cake build() {
            return new Cake(this);
        }
    }
}
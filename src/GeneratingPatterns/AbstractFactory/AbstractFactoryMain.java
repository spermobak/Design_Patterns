package GeneratingPatterns.AbstractFactory;

/*Фабрика по созданию фабрик*/

public class AbstractFactoryMain {
    public static void main(String[] args) {
        Factory factory = new AbstractFactory().createFactory("Lesson");
        Lesson lesson = factory.createLesson("Math");
        lesson.exist();
    }
}

interface Student {
    void learn();
}

interface Lesson {
    void exist();
}

class Math implements Lesson {

    @Override
    public void exist() {
        System.out.println("Math is exist");
    }
}

class PhysicalEducation implements Lesson {

    @Override
    public void exist() {
        System.out.println("Physical Education is exist");
    }
}

class Petya implements Student {

    @Override
    public void learn() {
        System.out.println("Petya does his homework");
    }
}

class Vova implements Student {

    @Override
    public void learn() {
        System.out.println("Vova does his homework");
    }
}

class StudentFactory implements Factory {
    public Student createStudent(String name) {
        return switch (name) {
            case ("Petya") -> new Petya();
            case ("Vova") -> new Vova();
            default -> null;
        };
    }

    @Override
    public Lesson createLesson(String lessonName) {
        return null;
    }
}

class LessonFactory implements Factory {
    public Lesson createLesson(String lessonName) {
        return switch (lessonName) {
            case ("Math") -> new Math();
            case ("Physical Education") -> new PhysicalEducation();
            default -> null;
        };
    }

    @Override
    public Student createStudent(String name) {
        return null;
    }
}

interface Factory {
    Student createStudent(String name);

    Lesson createLesson(String lessonName);
}

class AbstractFactory {
    Factory createFactory(String typeOfFactory) {
        return switch (typeOfFactory) {
            case ("Lesson") -> new LessonFactory();
            case ("Student") -> new StudentFactory();
            default -> null;
        };
    }
}
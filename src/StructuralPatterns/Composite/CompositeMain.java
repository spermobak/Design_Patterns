package StructuralPatterns.Composite;
import java.util.ArrayList;
import java.util.List;

/*Компанует объекты в дерево иерархии,
позволяет клиентом одинакого трактовать
индивидуальные и составные объекты*/

// Компонент
interface Object {
    void print();
}
// Компоновщик
class CompositeObject implements Object {
    //Коллекция дочерних объектов
    private final List<Object> ChildObjects = new ArrayList<>();
    //Выводит объект
    public void print() {
        for (Object object : ChildObjects) {
            object.print();
        }
    }
    //Добавляет объект в структуру
    public void add(Object object) {
        ChildObjects.add(object);
    }
    //Удаляет объект из структуры
    public void remove(Object object) {
        ChildObjects.remove(object);
    }
}
// Лист
class TestObject implements Object {
    //Выводит Объект
    public void print() {
        System.out.println("TestObject");
    }
}
//Клиент

public class CompositeMain {
    public static void main(String[] args) {
        //Инициализация тестовых объектов
        TestObject TestObject1 = new TestObject();
        TestObject TestObject2 = new TestObject();
        TestObject TestObject3 = new TestObject();
        TestObject TestObject4 = new TestObject();

        //Инициализация трех комповощик-объектов
        CompositeObject object = new CompositeObject();
        CompositeObject object1 = new CompositeObject();
        CompositeObject object2 = new CompositeObject();

        //Объеденияем объекты
        object1.add(TestObject1);
        object1.add(TestObject2);
        object1.add(TestObject3);

        object2.add(TestObject4);

        object.add(object1);
        object.add(object2);

        //Выводим
        object.print();
    }
}
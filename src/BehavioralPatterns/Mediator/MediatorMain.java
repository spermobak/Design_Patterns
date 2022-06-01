package BehavioralPatterns.Mediator;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/*Посредник позволяет независимо изменять взаимодействие между объектами*/

public class MediatorMain {
    public static void main(String[] args) {
        Mediator<Integer> mediator = new Mediator<>();
        mediator.setValue("bob", 20);
        mediator.setValue("alice", 24);
        mediator.getValue("alice").ifPresent(age -> System.out.println("age for alice: " + age));

        mediator.addObserver("bob", () -> System.out.println("new age for bob: " + mediator.getValue("bob").orElseThrow(RuntimeException::new)));
        mediator.setValue("bob", 21);
    }
}

class Storage<T> {
    T value;

    T getValue() {
        return value;
    }
    void setValue(Mediator<T> mediator, String storageName, T value) {
        this.value = value;
        mediator.notifyObservers(storageName);
    }
}

class Mediator<T> {
    private final HashMap<String, Storage<T>> storageMap = new HashMap<>();
    private final CopyOnWriteArrayList<Consumer<String>> observers = new CopyOnWriteArrayList<>();

    public void setValue(String storageName, T value) {
        Storage<T> storage = storageMap.computeIfAbsent(storageName, name -> new Storage<>());
        storage.setValue(this, storageName, value);
    }

    public Optional<T> getValue(String storageName) {
        return Optional.ofNullable(storageMap.get(storageName)).map(Storage::getValue);
    }

    public void addObserver(String storageName, Runnable observer) {
        observers.add(eventName -> {
            if (eventName.equals(storageName)) {
                observer.run();
            }
        });
    }

    void notifyObservers(String eventName) {
        observers.forEach(observer -> observer.accept(eventName));
    }
}

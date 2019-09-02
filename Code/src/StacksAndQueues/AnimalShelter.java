package StacksAndQueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalShelter {
    public enum Animal {
        DOG, CAT
    }
    private LinkedList<Animal> animals;

    public AnimalShelter() {
        animals = new LinkedList<Animal>();
    }

    public void enqueue(Animal animal) {
        animals.add(animal);
    }

    public Animal dequeueAny() {
        if (animals.isEmpty()) throw new NoSuchElementException();
        return animals.removeFirst();
    }

    public Animal dequeueDog() {
        if (animals.isEmpty()) throw new NoSuchElementException();
        int i = 0;
        boolean dogFound = false;
        while (i < animals.size()) {
            if (animals.get(i) == Animal.DOG) {
                dogFound = true;
                break;
            }
            i++;
        }
        if (dogFound)
            return animals.remove(i);
        return null;
    }

    public Animal dequeueCat() {
        if (animals.isEmpty()) throw new NoSuchElementException();
        int i = 0;
        boolean catFound = false;
        while (i < animals.size()) {
            if (animals.get(i) == Animal.CAT) {
                catFound = true;
                break;
            }
            i++;
        }
        if (catFound)
            return animals.remove(i);
        return null;
    }

    public static void main(String[] args) {
        AnimalShelter obj = new AnimalShelter();
        System.out.println("Enqueue: DOG");
        obj.enqueue(Animal.DOG);
        System.out.println("Enqueue: DOG");
        obj.enqueue(Animal.DOG);
        System.out.println("Enqueue: DOG");
        obj.enqueue(Animal.DOG);
        System.out.println("Enqueue: CAT");
        obj.enqueue(Animal.CAT);
        System.out.println("Enqueue: DOG");
        obj.enqueue(Animal.DOG);
        System.out.println("DequeueAny:" + obj.dequeueAny());
        System.out.println("DequeueDog:" + obj.dequeueDog());
        System.out.println("DequeueCat:" + obj.dequeueCat());
        System.out.println("DequeueCat:" + obj.dequeueCat());
        System.out.println("DequeueDog:" + obj.dequeueDog());
        System.out.println("DequeueAny:" + obj.dequeueAny());
    }
}

import generic.ex5.GenericBox;

public class Main {

    void main() {
        GenericBox<Integer> box = new GenericBox<Integer>();
        box.set(10);
        Integer result = box.get();
    }
}
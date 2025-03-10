package generic.ex2;

public class Box<Animal>{
    private Animal value;

    public void set(Animal value) {
        this.value = value;
    }
    public Animal get() {
        return value;
    }
}

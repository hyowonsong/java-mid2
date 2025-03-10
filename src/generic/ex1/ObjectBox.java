package generic.ex1;

// Object 모든 타입의 부모이다. 따라서, 다형성을 사용해서 해결해보자.
public class ObjectBox {

    private Object value;

    public void set(Object object) {
        this.value = object;
    }
    public Object get() {
        return value;
    }
}

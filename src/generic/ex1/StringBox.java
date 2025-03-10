package generic.ex1;

// 문자열을 보관하고 꺼낼 수 있는 단순한 기능을 제공
public class StringBox {
    private String value;

    public void set(String object) {
        this.value = object;
    }
    public String get() {
        return value;
    }
}

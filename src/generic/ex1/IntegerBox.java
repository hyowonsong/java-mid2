package generic.ex1;

// 숫자를 보관하고 꺼낼 수 있는 단순한 기능을 제공
public class IntegerBox {

    private Integer value;

    public void set(Integer value){
        this.value = value;
    }

    public Integer get(){
        return value;
    }
}

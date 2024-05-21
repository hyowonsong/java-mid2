package generic.test.ex3;

// Shuttle 클래스의 조건
// 제네릭 타입을 사용해야 한다.
// `showInfo()` 메서드를 통해 탑승한 유닛의 정보를 출력
public class Shuttle<T extends BioUnit> {

    private T unit;

    public void in(T t){
        unit = t;
    }

    public T out(){
        return unit;
    }

    public void showInfo(){
        System.out.println("이름: " + unit.getName() +  ", HP: " + unit.getHp());
    }
}

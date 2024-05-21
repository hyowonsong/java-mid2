package generic.test.ex3;

// UnitPrinter.printV1() 은 제네릭 메서드로 구현해야 한다.
// UnitPrinter.printV2() 는 와일드카드로 구현해야 한다.
// 이 두 메서드는 셔틀에 들어있는 유닛의 정보를 출력
public class UnitPrinter {

    public static <T extends BioUnit> void printV1(Shuttle<T> t1){
        T unit = t1.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

    public static void printV2(Shuttle<? extends BioUnit> t1) {
        BioUnit unit = t1.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }
}

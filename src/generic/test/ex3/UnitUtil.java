package generic.test.ex3;

public class UnitUtil {

    // 두 유닛을 입력 받아서 체력이 높은 유닛을 반환. 체력이 같은 경우 둘 중 아무나 반환
    // 제네릭 메서드 사용
    // 입력하는 유닛의 타입과 반환하는 유닛의 타입이 같아야 한다.
    public static <T extends BioUnit> T maxHp(T t1, T t2) {
        if (t1.getHp() > t2.getHp()){
            return t1;
        } else {
            return t2;
        }

    }
}

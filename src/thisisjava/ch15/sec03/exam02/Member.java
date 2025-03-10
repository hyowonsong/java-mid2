package thisisjava.ch15.sec03.exam02;

public class Member {
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member target) {
            return this.name.equals(target.name) && this.age == target.age;
        } else {
            return false;
        }
    }
}


/// 모든 동물의 공통 속성과 메서드
public class Animal {

    public enum AnimalType {
        DOG,
        CAT
    }

    private String name;        // 이름
    private int age;            // 나이
    private AnimalType type;    // 종류

    protected Animal(String name, int age, AnimalType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}


/// 모든 동물의 공통 속성과 메서드
public class Animal {

    public enum AnimalType {
        DOG,
        CAT
    }

    private String name;        // 이름
    private int age;            // 나이
    private AnimalType type;    // 종류

    public String GetName() {
        return name;
    }

    public int GetAge() {
        return age;
    }

    public String GetType() {
        String typeName;
        switch (type) {
            case DOG:
                typeName = "강아지";
                break;
            case CAT:
                typeName = "고양이";
                break;
            default:
                typeName = "";
        }
        return typeName;
    }

    protected Animal(String name, int age, AnimalType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}

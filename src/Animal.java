
/// 모든 동물의 공통 속성과 메서드
public abstract class Animal {
    private String name;        // 이름
    private int age;            // 나이
    private int hungryValue;    // 배고픔 수치
    private int happiness;      // 행복도

    public String GetName() {
        return name;
    }

    public int GetAge() {
        return age;
    }

    public abstract String GetType();

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        hungryValue = 50;   // 기본 세팅
        happiness = 50;     // 기본 세팅
    }

    // 놀기 (행복도 증가)
    public int Play() {
        if (happiness + 1 <= 100) {
            happiness += 1;
        }
        return happiness;
    }

    // 먹기 (배고픔 수치 감소)
    public int Eat() {
        if (hungryValue - 1 >= 0) {
            hungryValue -= 1;
        }
        return hungryValue;
    }
}

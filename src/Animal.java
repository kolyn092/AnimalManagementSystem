
/// 모든 동물의 공통 속성과 메서드
public abstract class Animal {
    private String name;        // 이름
    private int age;            // 나이
    private int hungry;    // 배고픔 수치
    private int happiness;      // 행복도

    public String GetName() {
        return name;
    }

    public int GetAge() {
        return age;
    }

    public int GetHungry() {
        return hungry;
    }

    public int GetHappiness() {
        return happiness;
    }

    public abstract String GetType();   // 종류
    public abstract void Sound();       // 울음소리

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        hungry = 50;   // 기본 세팅
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
        if (hungry - 1 >= 0) {
            hungry -= 1;
        }
        return hungry;
    }
}

package base;

import ability.Flyable;
import ability.Sprayable;
import ability.Swimmable;

import java.util.Locale;
import java.util.Scanner;

/// 모든 동물의 공통 속성과 메서드
public abstract class Animal {

    private static final int MAX_HAPPINESS = 100;
    private static final int MAX_HUNGRY = 100;

    // 사용자가 선택해서 입력하는 값을 int로 하기 위해 내부에 변환 함수 추가
    public enum FoodType {
        MEAT(1),
        FISH(2),
        GRASS(3),
        NUTS(4);

        private final int value;

        FoodType(int value) {
            this.value = value;
        }

        public static FoodType ToInt(int value) {
            for (var food : values()) {
                if (food.value == value) {
                    return food;
                }
            }
            return null;
        }
    }
    private final String name;      // 이름
    private final int age;          // 나이
    private int hungry;             // 배고픔 수치
    private int happiness;          // 행복도
    protected FoodType foodType;    // 선호하는 먹이

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

    protected Animal(String name, int age, FoodType type) {
        this.name = name;
        this.age = age;
        hungry = 50;        // 기본 세팅
        happiness = 50;     // 기본 세팅
        foodType = type;
    }

    // 행복도 증감 - 특별 능력 사용, 놀기
    protected void IncreaseHappiness(int value) {
        // 증감
        happiness += value;

        // 0보다 작거나 MAX_HAPPINESS 를 넘어가는 예외 처리
        if (happiness > MAX_HAPPINESS) {
            happiness = MAX_HAPPINESS;
        } else if (happiness < 0) {
            happiness = 0;
        }
    }

    // 놀기 (행복도 증가)
    public void Play() {
        IncreaseHappiness(10);
    }

    // 배고픔 증감
    protected void DecreaseHungry(int value) {
        // 증감
        hungry -= value;

        // 0보다 작거나 MAX_HUNGRY 를 넘어가는 예외 처리
        if (hungry > MAX_HUNGRY) {
            hungry = MAX_HUNGRY;
        } else if (hungry < 0) {
            hungry = 0;
        }
    }

    // 먹기 (배고픔 수치 감소)
    public void Eat(Scanner scanner, FoodType type) {
        int hungry;
        if (type == foodType) {
            // 선호 먹이가 맞을 경우
            DecreaseHungry(30);
            System.out.println("선호 먹이를 먹은 " + GetName() + " 의 배고픔이 크게 감소합니다");
        } else {
            // 선호 먹이가 아닌 경우
            System.out.print("선호하지 않는 음식입니다. 먹이시겠습니까?(y/n): ");

            // 입력
            String checkStr = scanner.next();
            // 소문자 변환
            checkStr = checkStr.toLowerCase();

            // 입력 데이터 처리
            if (checkStr.equals("y")) {
                // 배고픔 증감
                DecreaseHungry(2);
                // 결과 출력
                System.out.println(name + "가 선호하지 않아 배고픔이 조금 감소합니다.");
            }
            else if (checkStr.equals("n")) {
                System.out.println("먹이를 주지 않았습니다.");
                return;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 특별 능력 사용
    public void UseSpecialAbility() {
        if (this instanceof Flyable flyable) {
            flyable.Fly();
            return;
        }

        if (this instanceof Sprayable sprayable) {
            sprayable.Spray();
            return;
        }

        if (this instanceof Swimmable swimmable) {
            swimmable.Swim();
            return;
        }

        System.out.println("특별 능력이 없습니다.");
    }
}

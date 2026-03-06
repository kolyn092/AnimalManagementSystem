package base;

import ability.Flyable;
import ability.Sprayable;
import ability.Swimmable;

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
    }

    // 행복도 증감 - 특별 능력 사용, 놀기
    protected void IncreaseHappiness(int value) {
        // 증감
        happiness += value;

        // 0보다 작거나 MAX_HAPPINESS 를 넘어가는 예외 처리
        if (happiness + value > MAX_HAPPINESS) {
            happiness = MAX_HAPPINESS;
        } else if (happiness + value < 0) {
            happiness = 0;
        }
    }

    // 놀기 (행복도 증가)
    public void Play() {
        IncreaseHappiness(10);
    }

    // 먹기 (배고픔 수치 감소)
    public int Eat() {
        if (hungry - 1 >= 0) {
            hungry -= 1;
        }
        return hungry;
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

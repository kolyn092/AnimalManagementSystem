package species;

import ability.Swimmable;
import category.Reptile;

public class Turtle extends Reptile implements Swimmable {

    public Turtle(String name, int age) {
        super(name, age, FoodType.GRASS);
    }

    @Override
    public String GetType() {
        return "거북이";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 거북거북..");
    }

    @Override
    public void Swim() {
        IncreaseHappiness(30);
        System.out.println(GetName() + "가 수영을 합니다. 행복도가 크게 증가했습니다.");
    }
}
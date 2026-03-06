package species;

import ability.Sprayable;
import category.Mammal;

public class Elephant extends Mammal implements Sprayable {

    public Elephant(String name, int age) {
        super(name, age, FoodType.GRASS);
    }

    @Override
    public String GetType() {
        return "코끼리";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 뿌우~");
    }

    @Override
    public void Spray() {
        IncreaseHappiness(30);
        System.out.println(GetName() + "가 물을 뿌립니다! 행복도가 크게 증가했습니다.");
    }
}

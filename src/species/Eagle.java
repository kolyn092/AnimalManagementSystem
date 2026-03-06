package species;

import ability.Flyable;
import category.Bird;

public class Eagle extends Bird implements Flyable {

    public Eagle(String name, int age) {
        super(name, age, FoodType.MEAT);
    }

    @Override
    public String GetType() {
        return "독수리";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 피융~");
    }

    @Override
    public void Fly() {
        IncreaseHappiness(30);
        System.out.println(GetName() + "가 하늘 높이 날아올랐습니다! 행복도가 크게 증가했습니다.");
    }
}

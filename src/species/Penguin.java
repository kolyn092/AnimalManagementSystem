package species;

import ability.Swimmable;
import category.Bird;

public class Penguin extends Bird implements Swimmable {

    public Penguin(String name, int age) {
        super(name, age, FoodType.FISH);
    }

    @Override
    public String GetType() {
        return "펭귄";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 왝왝!");
    }

    @Override
    public void Swim() {

    }
}

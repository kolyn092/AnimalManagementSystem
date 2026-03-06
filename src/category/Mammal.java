package category;

import base.Animal;

public abstract class Mammal extends Animal {

    @Override
    public String GetType() {
        return "포유류";
    }

    public Mammal(String name, int age, FoodType type) {
        super(name, age, type);
    }
}

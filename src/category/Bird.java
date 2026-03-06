package category;

import base.Animal;

public abstract class Bird extends Animal {

    @Override
    public String GetType() {
        return "조류";
    }

    protected Bird(String name, int age, FoodType type) {
        super(name, age, type);
    }
}

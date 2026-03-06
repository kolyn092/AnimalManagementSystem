package category;

import base.Animal;

public abstract class Reptile extends Animal {

    @Override
    public String GetType() {
        return "파충류";
    }

    public Reptile(String name, int age, FoodType type) {
        super(name, age, type);
    }
}

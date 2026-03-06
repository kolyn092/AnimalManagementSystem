package species;

import category.Mammal;

public class Lion extends Mammal {

    public Lion(String name, int age) {
        super(name, age, FoodType.MEAT);
    }

    @Override
    public String GetType() {
        return "사자";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 크아앙");
    }
}
package species;

import category.Mammal;

public class Lion extends Mammal {

    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public String GetType() {
        return "사자";
    }

    @Override
    public void Sound() {

    }
}
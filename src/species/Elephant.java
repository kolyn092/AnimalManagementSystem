package species;

import category.Mammal;

public class Elephant extends Mammal {

    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public String GetType() {
        return "코끼리";
    }

    @Override
    public void Sound() {

    }
}

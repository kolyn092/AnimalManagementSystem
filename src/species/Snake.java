package species;

import category.Reptile;

public class Snake extends Reptile {

    public Snake(String name, int age) {
        super(name, age);
    }

    @Override
    public String GetType() {
        return "뱀";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 쉭..");
    }
}
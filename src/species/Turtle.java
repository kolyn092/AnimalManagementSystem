package species;

import category.Reptile;

public class Turtle extends Reptile {

    public Turtle(String name, int age) {
        super(name, age);
    }

    @Override
    public String GetType() {
        return "거북이";
    }

    @Override
    public void Sound() {

    }
}
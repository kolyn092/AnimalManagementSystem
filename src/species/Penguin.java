package species;

import ability.Swimmable;
import category.Bird;

public class Penguin extends Bird implements Swimmable {

    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public String GetType() {
        return "펭귄";
    }

    @Override
    public void Sound() {

    }

    @Override
    public void Swim() {

    }
}

package species;

import category.Bird;

public class Eagle extends Bird {

    public Eagle(String name, int age) {
        super(name, age);
    }

    @Override
    public String GetType() {
        return "독수리";
    }

    @Override
    public void Sound() {

    }
}

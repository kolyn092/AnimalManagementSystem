package species;

import category.Mammal;

/// Animal을 상속받은 구체적인 동물 클래스 - species.Cat
public class Cat extends Mammal {

    public Cat(String name, int age) {
        super(name, age, FoodType.MEAT);
    }

    @Override
    public String GetType() {
        return "고양이";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 야옹~");
    }
}

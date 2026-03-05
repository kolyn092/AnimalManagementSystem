
/// Animal을 상속받은 구체적인 동물 클래스 - Cat
public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public String GetType() {
        return "고양이";
    }
}

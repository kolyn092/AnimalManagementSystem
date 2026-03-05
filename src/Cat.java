
/// Animal을 상속받은 구체적인 동물 클래스 - Cat
public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
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

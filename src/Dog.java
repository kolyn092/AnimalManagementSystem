
/// Animal을 상속받은 구체적인 동물 클래스 - Dog
public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String GetType() {
        return "강아지";
    }

    @Override
    public void Sound() {
        System.out.println(GetName() + ": 멍멍!");
    }
}

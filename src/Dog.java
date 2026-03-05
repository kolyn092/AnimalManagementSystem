
/// Animal을 상속받은 구체적인 동물 클래스 - Dog
public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age, AnimalType.DOG);
    }
}

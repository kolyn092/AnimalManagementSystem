import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/// 동물들을 관리하는 메인 클래스
public class Zoo {
    private static ArrayList<Animal> animalList = new ArrayList<>();

    // 동물 등록 함수
    public static void AnimalRegistration(Scanner scanner) {
        try {
            System.out.print("동물 이름을 입력하세요: ");
            var name = scanner.next();
            System.out.print("동물 나이를 입력하세요: ");
            var age = scanner.nextInt();
            System.out.print("동물 종류를 선택하세요 (1.강아지 2.고양이): ");
            var type = scanner.nextInt();

            // 동물 등록
            switch (type) {
                case 1:
                    animalList.add(new Dog(name, age));
                    break;
                case 2:
                    animalList.add(new Cat(name, age));
                    break;
                default:
                    System.out.println("등록 실패");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력 입니다.");
        }
    }

    // 동물 목록 보기 함수
    public static void ShowAnimalList() {
        for (var animal : animalList) {
            System.out.println(animal.GetName() + " (" + animal.GetType() + ", " + animal.GetAge() + ")");
        }
    }
}
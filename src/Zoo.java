import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/// 동물들을 관리하는 메인 클래스
public class Zoo {
    private static ArrayList<Animal> animalList = new ArrayList<>();

    // 동물 등록
    public static void AnimalRegistration(Scanner scanner) {
        try {
            // 입력
            System.out.print("동물 이름을 입력하세요: ");
            var name = scanner.next();
            System.out.print("동물 나이를 입력하세요: ");
            var age = scanner.nextInt();
            System.out.print("동물 종류를 선택하세요 (1.강아지 2.고양이): ");
            var type = scanner.nextInt();

            // 종류에 따른 등록
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

    // 동물 목록 보기
    public static void ShowAnimalList() {
        if (animalList.isEmpty()) {
            System.out.println("등록된 동물이 없습니다.");
            return;
        }

        for (int i = 0; i < animalList.size(); i++) {
            var animal = animalList.get(i);
            System.out.println((i + 1) + ". " + animal.GetName() + " (" + animal.GetType() + ", " + animal.GetAge() + ")");
        }
    }

    // 동물 선택 함수
    public static Animal SelectAnimal(Scanner scanner, String str) {
        // 동물 목록
        ShowAnimalList();

        // 입력
        System.out.print(str + "동물을 선택하세요: ");
        int selectIndex = scanner.nextInt();

        // 인덱스 벗어나는 경우 처리
        if (selectIndex - 1 >= animalList.size() || selectIndex - 1 < 0) {
            System.out.println("잘못된 번호입니다.");
            return null;
        }

        // 선택한 동물 정보 가져오기
        return animalList.get(selectIndex - 1);
    }

    // 놀아주기
    public static void PlayWithAnimal(Scanner scanner) {
        // 선택한 동물 정보 가져오기
        var targetAnimal = SelectAnimal(scanner, "놀아 줄 ");

        // 잘못된 번호를 선택해서 가져온 정보가 없을 경우
        if (targetAnimal == null) {
            return;
        }

        // 놀아주기
        var nowHappiness = targetAnimal.Play();

        // 결과 출력
        System.out.println(targetAnimal.GetName() + "와 놀기 - 행복도가 증가합니다. (" + nowHappiness + ")");
    }

    // 먹이주기
    public static void FeedAnimal(Scanner scanner) {
        // 선택한 동물 정보 가져오기
        var targetAnimal = SelectAnimal(scanner, "먹이 줄 ");

        // 잘못된 번호를 선택해서 가져온 정보가 없을 경우
        if (targetAnimal == null) {
            return;
        }

        // 먹이주기
        var nowHungry = targetAnimal.Eat();

        // 결과 출력
        System.out.println(targetAnimal.GetName() + "가 먹습니다 - 배고픔이 감소합니다. (" + nowHungry + ")");
    }

    // 울음소리 듣기
    public static void ListenSound(Scanner scanner) {
        // 선택한 동물 정보 가져오기
        var targetAnimal = SelectAnimal(scanner, "울음소리를 들을 ");

        // 잘못된 번호를 선택해서 가져온 정보가 없을 경우
        if (targetAnimal == null) {
            return;
        }

        // 소리 듣기
        targetAnimal.Sound();
    }

    // 동물 상태 확인
    public static void CheckAnimalState(Scanner scanner) {
        // 선택한 동물 정보 가져오기
        var targetAnimal = SelectAnimal(scanner, "상태를 확인할 ");

        // 잘못된 번호를 선택해서 가져온 정보가 없을 경우
        if (targetAnimal == null) {
            return;
        }

        // 상태 출력
        System.out.println("배고픔: " + targetAnimal.GetHungry() + " 행복도: " + targetAnimal.GetHappiness());
    }
}
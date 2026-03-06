import base.Animal;
import species.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/// 동물들을 관리하는 메인 클래스
public class Zoo {
    private static final ArrayList<Animal> animalList = new ArrayList<>();

    // 동물 등록
    public static void AnimalRegistration(Scanner scanner) {
        try {
            // 입력
            System.out.print("동물 이름을 입력하세요: ");
            var name = scanner.next();
            System.out.print("동물 나이를 입력하세요: ");
            var age = scanner.nextInt();
            System.out.println("동물 종류를 선택하세요");
            System.out.print("(1.강아지 2.고양이 3.독수리 4.코끼리 5.사자 6.펭귄 7.뱀 8.거북이): ");
            var type = scanner.nextInt();

            // 종류에 따른 등록
            switch (type) {
                case 1:
                    animalList.add(new Dog(name, age));
                    break;
                case 2:
                    animalList.add(new Cat(name, age));
                    break;
                case 3:
                    animalList.add(new Eagle(name, age));
                    break;
                case 4:
                    animalList.add(new Elephant(name, age));
                    break;
                case 5:
                    animalList.add(new Lion(name, age));
                    break;
                case 6:
                    animalList.add(new Penguin(name, age));
                    break;
                case 7:
                    animalList.add(new Snake(name, age));
                    break;
                case 8:
                    animalList.add(new Turtle(name, age));
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

    // TODO : 현재 등록된 동물
    public static String ShowRegisterAnimal() {
        if (animalList.isEmpty()) {
            return "없음";
        }
        return "구현중입니다";
    }

    // 동물원 통계
    public static void ShowStatistics() {
        if (animalList.isEmpty()) {
            System.out.println("등록된 동물이 없습니다.");
            return;
        }

        int animalCount = animalList.size();
        int happinessSum = 0;           // 행복도 합산
        Animal happiestAnimal = null;   // 가장 행복한 동물
        ArrayList<Animal> hungryAmimalList = new ArrayList<>(); // 배고픈 동물 리스트

        for (var animal : animalList) {
            // 행복도 합산
            happinessSum += animal.GetHappiness();

            // 가장 행복한 동물 저장
            if (happiestAnimal == null
                    || animal.GetHappiness() > happiestAnimal.GetHappiness()) {
                happiestAnimal = animal;
            }

            // 배고픈 동물 (50 이상)
            if (animal.GetHungry() >= 50) {
                hungryAmimalList.add(animal);
            }
        }

        // 행복도 평균 구하기
        double avgHappiness = (double) happinessSum / animalCount;

        // 출력
        System.out.println("=== 동물원 통계 ===");
        System.out.println("- 전체 동물 수: " + animalCount);
        System.out.println("- 평균 행복도: " + avgHappiness);
        System.out.print("- 배고픈 동물: ");
        if (hungryAmimalList.isEmpty()) {
            System.out.print("없음");
        }
        for (int i = 0; i < hungryAmimalList.size(); i++) {
            var animal = hungryAmimalList.get(i);
            System.out.print(animal.GetType() + "(" + animal.GetName() +")");
            if (i < hungryAmimalList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("- 가장 행복한 동물: "
                + happiestAnimal.GetType() + "(" + happiestAnimal.GetName() + ") - 행복도 " + happiestAnimal.GetHappiness());
    }

    // 동물 선택 함수
    private static Animal SelectAnimal(Scanner scanner, String str) {
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
        targetAnimal.Play();

        // 결과 출력
        System.out.println(targetAnimal.GetName() + "와 놀기 - 행복도가 증가합니다.");
    }

    // 먹이주기
    public static void FeedAnimal(Scanner scanner) {
        // 선택한 동물 정보 가져오기
        var targetAnimal = SelectAnimal(scanner, "먹이 줄 ");

        // 잘못된 번호를 선택해서 가져온 정보가 없을 경우
        if (targetAnimal == null) {
            return;
        }

        // 먹이 선택
        System.out.print("건네 줄 먹이를 선택하세요 (1.고기 2.생선 3.식물 4.견과류): ");
        var selectIndex = scanner.nextInt();
        var food = Animal.FoodType.ToInt(selectIndex);
        if (food == null) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        // 먹이주기 및 결과 출력
        targetAnimal.Eat(scanner, food);
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

    // 특별 능력 사용
    public static void UseSpecialAbility(Scanner scanner) {
        // 선택한 동물 정보 가져오기
        var targetAnimal = SelectAnimal(scanner, "특별 능력을 사용할 ");

        // 잘못된 번호를 선택해서 가져온 정보가 없을 경우
        if (targetAnimal == null) {
            return;
        }

        // 능력 사용
        targetAnimal.UseSpecialAbility();
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

/// 프로그램 진입점 및 사용자 인터페이스
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // 관리 시스템 메뉴 출력
                System.out.println("=== 확장된 동물원 관리 시스템 ===");
                System.out.println("현재 등록된 동물: " + Zoo.ShowRegisterAnimal());
                System.out.println("""
                        1. 동물 등록
                        2. 동물 목록 보기
                        3. 먹이주기
                        4. 놀아주기
                        5. 특별 능력 사용
                        6. 통계 보기
                        7. 종료
                        """);
                System.out.print("메뉴를 선택하세요: ");

                // 메뉴 입력받기
                int selectMenu = scanner.nextInt();

                switch (selectMenu) {
                    case 1:
                        Zoo.AnimalRegistration(scanner);
                        break;
                    case 2:
                        Zoo.ShowAnimalList();
                        break;
                    case 3:
                        Zoo.FeedAnimal(scanner);
                        break;
                    case 4:
                        Zoo.PlayWithAnimal(scanner);
                        break;
                    case 5:
                        Zoo.UseSpecialAbility(scanner);
                        break;
                    case 6:
                        Zoo.ShowStatistics();
                        break;
                    case 7:
                        System.out.println("동물원 관리 시스템을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 메뉴 번호 입니다.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }
}

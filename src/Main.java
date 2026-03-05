import java.util.InputMismatchException;
import java.util.Scanner;

/// 프로그램 진입점 및 사용자 인터페이스
public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                // 관리 시스템 메뉴 출력
                System.out.println("""
                        === 동물원 관리 시스템 ===);
                        1. 동물 등록
                        2. 동물 목록 보기
                        3. 먹이주기
                        4. 놀아주기
                        5. 울음소리 듣기
                        6. 동물 상태 확인
                        7. 종료
                        """);
                System.out.print("메뉴를 선택하세요: ");

                // 메뉴 입력받기
                Scanner scanner = new Scanner(System.in);
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
                        Zoo.ListenSound(scanner);
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println("동물원 관리 시스템을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 메뉴 번호 입니다.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴 번호 입니다.");
            }
        }
    }
}

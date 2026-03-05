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
                        3. 동물과 놀기
                        4. 먹이주기
                        5. 동물 상태 확인
                        6. 울음소리 듣기
                        7. 종료
                        """);
                System.out.print("메뉴를 선택하세요: ");

                // 메뉴 입력받기
                Scanner scanner = new Scanner(System.in);
                int selectMenu = scanner.nextInt();

                switch (selectMenu) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
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

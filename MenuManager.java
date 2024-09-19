package package1;
import java.util.Scanner;

public class MenuManager {
    public static final int LOGIN = 1;
    public static final int EXIT = 2;
    public static final int ADDRESS_SEARCH = 1;
    public static final int ALL_ADDRESS_SEARCH = 2;
    public static final int LOGOUT = 3;

    private Scanner scanner;

    public MenuManager() {
        scanner = new Scanner(System.in);
    }

    public int initMenu() {
        System.out.println("<< 주소록 관리 >>");
        System.out.println("1. 로그인");
        System.out.println("2. 종료");
        System.out.print("선택: ");
        return scanner.nextInt();
    }

    public int addressMenu() {
        System.out.println("<< 주소록 관리 >>");
        System.out.println("1. 주소록 검색");
        System.out.println("2. 전체 주소록 검색");
        System.out.println("3. 로그아웃");
        System.out.print("선택: ");
        return scanner.nextInt();
    }
}

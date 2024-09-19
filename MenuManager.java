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
        System.out.println("<< �ּҷ� ���� >>");
        System.out.println("1. �α���");
        System.out.println("2. ����");
        System.out.print("����: ");
        return scanner.nextInt();
    }

    public int addressMenu() {
        System.out.println("<< �ּҷ� ���� >>");
        System.out.println("1. �ּҷ� �˻�");
        System.out.println("2. ��ü �ּҷ� �˻�");
        System.out.println("3. �α׾ƿ�");
        System.out.print("����: ");
        return scanner.nextInt();
    }
}

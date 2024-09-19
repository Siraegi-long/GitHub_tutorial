package package1;
import java.util.HashMap;
import java.util.Scanner;

public class AddressManager {
    private MenuManager menuManager;
    private HashMap<String, User> users;
    private User currentUser;

    public AddressManager() {
        this.menuManager = new MenuManager();
        this.users = new HashMap<>();
        users.put("aa", new User("aaa", "aa", "11", "5555555", "����"));
        users.put("bb", new User("bbb", "bb", "22", "1111111", "���"));
        users.put("cc", new User("ccc", "cc", "33", "2222222", "�λ�"));
    }

    public void run() {
        boolean running = true;
        while (running) {
            int choice = menuManager.initMenu();
            switch (choice) {
                case MenuManager.LOGIN:
                    if (loginProcess()) {
                        addressProcess();
                    }
                    break;
                case MenuManager.EXIT:
                    running = false;
                    System.out.println("���α׷� ����");
                    break;
            }
        }
    }

    public boolean loginProcess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("PW: ");
        String pw = scanner.nextLine();

        if (users.containsKey(id) && users.get(id).getPw().equals(pw)) {
            currentUser = users.get(id);
            currentUser.setLogin(true);
            System.out.println("�α��� ����");
            return true;
        } else {
            System.out.println("�α��� ����");
            return false;
        }
    }

    public void addressProcess() {
        boolean continueProcess = true;
        while (continueProcess) {
            int addressChoice = menuManager.addressMenu();
            switch (addressChoice) {
                case MenuManager.ADDRESS_SEARCH:
                    addressSearch();
                    break;
                case MenuManager.ALL_ADDRESS_SEARCH:
                    allAddressSearch();
                    break;
                case MenuManager.LOGOUT:
                    logout();
                    continueProcess = false;
                    break;
            }
        }
    }

    public void addressSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("�˻��� ������ �̸�: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (User user : users.values()) {
            if (user.getName().equalsIgnoreCase(searchName)) {
                System.out.println(searchName + "���� �ּ�: " + user.getAddress());
                System.out.println(searchName + "���� ��ȭ��ȣ: " + user.getPhone());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(searchName + "���� ������ ã�� �� �����ϴ�.");
        }
    }

    public void allAddressSearch() {
        System.out.println("��ü ����� �ּҷ�:");
        for (User user : users.values()) {
            System.out.println(user.getName() + "���� �ּ�: " + user.getAddress());
            System.out.println(user.getName() + "���� ��ȭ��ȣ: " + user.getPhone());
        }
    }

    public void logout() {
        currentUser.setLogin(false);
        System.out.println("�α׾ƿ��Ǿ����ϴ�.");
    }

    public static void main(String[] args) {
        AddressManager manager = new AddressManager();
        manager.run();
    }
}

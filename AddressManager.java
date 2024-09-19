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
        users.put("aa", new User("aaa", "aa", "11", "5555555", "서울"));
        users.put("bb", new User("bbb", "bb", "22", "1111111", "경기"));
        users.put("cc", new User("ccc", "cc", "33", "2222222", "부산"));
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
                    System.out.println("프로그램 종료");
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
            System.out.println("로그인 성공");
            return true;
        } else {
            System.out.println("로그인 실패");
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
        System.out.print("검색할 유저의 이름: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (User user : users.values()) {
            if (user.getName().equalsIgnoreCase(searchName)) {
                System.out.println(searchName + "님의 주소: " + user.getAddress());
                System.out.println(searchName + "님의 전화번호: " + user.getPhone());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(searchName + "님의 정보를 찾을 수 없습니다.");
        }
    }

    public void allAddressSearch() {
        System.out.println("전체 사용자 주소록:");
        for (User user : users.values()) {
            System.out.println(user.getName() + "님의 주소: " + user.getAddress());
            System.out.println(user.getName() + "님의 전화번호: " + user.getPhone());
        }
    }

    public void logout() {
        currentUser.setLogin(false);
        System.out.println("로그아웃되었습니다.");
    }

    public static void main(String[] args) {
        AddressManager manager = new AddressManager();
        manager.run();
    }
}

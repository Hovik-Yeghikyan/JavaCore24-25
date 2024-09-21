package homework.onlineStore;

import homework.onlineStore.commands.Commands;
import homework.onlineStore.model.User;
import homework.onlineStore.storage.OrderStorage;
import homework.onlineStore.storage.ProductStorage;
import homework.onlineStore.storage.UserStorage;
import homework.onlineStore.type.UserType;
import homework.onlineStore.util.UUIDUtil;

import java.util.Scanner;

public class OnlineStoreMain implements Commands {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserStorage USER_STORAGE = new UserStorage();
    private static final ProductStorage PRODUCT_STORAGE = new ProductStorage();
    private static final OrderStorage ORDER_STORAGE = new OrderStorage();
    public static User currentUser = null;

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printLoginCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;

                case LOGIN:
                    loginUserAdmin();
                    break;

                case REGISTER:
                    registerUserAdmin();
                    break;

                default:
                    System.out.println("WRONG COMMAND! TRY AGAIN");

            }
        }

    }

    private static void loginUserAdmin() {
        System.out.println("Please input your email!");
        String email = SCANNER.nextLine();
        System.out.println("Please input your password!");
        String password = SCANNER.nextLine();
        User user = USER_STORAGE.getUserByEmailAndPassword(email, password);
        if (user == null) {
            System.out.println("LOGIN OR PASSWORD IS INCORRECT!");
            return;
        }
        if (user.getUserType() == UserType.ADMIN) {
            System.out.println("YOU LOGGED IN AS ADMINISTRATOR!");
            currentUser = user;
            adminMenu();
        }
        if (user.getUserType() == UserType.ADMIN) {
            System.out.println("YOU LOGGED IN AS USER!");
            currentUser = user;
            userMenu();
        }
    }

    private static void registerUserAdmin() {
        System.out.println("Please input your email");
        String email = SCANNER.nextLine();
        User userByEmail = USER_STORAGE.getUserByEmail(email);
        if (userByEmail == null) {
            String id = UUIDUtil.generateUUID();
            System.out.println("Please input your name");
            String name = SCANNER.nextLine();
            System.out.println("Please input your password");
            String password = SCANNER.nextLine();
            System.out.println("Please select your USERTYPE ADMIN OR USER!");
            String type = SCANNER.nextLine().toUpperCase();
            UserType userType = USER_STORAGE.getUserType(type);
            if (userType != null) {
                User user = new User(id, name, email, password, userType);
                USER_STORAGE.add(user);
                System.out.println("User added!");
            } else {
                System.out.println("TYPE IS INCORRECT, ONLY ADMIN OR USER!!!");
            }

        } else {
            System.out.println("USER WITH THIS " + email + " EMAIL IS ALREADY EXISTS!!!");
        }
    }

    private static void userMenu() {
        System.out.println("hello from user menu");

    }

    private static void adminMenu() {
        System.out.println("hello from admin menu");
    }


}

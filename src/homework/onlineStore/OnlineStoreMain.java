package homework.onlineStore;

import homework.onlineStore.commands.Commands;
import homework.onlineStore.model.Order;
import homework.onlineStore.model.Product;
import homework.onlineStore.model.User;
import homework.onlineStore.storage.OrderStorage;
import homework.onlineStore.storage.ProductStorage;
import homework.onlineStore.storage.UserStorage;
import homework.onlineStore.type.OrderStatus;
import homework.onlineStore.type.PaymentMethod;
import homework.onlineStore.type.ProductType;
import homework.onlineStore.type.UserType;
import homework.onlineStore.util.StorageSerializeUtil;
import homework.onlineStore.util.UUIDUtil;

import java.util.Date;
import java.util.Scanner;

public class OnlineStoreMain implements Commands {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserStorage USER_STORAGE = StorageSerializeUtil.deserializeUserStorage();
    private static final ProductStorage PRODUCT_STORAGE = StorageSerializeUtil.deserializeProductStorage();
    private static final OrderStorage ORDER_STORAGE = StorageSerializeUtil.deserializeOrderStorage();
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

    private static void userMenu() {
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            String commands = SCANNER.nextLine();
            switch (commands) {

                case LOGOUT:
                    isRun = false;
                    currentUser = null;
                    break;

                case PRINT_ALL_PRODUCTS:
                    PRODUCT_STORAGE.printAllProducts();
                    break;

                case BUY_PRODUCT:
                    buyProduct();
                    break;

                case PRINT_MY_ORDERS:
                    ORDER_STORAGE.printOrderByUser(currentUser);
                    break;

                case CANCEL_ORDER_BY_ID:
                    cancelOrderById();
                    break;

                default:
                    System.out.println("WRONG COMMAND! TRY AGAIN");
            }
        }

    }

    private static void adminMenu() {
        boolean isRun = true;
        while (isRun) {
            Commands.printAdminCommands();
            String commands = SCANNER.nextLine();
            switch (commands) {
                case LOGOUT:
                    isRun = false;
                    currentUser = null;
                    break;

                case ADD_PRODUCT:
                    addProduct();
                    break;

                case REMOVE_PRODUCT_BY_ID:
                    removeProduct();
                    break;

                case PRINT_PRODUCTS:
                    PRODUCT_STORAGE.printAllProducts();
                    break;

                case PRINT_USERS:
                    USER_STORAGE.printAllUsers();
                    break;

                case PRINT_ORDERS:
                    ORDER_STORAGE.printAllOrders();
                    break;

                case CHANGE_ORDER_STATUS:
                    changeOrderStatus();
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
        if (user.getUserType() == UserType.USER) {
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


    private static void cancelOrderById() {
        ORDER_STORAGE.printOrderByUser(currentUser);
        System.out.println("Please select order id for cancel");
        String id = SCANNER.nextLine();
        Order orderByID = ORDER_STORAGE.getOrderByID(id);
        if (orderByID != null) {
            orderByID.setOrderStatus(OrderStatus.CANCELED);
            System.out.println("Your order is cancelled!");
            StorageSerializeUtil.serializeOrderStorage(ORDER_STORAGE);
        } else {
            System.out.println("WRONG ORDER ID!!! TRY AGAIN!!!");
        }

    }

    private static void buyProduct() {
        PRODUCT_STORAGE.printAllProducts();
        System.out.println("Please select product ID to buy");
        String productId = SCANNER.nextLine();
        Product productByID = PRODUCT_STORAGE.getProductByID(productId);
        try {
            if (productByID != null) {
                String orderId = UUIDUtil.generateUUID();
                System.out.println("Please input product quantity");
                int qty = Integer.parseInt(SCANNER.nextLine());
                if (qty <= productByID.getStockQty()) {
                    double price = qty * productByID.getPrice();
                    System.out.println("Do you want to buy this product with price " + price + " and quantity is " + qty + " ? YES/NO");
                    String answer = SCANNER.nextLine().toUpperCase();
                    if (answer.equals("NO")) {
                        System.out.println("Order cancelled");
                        return;
                    }
                    if (answer.equals("YES")) {
                        System.out.println("Please input payment method CARD/CASH/PAYPAL");
                        String paymentMethod = SCANNER.nextLine().toUpperCase();
                        PaymentMethod pay = ORDER_STORAGE.getPaymentMethod(paymentMethod);
                        if (pay != null) {
                            Date date = new Date();
                            Order order = new Order(orderId, currentUser, productByID, date, price, OrderStatus.NEW, qty, pay);
                            ORDER_STORAGE.add(order);
                            System.out.println("Thank you for buy our product!");
                        } else {
                            System.out.println("ONLY CARD/CASH/PAYPAL!!! TRY AGAIN!!!");
                        }
                    } else {
                        System.out.println("WRONG ANSWER!!! TRY AGAIN!!!");
                    }
                } else {
                    System.out.println("THERE IS NOT ENOUGH PRODUCT THERE!!!");
                }

            } else {
                System.out.println("WRONG PRODUCT ID!!! TRY AGAIN!!!");
            }
        } catch (NumberFormatException e) {
            System.out.println("PLEASE INPUT CORRECT QUANTITY/PRICE");
        }

    }


    private static void changeOrderStatus() {
        ORDER_STORAGE.printAllOrders();
        System.out.println("Please input order ID for change status!");
        String id = SCANNER.nextLine();
        Order orderByID = ORDER_STORAGE.getOrderByID(id);
        if (orderByID != null) {
            System.out.println("Please select order new type DELIVERED/CANCELLED");
            String status = SCANNER.nextLine().toUpperCase();
            OrderStatus orderStatus = ORDER_STORAGE.getOrderStatus(status);
            if (orderStatus == OrderStatus.DELIVERED) {
                orderByID.setOrderStatus(orderStatus);
                String productId = orderByID.getProduct().getId();
                Product product = PRODUCT_STORAGE.getProductByID(productId);
                int quantity = product.getStockQty() - orderByID.getQty();
                product.setStockQty(quantity);
                System.out.println("Order status updated!");
                StorageSerializeUtil.serializeOrderStorage(ORDER_STORAGE);
            }
            if (orderStatus == OrderStatus.CANCELED) {
                orderByID.setOrderStatus(orderStatus);
                System.out.println("Order cancelled!");
                StorageSerializeUtil.serializeOrderStorage(ORDER_STORAGE);
            } else {
                System.out.println("WRONG STATUS!!! ONLY DELIVERED/CANCELED");
            }
        } else {
            System.out.println("WRONG ORDER ID!!!! TRY AGAIN!!!");
        }

    }

    private static void removeProduct() {
        PRODUCT_STORAGE.printAllProducts();
        System.out.println("Please input product id for delete");
        String id = SCANNER.nextLine();
        Product productByID = PRODUCT_STORAGE.getProductByID(id);
        if (productByID != null) {
            PRODUCT_STORAGE.deleteProductById(id);
            System.out.println("Product deleted!");
            StorageSerializeUtil.serializeProductStorage(PRODUCT_STORAGE);
        } else {
            System.out.println("WRONG PRODUCT ID!!! TRY AGAIN!!!");
        }
    }

    private static void addProduct() {
        System.out.println("Please input product ID");
        String id = SCANNER.nextLine();
        Product productByID = PRODUCT_STORAGE.getProductByID(id);
        try {
            if (productByID == null) {
                System.out.println("Please input product name");
                String name = SCANNER.nextLine();
                System.out.println("Please input product description");
                String description = SCANNER.nextLine();
                System.out.println("Please input product price");
                double price = Double.parseDouble(SCANNER.nextLine());
                System.out.println("Please input product quantity");
                int qty = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Please input product type ELECTRONICS/BOOKS/CLOTHING");
                String type = SCANNER.nextLine().toUpperCase();
                ProductType productType = PRODUCT_STORAGE.getProductType(type);
                if (productType != null) {
                    Product product = new Product(id, name, description, price, qty, productType);
                    PRODUCT_STORAGE.add(product);
                    System.out.println("Product added!!!");
                } else {
                    System.out.println("WRONG PRODUCT TYPE!!! ONLY ELECTRONICS/BOOKS/CLOTHING");
                }

            } else {
                System.out.println("PRODUCT WITH THIS " + id + " ID IS ALREADY EXISTS!!!");
            }

        } catch (NumberFormatException e) {
            System.out.println("INCORRECT FORMAT PRICE/QUANTITY!!! TRY AGAIN!!!");
        }
    }
}

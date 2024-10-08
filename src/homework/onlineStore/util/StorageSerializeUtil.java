package homework.onlineStore.util;

import homework.onlineStore.storage.OrderStorage;
import homework.onlineStore.storage.ProductStorage;
import homework.onlineStore.storage.UserStorage;

import java.io.*;

public class StorageSerializeUtil {

    public static final String USER_FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\homework\\onlineStore\\data\\userStorage.dat";
    public static final String PRODUCT_FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\homework\\onlineStore\\data\\productStorage.dat";
    public static final String ORDER_FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\homework\\onlineStore\\data\\orderStorage.dat";


    public static void  serializeUserStorage(UserStorage userStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
            objectOutputStream.writeObject(userStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserStorage deserializeUserStorage() {
        File file = new File(USER_FILE_PATH);
        if (!file.exists()) {
            return new UserStorage();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            Object o = objectInputStream.readObject();
            if (o instanceof UserStorage userStorage) {
                return userStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new UserStorage();
    }

    public static void serializeProductStorage(ProductStorage productStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PRODUCT_FILE_PATH))) {
            objectOutputStream.writeObject(productStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductStorage deserializeProductStorage() {
        File file = new File(PRODUCT_FILE_PATH);
        if (!file.exists()) {
            return new ProductStorage();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PRODUCT_FILE_PATH))) {
            Object o = objectInputStream.readObject();
            if (o instanceof ProductStorage productStorage) {
                return productStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ProductStorage();
    }

    public static void serializeOrderStorage(OrderStorage orderStorage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ORDER_FILE_PATH))) {
            objectOutputStream.writeObject(orderStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OrderStorage deserializeOrderStorage() {
        File file = new File(ORDER_FILE_PATH);
        if (!file.exists()) {
            return new OrderStorage();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ORDER_FILE_PATH))) {
            Object o = objectInputStream.readObject();
            if (o instanceof OrderStorage orderStorage) {
                return orderStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new OrderStorage();
    }

}

package homework.onlineStore.storage;

import homework.onlineStore.model.User;
import homework.onlineStore.type.UserType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class UserStorage implements Serializable {

    private User[] users = new User[10];
    private int size;

    public void add(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void printAllUsers() {
        for (int i = 0; i < size; i++) {
            if (users[i].getUserType() == UserType.USER) {
                System.out.println(users[i]);
            }
        }
    }

    public User getUserById(String id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId().equals(id)) {
                return users[i];
            }
        }

        return null;
    }

    public User getUserByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public UserType getUserType(String type) {
        if (type.equals(UserType.USER.name()) || type.equals(UserType.ADMIN.name())) {
            return UserType.valueOf(type);
        }
        return null;
    }

    private void extend() {
        User[] tmp = new User[users.length * 2];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }
}

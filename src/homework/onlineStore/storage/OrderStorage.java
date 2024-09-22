package homework.onlineStore.storage;

import homework.onlineStore.model.Order;
import homework.onlineStore.model.Product;
import homework.onlineStore.model.User;
import homework.onlineStore.type.OrderStatus;
import homework.onlineStore.type.PaymentMethod;

public class OrderStorage {

    private Order[] orders = new Order[10];
    private int size;


    public void add(Order order) {
        if (size == orders.length) {
            extend();
        }
        orders[size++] = order;
    }


    public void printAllOrders() {
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }

    public void printOrderByUser(User user){
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(user)){
                System.out.println(orders[i]);
            }
        }
    }

    public Order getOrderByID(String id) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(id)) {
                return orders[i];
            }
        }
        return null;
    }


    public OrderStatus getOrderStatus(String status) {
        if (status.equals(OrderStatus.DELIVERED.name()) || status.equals(OrderStatus.CANCELED.name())) {
            return OrderStatus.valueOf(status);
        }
        return null;
    }

    public PaymentMethod getPaymentMethod(String paymentMethod) {
        if (paymentMethod.equals(PaymentMethod.CASH.name()) || paymentMethod.equals(PaymentMethod.CARD.name())||
                paymentMethod.equals(PaymentMethod.PAYPAL.name()) ) {
            return PaymentMethod.valueOf(paymentMethod);
        }
        return null;
    }

    private void extend() {
        Order[] tmp = new Order[orders.length * 2];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }
}

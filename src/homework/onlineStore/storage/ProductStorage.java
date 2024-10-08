package homework.onlineStore.storage;

import homework.onlineStore.model.Product;
import homework.onlineStore.type.ProductType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class ProductStorage implements Serializable {
    Product[] products = new Product[10];
    private int size;

    public void add(Product product) {
        if (size == products.length) {
            extend();
        }
        products[size++] = product;
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void printAllProducts() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }

    public Product getProductByID(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }

    public ProductType getProductType(String type) {
        if (type.equals(ProductType.BOOKS.name()) || type.equals(ProductType.CLOTHING.name()) ||
                type.equals(ProductType.ELECTRONICS.name())) {
            return ProductType.valueOf(type);
        }
        return null;
    }

    public void deleteProductById(String id) {
        int index = getProductIndex(id);
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                products[i - 1] = products[i];
            }
            size--;
        }
    }

    private int getProductIndex(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        Product[] tmp = new Product[products.length * 2];
        System.arraycopy(products, 0, tmp, 0, products.length);
        products = tmp;
    }
}

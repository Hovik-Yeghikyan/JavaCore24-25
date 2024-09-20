package classwork.generic;

public class Storage<T> {

    private Object[] data = new Object[10];
    private int size;

    public void add(T item) {
        if (size == data.length) {
            extend();
        }
        data[size++] = item;
    }

    public T getByIndex(int index) {
        return (T) data[index];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    private void extend() {
        Object[] tmp = new Object[data.length * 2];
        System.arraycopy(data, 0, tmp, 0, data.length);
        data = tmp;
    }
}

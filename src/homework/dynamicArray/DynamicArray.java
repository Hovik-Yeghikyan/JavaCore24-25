package homework.dynamicArray;

public class DynamicArray {

    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value) {
        if (size > array.length - 1) {
            extend();
        }
        array[size] = value;
        size++;
    }

    //1․ ստեղծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ
    //2․ քցել հին մասիվի էլեմենտները նորի մեջ
    //3․ հին մասիվի հղումը կապենք նոր մասիվի հղման հետ։
    private void extend() {
        int[] newArray = new int[array.length + 10];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
    public int getByIndex(int index) {
        for (int i = 0; i < array.length; i++) {
            if (index == i) {
                return array[index];
            }
        }
        return -1;
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void deleteByIndex(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        } else {
            System.out.println("Incorrect Index!!!");
        }
    }

    public void set(int index, int value) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                array[index] = value;
            }
        } else {
            System.out.println("Incorrect Index!!!");
        }
    }

    public void add(int index, int value) {
        int tmp;
        if (index >= 0 && index < size) {
            size++;
            for (int i = size; i > index; i--) {
                tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
            }
            array[index] = value;
        } else {
            System.out.println("Incorrect Index!!!");
        }
    }

    public boolean exists(int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
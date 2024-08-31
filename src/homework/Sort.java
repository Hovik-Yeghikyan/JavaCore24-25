package homework;

public class Sort {

    public static void main(String[] args) {
        int tmp;
        int[] array = {4, 7, 1, 3, 9, 0, 2, 166, -3, 144};
        for (int x : array) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] >= array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

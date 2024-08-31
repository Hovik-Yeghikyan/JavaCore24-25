package homework;

public class ArrayUtil {

    public static void main(String[] args) {
        int min = 0;
        int evenCount = 0;
        int oddCount = 0;
        double sum = 0;
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("first number is: " + numbers[0]);
        System.out.println("last number is: " + numbers[numbers.length - 1]);
        System.out.println("numbers length is: " + numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            if (min >= numbers[i]) {
                min = numbers[i];
            }
        }
        System.out.println("Minimum number is: " + min);

        if (numbers.length <= 2) {
            System.out.println("can't print middle values.");
        } else {
            if (numbers.length % 2 == 0) {
                System.out.println("The middle numbers is: " + numbers[numbers.length / 2] +
                                    " " + numbers[(numbers.length / 2) - 1]);
            } else {
                System.out.println("The middle number is: " + numbers[numbers.length / 2]);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("The even numbers count is: " + evenCount + "\n"
                          + "The odd numbers count is: " + oddCount);

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("sum is: " + sum / numbers.length);
    }
}

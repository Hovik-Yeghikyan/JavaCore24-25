package homework.Arrays;

public class ForIfExamples {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum is: " + sum);
        System.out.println();

        for (int i = 50; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("odd numbers is: ");
        for (int i = 0; i < 20; i++) {
            i++;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("even numbers is: ");
        for (int i = 1; i < 100; i++) {
            i++;
            System.out.print(i + " ");
            count++;
        }
        System.out.println();
        System.out.println("count of even numbers is: " + count);
    }

}

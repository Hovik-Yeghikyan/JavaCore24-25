package homework;

public class ArrayHomework {
    private static final int[] numbers = {24, 32, 24, 78, 6, 145, 256, 1266, 1099, 145};
    private static final char[] chars = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};

    public static void main(String[] args) {
        countOfNumberN();
        reverseNumbers();
        countOfDuplicateNumbers();
        countOfVowelLetters();
    }


    private static void countOfNumberN() {
        int n = 6;
        int count = 0;
        for (int number : numbers) {
            if (number == n) {
                count++;
            }
        }
        System.out.println("Count of n is: " + count);
    }

    private static void reverseNumbers() {
        int tmp;
        int lastIndex = numbers.length - 1;
        for (int i = 0; i < numbers.length / 2; i++) {
            tmp = numbers[i];
            numbers[i] = numbers[lastIndex];
            numbers[lastIndex] = tmp;
            lastIndex--;

        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void countOfDuplicateNumbers() {
        int countOfDuplicate = 0;
        int arrIndex = 0;
        boolean isPresent = false;
        int[] tmpArray = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    for (int k = 0; k < tmpArray.length; k++) {
                        if (numbers[i] == tmpArray[k]) {
                            isPresent = true;
                            break;
                        }
                    }
                    if (!isPresent) {
                        tmpArray[arrIndex++] = numbers[i];
                        countOfDuplicate++;
                        break;
                    }
                }
            }
        }
        System.out.println("Count of duplicate numbers is: " + countOfDuplicate);
    }

    private static void countOfVowelLetters() {
        int count = 0;
        char[] vowelLetters = {'ա', 'է', 'ի', 'ո', 'ւ', 'օ', 'ը'};
        for (int i = 0; i < vowelLetters.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (vowelLetters[i] == chars[j]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("count of vowel letters: " + count);
    }

}

package homework.bracechecker;

import java.util.Scanner;

public class BraceCheckerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please inter your text for scan");
        String text = scanner.nextLine();
        BraceChecker braceChecker = new BraceChecker(text);
        braceChecker.check();
    }
}

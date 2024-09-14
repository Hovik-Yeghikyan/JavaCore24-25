package classwork.classwork12;

import java.util.Scanner;

public class EnumExample {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("We have the following languages, please choose one: ");
        Language[] values = Language.values();
        for (Language value : values) {
            System.out.println(value);
        }

        String langStr = scanner.next();
        try {
            Language language = Language.valueOf(langStr.toUpperCase());
            System.out.println(language.getCountryName());
            System.out.println(language.ordinal());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

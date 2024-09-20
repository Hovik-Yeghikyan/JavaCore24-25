package classwork.generic;

public class StorageDemo {

    public static void main(String[] args) {

        Storage<String> names = new Storage<>();
        names.add("Poxos");
        names.add("Petros");
        names.add("Martiros");
        System.out.println(names.getByIndex(1));
        names.print();

        Storage<Integer> numbers = new Storage<>();
        numbers.add(45);
        numbers.add(77);
        numbers.add(985);
        numbers.print();
    }
}

package homework.dynamicArray;

public class DynamicArrayDemo {

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.add(4);
        array.add(2);
        array.add(583);
        array.add(162);
        array.add(1230);
        array.add(583);
        array.add(32);
        array.add(78);
        array.add(583);
        array.add(1642);
        array.add(785);
        array.add(58);
        array.add(714);
        array.add(230);
        //    array.print();
//        System.out.println(array.getByIndex(3));
//        System.out.println(array.getByIndex(10));
//        System.out.println(array.getByIndex(100));
//        array.print();
//        array.deleteByIndex(11);
//        array.print();
//        array.deleteByIndex(6);
//        array.print();
        //       array.set(3, 14000);
        //     array.set(13, 471);
        array.print();
//        array.add(5,7600);
//        array.add(10,450);
        //    array.print();
        //   System.out.println(array.exists(74569));
        System.out.println(array.getIndexByValue(583));
    }
}

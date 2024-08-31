package classwork.stack;

public class StackTest {

    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.push(12);
        myStack.push(36);
        myStack.push(22);
        myStack.push(97);
        myStack.push(66);
        myStack.push(15);
        myStack.push(144);
        myStack.push(168);
        myStack.push(98);
        myStack.push(44);



        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


    }
}

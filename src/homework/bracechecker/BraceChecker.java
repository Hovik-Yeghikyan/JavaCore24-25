package homework.bracechecker;

import classwork.stack.Stack;

public class BraceChecker {

    private String text;
    private char ch;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        Stack stack = new Stack();
        int pop;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;

                case '}':
                    pop = stack.pop();
                    if (pop == 0) {
                        System.out.println("Error: closed" + ch + "but not opened at " + i);
                    } else if (pop != '{') {
                        System.out.println("Error: opened " + (char) pop + " but closed " + ch + " at " + i);
                    }
                    break;

                case ']':
                    pop = stack.pop();
                    if (pop == 0) {
                        System.out.println("Error: closed" + ch + "but not opened at " + i);
                    } else if (pop != '[') {
                        System.out.println("Error: opened " + (char) pop + " but closed " + ch + " at " + i);
                    }
                    break;

                case ')':
                    pop = stack.pop();
                    if (pop == 0) {
                        System.out.println("Error: closed" + ch + "but not opened at " + i);
                    } else if (pop != '(') {
                        System.out.println("Error: opened " + (char) pop + " but closed " + ch + " at " + i);
                    }
                    break;

            }
        }
        while(stack.getTos()!= - 1){
            System.out.println("Error: Opened " + (char)stack.pop() + " but not closed");
        }
    }
}

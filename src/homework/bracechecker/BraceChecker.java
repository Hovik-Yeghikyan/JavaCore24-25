package homework.bracechecker;

public class BraceChecker {

    private String text;
    private char ch;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        Stack stack = new Stack();
        Brace pop;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(new Brace(ch, i));
                    break;

                case '}':
                    pop = stack.pop();
                    if (pop == null) {
                        System.out.println("Error: closed " + ch + "but not opened at " + i);
                    } else if (pop.getBrace() != '{') {
                        System.out.println("Error: opened " + pop.getBrace() + " but closed " + ch + " at " + pop.getIndex());
                    }
                    break;

                case ']':
                    pop = stack.pop();
                    if (pop == null) {
                        System.out.println("Error: closed " + ch + "but not opened at " + i);
                    } else if (pop.getBrace() != '[') {
                        System.out.println("Error: opened " + pop.getBrace() + " but closed " + ch + " at " + pop.getIndex());
                    }
                    break;

                case ')':
                    pop = stack.pop();
                    if (pop == null) {
                        System.out.println("Error: closed " + ch + "but not opened at " + i);
                    } else if (pop.getBrace() != '(') {
                        System.out.println("Error: opened " + pop.getBrace() + " but closed " + ch + " at " + pop.getIndex());
                    }
                    break;


            }
        }
        while (!stack.isEmpty()) {
            pop = stack.pop();
            System.out.println("Error: Opened " + pop.getBrace() + " but not closed  at" + pop.getIndex());
        }
    }
}

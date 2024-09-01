package homework.bracechecker;

public class Stack {

  public  Brace[] stack = new Brace[10];
  public   int tos;

    public Stack() {
        tos = -1;
    }

 public  void push(Brace item) {
        if (tos == stack.length-1) {
            extend();
       }
            stack[++tos] = item;

    }

  public   Brace pop() {
        if (tos < 0) {
            return null;
        } else {
            return stack[tos--];
        }
    }

    private void extend() {
        Brace[] newArray = new Brace[stack.length + 10];
        System.arraycopy(stack, 0, newArray, 0, stack.length);
        stack = newArray;
    }

  public boolean isEmpty(){
    return tos == -1;
    }
}

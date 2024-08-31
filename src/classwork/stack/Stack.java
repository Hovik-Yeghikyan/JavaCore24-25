package classwork.stack;

public class Stack {

  public  int[] stack = new int[10];
  public   int tos;

    public Stack() {
        tos = -1;
    }

 public  void push(int item) {
        if (tos == stack.length-1) {
            extend();
       }
            stack[++tos] = item;

    }

  public   int pop() {
        if (tos < 0) {
            return 0;
        } else {
            return stack[tos--];
        }
    }

    private void extend() {
        int[] newArray = new int[stack.length + 10];
        System.arraycopy(stack, 0, newArray, 0, stack.length);
        stack = newArray;
    }

    public int getTos() {
        return tos;
    }
}

package classwork.threads;

public class CurrentThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        thread.setName("My thread");
        System.out.println(thread.getName() + " " + thread.getPriority());

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }

    }
}

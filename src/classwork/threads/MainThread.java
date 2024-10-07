package classwork.threads;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new MyNewThread());
//        thread.start();
        MyNewThread myNewThread = new MyNewThread();
        myNewThread.start();
        myNewThread.setPriority(Thread.MAX_PRIORITY);

        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread " + i);
            Thread.sleep(1000);
        }
        System.out.println("main thread finished");

    }
}

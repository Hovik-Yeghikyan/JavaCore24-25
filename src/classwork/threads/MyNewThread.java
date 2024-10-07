package classwork.threads;

public class MyNewThread /*implements Runnable*/ extends Thread {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("MyNewThread " + i);
                Thread.sleep(500);
            }
            System.out.println("MyNewThread finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

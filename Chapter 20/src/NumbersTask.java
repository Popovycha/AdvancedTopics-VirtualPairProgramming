public class NumbersTask implements Runnable {
    public void run() {

        for (int i = 1; i <=10; i++) {
            System.out.println();
            try {
                int randomDelay = (int) (Math.random() *500 + 1);
                Thread.sleep(randomDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Task " + Thread.currentThread().getName() + " has finished");
    }
}

package Task_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task_4 {
    public static void main(String[] args) {
        final Resource resource1 = new Resource();
        final Thread first = new Calculation1(resource1);

        first.start();

        final Resource resource2 = new Resource();
        final ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(new Calculation2(resource2));

        executorService.shutdown();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("First number = [ " + resource1.n + " ];");
        System.out.println("Second number = [ " + resource2.n + " ];");
    }
}

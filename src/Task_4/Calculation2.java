package Task_4;

public class Calculation2 implements Runnable{
    final private Resource resource;

    public Calculation2(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run(){
        synchronized (this){
            System.out.println("Thread started");
            try {
                for (int i = 0; i < 20; i++){
                    resource.n++;
                    System.out.println(Thread.currentThread().getName() + " = " + resource.n);
                }
            } catch (Exception e) {

            }
            System.out.println("Thread ended");
        }
    }
}

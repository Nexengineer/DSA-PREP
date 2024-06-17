package MultiThreading.Synchronization;

public class InventoryManager implements Runnable {
    private int counter;

    public InventoryManager(){
        this.counter = 200000;
    }
    public int getCounter(){
        return this.counter;
    }
    @Override
    public void run() {
        String functionName = Thread.currentThread().getName();
        if(functionName.equals(SyncRunner.NAME_ISSUE)){
            for(int i=0; i<100000; i++){
                synchronized (this) {  // <------ this is fix for race condition
                    counter--;
                }
//                counter--; // <------- Unsafe operation for the race condition
            }
        } else if(functionName.equals(SyncRunner.NAME_RECEIVE)){
            for(int i=0; i<100000; i++){
                synchronized (this) { // <----- this is the monitor instance and any object can be a monitor instance
                    counter++;
                }
//                counter++;
            }
        }

        System.out.println("Thread currently accessed: " + functionName);
    }
}

package MultiThreading.Synchronization;

/* Synchronous programming
    - Only one thread executes at a given time
    - This ensures task runs sequentially
    - Main thread spawns all the threads
*/
public class SyncRunner {
    public static final String NAME_ISSUE = "issue";
    public static final String NAME_RECEIVE = "receive";

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Thread thread1 = new Thread(inventoryManager, NAME_ISSUE);
        Thread thread2 = new Thread(inventoryManager, NAME_RECEIVE);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000); // <----- This for letting the program finish
        } catch (Exception exception){
            throw new RuntimeException();
        }

        System.out.println("Current number of items in inventory: " + inventoryManager.getCounter());
    }
}

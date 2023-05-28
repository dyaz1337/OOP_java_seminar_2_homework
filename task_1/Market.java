import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue;
    private int capacity;
    private int numCustomers;

    public Market(int capacity) {
        this.queue = new LinkedList<String>();
        this.capacity = capacity;
        this.numCustomers = 0;
    }

    public boolean enqueue(String customer) {
        if (queue.size() < capacity) {
            queue.add(customer);
            numCustomers++;
            return true;
        } else {
            return false;
        }
    }

    public String dequeue() {
        if (!queue.isEmpty()) {
            numCustomers--;
            return queue.remove();
        } else {
            return null;
        }
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void addCustomer(String customer) {
        enqueue(customer);
    }

    public void removeCustomer() {
        dequeue();
    }

    public void update() {
    }
}
    public static void main(String[] args) {
        Market market = new Market(5);

        market.addCustomer("Alice");
        market.addCustomer("Bob");
        market.addCustomer("Charlie");

        System.out.println("Number of customers: " + market.getNumCustomers());

        market.removeCustomer();

        System.out.println("Number of customers: " + market.getNumCustomers());
    }
import java.util.*;
import java.util.LinkedList;
public class Ride implements RideInterface {

    // ==== Part 1 fields ====
    private String rideName;
    private int maxRider;          // WILL BE USING IN PART 5
    private int numOfCycles = 0;   // WILL BE USING IN PART 5
    private Employee rideOperator; // OPERATOR MUST BE ASSIGNED TO RUN

    // ==== Part 3 & 4 collections 
    private Queue<Visitor> queue;
    private LinkedList<Visitor> rideHistory; // FIFO waiting line (Part 3)


    // TO AVOID NULL POINTER EXCEPTION
    private void ensureQueue(){
        if (queue == null){
            queue = new LinkedList<>();
        }

    }

    //Constructors (Part 1) 
    public Ride() {}

    public Ride(String rideName, int maxRider, Employee rideOperator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.rideOperator = rideOperator;
    }

    // Getters & setters (Part 1)
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }

    public int getNumOfCycles() { return numOfCycles; }
    public void setNumOfCycles(int numOfCycles) { this.numOfCycles = numOfCycles; }

    public Employee getRideOperator() { return rideOperator; }
    public void setRideOperator(Employee rideOperator) { this.rideOperator = rideOperator; }

    // OPTIONAL GETTERS FOR LATER PARTS 
    public Queue<Visitor> getQueue() { return queue; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }

    
    // Part 3 — Queue methods
    @Override
    public void addVisitorToQueue(Visitor v) {
        ensureQueue();
        if (v == null) {
            System.out.println("Cannot add null visitor to the queue.");
            return;
        }
        queue.add(v); // linkedlist.add() always return true
        System.out.println("added to the queue" + v);

    }

    @Override
    public Visitor removeVisitorFromQueue() {
        ensureQueue();
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. no visitors to remove from the queue.");
            return null;
        }
        Visitor removed = queue.poll();
        System.out.println("removed from the queue" + removed);
        return removed;
    }

    @Override
    public void printQueue() {
        ensureQueue();
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. no visitors to print from the queue.");
            return;
        }
        System.out.println("printing visitors to the queue");
        for (Visitor v : queue) {
            System.out.println("visitor " + v);
        }

    }


    // Part 5 — Run one cycle
    @Override
    public void runOneCycle() {
        // TODO PART 5; TO MOVE UP TO MAX RIDER VISITOR FROM QUEUE TO HISTORY// TODO Part 5: Move up to maxRider visitors from queue to history; increment numOfCycles
    }


    // Part 4A — Ride history (LinkedList + Iterator)
    @Override
    public void addVisitorToHistory(Visitor v) {
        // TODO PART 4A: ADD VISITOR TO HISTORY
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        // TODO PART 4A: RETURN TRUE IF VISITOR EXIST IN HISTORY
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // TODO PART 4A: RETURN NUMBER OF VISITOR IN THE HISTORY
        return 0;
    }

    @Override
    public void printRideHistory() {
        // TODO PART 4A: TO PRINT ALL VISITORS ON THE HISTORY
    }


    // Part 4B — Sorting
    public void sortRideHistory(Comparator<Visitor> comparator) {
        // TODO PART 4B: SORT OUT RIDE HISTORY
    }


    // Part 6 — Export to CSV
    @Override
    public void exportRideHistory(String filename) {
        // TODO PART 6: WRITE HISTORY TO CSV FILE
    }

    // Part 7 — Import from CSV
    @Override
    public void importRideHistory(String filename) {
        // TODO PART 7: READ HISTORY FOR CSV FILE
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                ", rideOperator=" + rideOperator +
                '}';
    }
}

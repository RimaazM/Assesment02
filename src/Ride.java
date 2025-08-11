import java.util.*;
import java.util.LinkedList;

public class Ride implements RideInterface {

    // === Part 1: Fields ===
    private String rideName;
    private int maxRider;
    private int numOfCycles = 0;
    private Employee rideOperator;

    // === Part 3 & 4: Collections ===
    private Queue<Visitor> queue;
    private LinkedList<Visitor> rideHistory;

    // Make sure rideHistory list exists
    private void ensureHistory() {
        if (rideHistory == null) {
            rideHistory = new LinkedList<>();
        }
    }

    // Make sure queue exists
    private void ensureQueue(){
        if (queue == null){
            queue = new LinkedList<>();
        }
    }

    // === Constructors (Part 1) ===
    public Ride() {}

    public Ride(String rideName, int maxRider, Employee rideOperator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.rideOperator = rideOperator;
    }

    // === Getters & setters (Part 1) ===
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }

    public int getNumOfCycles() { return numOfCycles; }
    public void setNumOfCycles(int numOfCycles) { this.numOfCycles = numOfCycles; }

    public Employee getRideOperator() { return rideOperator; }
    public void setRideOperator(Employee rideOperator) { this.rideOperator = rideOperator; }

    public Queue<Visitor> getQueue() { return queue; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }

    // === Part 3: Queue methods ===
    @Override
    public void addVisitorToQueue(Visitor v) {
        ensureQueue();
        if (v == null) {
            System.out.println("Cannot add null visitor to the queue.");
            return;
        }
        queue.add(v);
        System.out.println("added to the queue" + v);
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        ensureQueue();
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
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
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("printing visitors to the queue");
        for (Visitor v : queue) {
            System.out.println("visitor " + v);
        }
    }

    // === Part 5: Run one cycle ===
    @Override
    public void runOneCycle() {
        ensureQueue();
        ensureHistory();

        if (rideOperator == null) {
            System.out.println("No operator. Cannot run.");
            return;
        }
        if (maxRider < 1){
            System.out.println("Invalid seats number.");
            return;
        }

        int seats = Math.min(maxRider, queue.size());

        // Move visitors from queue to history
        for (int i = 0; i < seats; i++) {
            Visitor v = queue.poll();
            if (v != null){
                addVisitorToHistory(v);
            }
        }

        numOfCycles++;
        System.out.println("Cycle completed. Took " + seats + " visitors.");
        System.out.println("Total cycles: " + numOfCycles);
    }

    // === Part 4A: Ride history ===
    @Override
    public void addVisitorToHistory(Visitor v) {
        ensureHistory();
        if (v == null) {
            System.out.println("Cannot add null visitor to the history.");
            return;
        }
        rideHistory.add(v);
        System.out.println("added to the history" + v);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        ensureHistory();
        return rideHistory.contains(v);
    }

    @Override
    public int numberOfVisitors() {
        ensureHistory();
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        ensureHistory();
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty.");
            return;
        }
        System.out.println("Ride History (oldest to newest)");
        for (Visitor v : rideHistory) {
            System.out.println(" - " + v);
        }
    }

    // === Part 4B: Sorting ===
    public void sortRideHistory(Comparator<Visitor> comparator) {
        ensureHistory();
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty. Nothing to sort.");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride History sorted");
    }

    // === Part 6: Export to CSV ===
    @Override
    public void exportRideHistory(String filename) {
        ensureHistory();
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors to export.");
            return;
        }
        java.io.File file = new java.io.File(filename);
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(file))) {
            pw.println("visitorId,name,age,contactNumber,ticketType");
            for (Visitor v : rideHistory) {
                pw.println(String.join(",",
                        v.getVisitorId(),
                        v.getName(),
                        String.valueOf(v.getAge()),
                        v.getContactNumber(),
                        v.getTicketType()
                ));
            }
            System.out.println("Exported to: " + file.getAbsolutePath());
        } catch (java.io.IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    // === Part 7: Import from CSV ===
    @Override
    public void importRideHistory(String filename) {
        ensureHistory();
        java.io.File file = new java.io.File(filename);
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) {
                    first = false;
                    if (line.toLowerCase().startsWith("visitorid")) continue;
                }
                String[] parts = line.split(",", -1);
                if (parts.length < 5) continue;
                try {
                    int age = Integer.parseInt(parts[2].trim());
                    Visitor v = new Visitor(parts[1].trim(), age, parts[3].trim(), parts[0].trim(), parts[4].trim());
                    addVisitorToHistory(v);
                } catch (NumberFormatException ignored) {}
            }
            System.out.println("Imported from: " + file.getAbsolutePath());
            System.out.println("History size after import: " + rideHistory.size());
        } catch (java.io.IOException e) {
            System.out.println("Import failed: " + e.getMessage());
        }
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

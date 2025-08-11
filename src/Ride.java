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
    private void ensureHistory() {
        if (rideHistory == null) {
            rideHistory = new LinkedList<>();
        }
    }



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
        ensureQueue();
        ensureHistory();

        if (rideOperator == null) {
            System.out.println("Rider is null. No visitors to run on cycle.");
            return;
        }
        if (maxRider < 1){
            System.out.println("Invalid number of seats");
            return;
        }
        int seats = Math.min(maxRider, queue.size());

        for (int i = 0; i < seats; i++) {
            Visitor v = queue.poll(); // remove from queue
            if (v != null){
                addVisitorToHistory(v); //record in history
            }
        }
        numOfCycles++; // increase cycle count

        System.out.println("Cycle completed. Took" + seats + "Visitors.");
        System.out.println("Total cycles:" + numOfCycles);
    }


    // Part 4A — Ride history (LinkedList + Iterator)
    @Override
    public void addVisitorToHistory(Visitor v) { //Add visitors to the ride history
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
        return false;
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
            System.out.println("Ride history is empty. No visitors to print from the history.");
            return;
        }
        System.out.println("Ride History (oldest to newest)");
        java.util.Iterator<Visitor> it = rideHistory.iterator();
        while (it.hasNext()) {
            System.out.println(" - " + it.next());
        }
    }


    // Part 4B — Sorting
    public void sortRideHistory(Comparator<Visitor> comparator) {
        ensureHistory();
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty. Nothing to sort.");
            return;
        }
        java.util.Collections.sort(rideHistory, comparator);
        System.out.println("Ride History sorted");
    }


    // Part 6 — Export to CSV
    @Override
    public void exportRideHistory(String filename) {
        ensureHistory(); // to make sure the list exists

        //simple validation
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty. No visitors to export.");
            return;
        }

        //try with resources auto closes the writer
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
            System.out.println("Exported ride history to: " + file.getAbsolutePath());
        } catch (java.io.IOException e) {
            System.out.println("Failed to export ride history: " + e.getMessage());
        }
    }



    // Part 7 — Import from CSV
    @Override
    public void importRideHistory(String filename) {
        ensureHistory(); // make sure list exists

        java.io.File file = new  java.io.File(filename);
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        // try with resources to auto close reader
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            boolean first = true; // skip header if present

            while ((line = br.readLine()) != null) {
                if (first) { // assume first line is header: visitorId,name,age,contactNumber,ticketType
                    first = false;
                    // if you know there is no header, remove this continue
                    if (line.toLowerCase().startsWith("visitorid")) continue;
                }

                // split CSV fields
                String[] parts = line.split(",", -1); // keep empty fields
                if (parts.length < 5) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String visitorId     = parts[0].trim();
                String name          = parts[1].trim();
                String ageStr        = parts[2].trim();
                String contactNumber = parts[3].trim();
                String ticketType    = parts[4].trim();

                // basic validation
                if (visitorId.isEmpty() || name.isEmpty() || ageStr.isEmpty()) {
                    System.out.println("Skipping incomplete line: " + line);
                    continue;
                }

                int age;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (NumberFormatException nfe) {
                    System.out.println("Skipping line with bad age: " + line);
                    continue;
                }

                // rebuild Visitor and add to history
                Visitor v = new Visitor(name, age, contactNumber, visitorId, ticketType);
                addVisitorToHistory(v);
            }

            System.out.println("Imported ride history from: " + file.getAbsolutePath());
            System.out.println("History size after import: " + rideHistory.size());
        } catch (java.io.IOException e) {
            System.out.println("Failed to import ride history: " + e.getMessage());
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

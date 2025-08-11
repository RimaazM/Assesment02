public interface RideInterface {

    // Part 3 — Queue
    void addVisitorToQueue(Visitor v);// add a visitor to the FIFO queue
    Visitor removeVisitorFromQueue();// remove and return the next visitor
    void printQueue();// print all visitors currently in the queue

    // Part 5 — Run one cycle
    void runOneCycle(); // move up to maxRider from queue -> history

    // Part 4A — Ride history
    void addVisitorToHistory(Visitor v); // add visitor to ride history
    boolean checkVisitorFromHistory(Visitor v); // check if visitor is in history
    int numberOfVisitors();  // total visitors in history
    void printRideHistory(); // print history (use Iterator in Ride)

    // Part 6/7 — File I/O
    void exportRideHistory(String filename); // write history to CSV
    void importRideHistory(String filename); // read history from CSV
}


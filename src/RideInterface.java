public interface RideInterface {
    // part 3
    void addVisitorToQueue(Visitor v); //ADD A VISITOR TO FIFO QUEUE
    Visitor removeVisitorFromQueue(); // REMOVE NEXT VISITOR FROM QUEUE AND RETURN
    void printQueue(); // PRINT VISITOR NOW IN THE QUEUE

    //part 5
    //RUN THE RIDE FOR ONE CYCLE, MOVING UP TO MAX RIDE VISITOR FROM QUEUE TO HISTORY
    void runOneCycle();

    // part 4A - ride history
    void addVisitorToHistory(Visitor v); //ADD VISITOR TO RIDES HISTORY
    boolean checkVisitorFromHistory(Visitor v); //TO CHECK VISITOR IN THE RIDE HISTORY
    int numberOfVisitors(); //TO RETURN TO TOTAL NUMBER OF VISITORS IN RIDES HISTORY
    void printRideHistory(); // TO PRINT ALL VISITOR IN THE RIDES HISTORY

    //part 6/7
    void exportRideHistory(String filename); //TO WRITE RIDE HISTORY TO CSV FILE
    void importRideHistory(String filename);//TO READ RIDE HISTORY IN CSV FILE

}

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo a = new AssignmentTwo();
        a.partFive();
        // run other parts here for testing
        // a.partThree();
        // a.partFourA();
        // a.partFourB();
        // a.partFive();
        // a.partSix();
        // a.partSeven();
    }

    // === Part 3: Queue Demo ===
    public void partThree() {
        Employee operator = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");

        Ride ride = new Ride("Sky Smasher", 4, operator);

        Visitor v1 = new Visitor("Alex", 20, "041 000 0001", "VIS01", "VIP");
        Visitor v2 = new Visitor("Bell", 19, "041 000 0002", "VIS02", "Standard");
        Visitor v3 = new Visitor("Christopher", 19, "041 000 0003", "VIS03", "VIP");
        Visitor v4 = new Visitor("Dan", 17, "041 000 0004", "VIS04", "Child");
        Visitor v5 = new Visitor("Eva", 20, "041 000 0005", "VIS05", "Standard");

        // add visitors to queue
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        // remove one visitor from queue
        ride.removeVisitorFromQueue();

        // print current queue
        ride.printQueue();
    }

    // === Part 4A: Ride history demo ===
    public void partFourA() {
        Employee operator = new Employee("Rata", 28, "041 000 0001", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, operator);

        Visitor v1 = new Visitor("Alex", 20, "041 000 0002", "VIS02", "Standard");
        Visitor v2 = new Visitor("Bell", 19, "041 000 0003", "VIS03", "Standard");
        Visitor v3 = new Visitor("Chris", 25, "041 000 0004", "VIS04", "Child");

        // add to ride history
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);

        // check if a visitor is in history
        System.out.println("Is Alex in history? " + ride.checkVisitorFromHistory(v1));

        // number of visitors in history
        System.out.println("Total visitors in history: " + ride.numberOfVisitors());

        // print history
        ride.printRideHistory();
    }

    // === Part 4B: Sorting demo ===
    public void partFourB() {
        Employee operator = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, operator);

        Visitor v1 = new Visitor("Chris", 25, "041 000 0003", "VIS03", "VIP");
        Visitor v2 = new Visitor("Alex", 20, "041 000 0001", "VIS01", "Standard");
        Visitor v3 = new Visitor("Bell", 19, "041 000 0002", "VIS02", "VIP");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);

        System.out.println("Before sorting:");
        ride.printRideHistory();

        // sort by name then ticket type
        ride.sortRideHistory(new VisitorComparator());

        System.out.println("After sorting:");
        ride.printRideHistory();
    }

    // === Part 5: Run one cycle ===
    public void partFive() {
        Employee operator = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, operator);

        // create 10 visitors
        Visitor v1  = new Visitor("Alex", 20, "041 000 0001", "VIS01", "VIP");
        Visitor v2  = new Visitor("Bell", 19, "041 000 0002", "VIS02", "Standard");
        Visitor v3  = new Visitor("Chris",25, "041 000 0003", "VIS03", "VIP");
        Visitor v4  = new Visitor("Dan",  17, "041 000 0004", "VIS04", "Child");
        Visitor v5  = new Visitor("Eva",  20, "041 000 0005", "VIS05", "Standard");
        Visitor v6  = new Visitor("Fiona",22, "041 000 0006", "VIS06", "Standard");
        Visitor v7  = new Visitor("Gabe", 23, "041 000 0007", "VIS07", "VIP");
        Visitor v8  = new Visitor("Hana", 21, "041 000 0008", "VIS08", "Standard");
        Visitor v9  = new Visitor("Ian",  24, "041 000 0009", "VIS09", "VIP");
        Visitor v10 = new Visitor("Jade", 22, "041 000 0010","VIS10","Standard");

        // enqueue all 10
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6);
        ride.addVisitorToQueue(v7);
        ride.addVisitorToQueue(v8);
        ride.addVisitorToQueue(v9);
        ride.addVisitorToQueue(v10);

        System.out.println("=== Queue BEFORE cycle ===");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("=== Queue AFTER cycle ===");
        ride.printQueue();

        System.out.println("=== HISTORY after one cycle ===");
        ride.printRideHistory();
    }

    // === Part 6: Export to CSV ===
    public void partSix() {
        Employee op = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, op);

        Visitor v1 = new Visitor("Alex", 20, "041 000 0001", "VIS01", "VIP");
        Visitor v2 = new Visitor("Bell", 19, "041 000 0002", "VIS02", "Standard");
        Visitor v3 = new Visitor("Chris", 25, "041 000 0003", "VIS03", "VIP");
        Visitor v4 = new Visitor("Dan", 17, "041 000 0004", "VIS04", "Child");
        Visitor v5 = new Visitor("Eva", 20, "041 000 0005", "VIS05", "Standard");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        // export to CSV
        ride.exportRideHistory("rideHistory.csv");
    }

    // === Part 7: Import from CSV ===
    public void partSeven() {
        Employee op = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, op);

        // import history from CSV
        ride.importRideHistory("rideHistory.csv");

        // print imported history
        ride.printRideHistory();
    }
}

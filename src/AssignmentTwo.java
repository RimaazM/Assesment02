public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo a = new AssignmentTwo();
        a.partSeven();
    }

    public void partThree() {
        // operator
        Employee operator = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");

        // ride
        Ride ride = new Ride("Sky Smasher", 4, operator);

        // visitors (visitorId, ticketType)
        Visitor v1 = new Visitor("Alex", 20, "041 000 0001", "VIS01", "VIP");
        Visitor v2 = new Visitor("Bell", 19, "041 000 0002", "VIS02", "Standard");
        Visitor v3 = new Visitor("Christopher", 19, "041 000 0003", "VIS03", "VIP");
        Visitor v4 = new Visitor("Dan", 17, "041 000 0004", "VIS04", "Child");
        Visitor v5 = new Visitor("Eva", 20, "041 000 0005", "VIS05", "Standard");

        // queue ops
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        ride.removeVisitorFromQueue(); // remove one
        ride.printQueue();             // print remaining in FIFO order
    }

    public void partFourA() {
        //setup objects
        Employee operator = new Employee("Rata", 28, "041 000 0001", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, operator);

        //create some visitors
        Visitor v1 = new Visitor("Alex", 20, "041 000 0002", "VIS02", "Standard");
        Visitor v2 = new Visitor("Bell", 19, "041 000 0003", "VIS03", "Standard");
        Visitor v3 = new Visitor("chris", 25, "041 000 0004", "VIS04", "Child");

        //part 4A actions
        // add visitors to the ride
        // TODO ride.addVisitorToHistory(v1); addVisitorToHistory(v2); rideVisitorToHistory(v3);

        // Check if a visitor is in history (demonstrates equals/hashCode usefulness)
        // TODO: (You implement) System.out.println("Is Alex in history? " + ride.checkVisitorFromHistory(v1));

        // Print how many have taken the ride
        // TODO: (You implement) System.out.println("Total visitors in history: " + ride.numberOfVisitors());

        // Print the full history using an Iterator
        // TODO: (You implement) ride.printRideHistory();
    }
    public void partFourB() {
        // === Setup objects for the demo ===
        Employee operator = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, operator);

        // Create visitors intentionally out of order (for sorting demo)
        Visitor v1 = new Visitor("Chris", 25, "041 000 0003", "VIS03", "VIP");
        Visitor v2 = new Visitor("Alex", 20, "041 000 0001", "VIS01", "Standard");
        Visitor v3 = new Visitor("Bell", 19, "041 000 0002", "VIS02", "VIP");

        // Add them to history in "unsorted" order
        // TODO:  ride.addVisitorToHistory(v1);
        // TODO:  ride.addVisitorToHistory(v2);
        // TODO:  ride.addVisitorToHistory(v3);

        // Print before sorting
        // TODO:  System.out.println("Before sorting:"); ride.printRideHistory();

        // Sort using our Comparator (by name, then ticketType)
        // TODO:  ride.sortRideHistory(new VisitorComparator());

        // Print after sorting to show the effect
        // TODO:  System.out.println("After sorting:"); ride.printRideHistory();

    }
    public void partFive() {
        Employee operator = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, operator);

        Visitor v1  = new Visitor("Alex", 20, "041 000 0001", "VIS01", "VIP");
        Visitor v2  = new Visitor("Bell", 19, "041 000 0002", "VIS02", "Standard");
        Visitor v3  = new Visitor("Chris", 25, "041 000 0003", "VIS03", "VIP");
        Visitor v4  = new Visitor("Dan", 17, "041 000 0004", "VIS04", "Child");
        Visitor v5  = new Visitor("Eva", 20, "041 000 0005", "VIS05", "Standard");
        Visitor v6  = new Visitor("Fiona", 22, "041 000 0006", "VIS06", "Standard");

        // add to queue
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6);

        ride.printQueue();    // before
        ride.runOneCycle();   // run
        ride.printQueue();    // after
        ride.printRideHistory(); // show who rode
    }
    public void partSix() {
        // setup
        Employee op = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, op);

        // add at least 5 visitors to HISTORY (as if they finished the ride)
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

        // export to CSV in the project folder
        ride.exportRideHistory("rideHistory.csv");
    }

    public void partSeven() {
        // show where we’re reading from
        System.out.println("Working dir: " + System.getProperty("user.dir"));

        Employee op = new Employee("Rata", 28, "041 000 0007", "Emp101", "Ride Operator");
        Ride ride = new Ride("Sky Smasher", 4, op);

        // import the file you wrote in Part 6 (same filename)
        ride.importRideHistory("rideHistory.csv");

        // confirm counts and print all
        System.out.println("Imported count: " + ride.numberOfVisitors());
        ride.printRideHistory(); // Iterator-based print inside Ride
    }
    }


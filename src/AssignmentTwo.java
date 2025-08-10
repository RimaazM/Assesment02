public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo a = new AssignmentTwo();
        a.partThree();
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

    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}

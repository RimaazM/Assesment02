// Visitor.java — represents a park visitor (inherits from Person)
public class Visitor extends Person {

    // extra fields for visitor-specific details
    private String visitorId;
    private String ticketType; // e.g., "VIP", "Standard"

    // empty constructor
    public Visitor() {
        super(); // calls Person() constructor
    }

    // full constructor — sets personal info + visitor details
    public Visitor(String name, int age, String contactNumber, String visitorId, String ticketType) {
        super(name, age, contactNumber); // set fields from Person
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    // getter for visitor ID
    public String getVisitorId() {
        return visitorId;
    }

    // setter for visitor ID
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    // getter for ticket type
    public String getTicketType() {
        return ticketType;
    }

    // setter for ticket type
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    // nicely format visitor info when printed
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", visitorId='" + visitorId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }

    // equality check (currently uses Person's equals method)
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    // hash code (currently uses Person's hashCode method)
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


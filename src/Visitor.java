public class Visitor extends Person {
    private String visitorId;
    private String ticketType; // e.g., "VIP", "Standard"

    public Visitor() {
        super();
    }

    public Visitor(String name, int age, String contactNumber, String visitorId, String ticketType) {
        super(name, age, contactNumber);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

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
}

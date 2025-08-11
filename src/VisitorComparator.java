import java.util.Comparator;

// Comparator to sort visitors by name, then by ticket type if names are same
public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor a, Visitor b) {
        // compare names first (ignoring case)
        int nameCompare = a.getName().compareToIgnoreCase(b.getName());

        // if names are different, return that comparison
        if (nameCompare != 0) {
            return nameCompare;
        }

        // if names are same, compare by ticket type
        return a.getTicketType().compareToIgnoreCase(b.getTicketType());
    }
}

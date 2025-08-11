// Employee.java — represents a staff member (inherits from Person)
public class Employee extends Person {

    // extra fields for employee-specific details
    private String employeeId;
    private String role;

    // empty constructor
    public Employee() {
        super(); // calls Person() constructor
    }

    // full constructor — sets personal info + employee details
    public Employee(String name, int age, String contactNumber, String employeeId, String role) {
        super(name, age, contactNumber); // set fields from Person
        this.employeeId = employeeId;
        this.role = role;
    }

    // getter for employee ID
    public String getEmployeeId() {
        return employeeId;
    }

    // setter for employee ID
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // getter for role
    public String getRole() {
        return role;
    }

    // setter for role
    public void setRole(String role) {
        this.role = role;
    }

    // nicely format employee info when printed
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

public class Employee extends Person {
    private String employeeId;
    private String role;

    public Employee() {
        super();
    }

    public Employee(String name, int age, String contactNumber, String employeeId, String role) {
        super(name, age, contactNumber);
        this.employeeId = employeeId;
        this.role = role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

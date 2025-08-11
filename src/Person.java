// Person.java — base class for all people (Visitors, Employees, etc.)
public abstract class Person {

    // basic personal info
    private String name;
    private int age;
    private String contactNumber;

    // empty constructor (allows creating a blank Person)
    public Person() {
    }

    // full constructor (sets all fields at once)
    public Person(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // getter for age
    public int getAge() {
        return age;
    }

    // setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // getter for contact number
    public String getContactNumber() {
        return contactNumber;
    }

    // setter for contact number
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    //  format person info when printed
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}


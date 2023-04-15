import java.util.Objects;

public class Employee {

    static int employeeCounter = 0;

    private int age;
    private String firstName;
    private String lastName;
    private int phone;
    private double salary;

    // public Employee() {
    //     this(0, "DefaultFirstName", "DefaultLastName", 0, 50);
    // }

    public Employee(int age, String firstName, String lastName, int phone) {
        this(age, firstName, lastName, phone, 50.0);
    }

    public Employee(int age, String firstName, String lastName, int phone, double salary) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.salary = salary;
        employeeCounter++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee employee) {
            return age == employee.age && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && phone == employee.phone;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, firstName, lastName, phone);
    }

    @Override
    public String toString() {
        return "Employee[" + getFullName() + ", " + age + ", " + phone + ", " + salary + "]";
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean olderThan(Employee e) {
        return age > e.age;
    }

    public void upgrade(double salary){
        this.salary += salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public int getPhone() {
        return phone;
    }
}

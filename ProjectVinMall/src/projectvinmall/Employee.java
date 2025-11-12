package projectvinmall;

public class Employee {

    protected String name, id, position, phoneNum;
    double salary;

    public Employee(String id, String name, String position, String phoneNum, double salary) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.phoneNum = phoneNum;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getInfo() {
        return String.format(getId() + "~"
                + getName() + "~"
                + getPosition() + "~"
                + getPhoneNum() + "~"
                + String.format("%.0f", getSalary())
        );
    }
}

package sample;

public class Employee {

    private String firstName;
    private String lastName;
    private String  isActive;

    public Employee(){
        this.firstName = "";
        this.lastName = "";
        this.isActive = "";
    }

    public Employee(String firstName, String lastName, String isActive){
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

}
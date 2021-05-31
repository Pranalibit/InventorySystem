package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData {

    private final StringProperty ID;
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty DOB;
    private final StringProperty EmailID;
    private final StringProperty Address;
    private final StringProperty PhoneNumber;
    private final StringProperty Salary;

    public EmployeeData(String id, String firstname, String lastname, String dob, String address, String email, String phonenumber, String salary){
        //Concept of Encapsulation
        this.ID = new SimpleStringProperty(id);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.DOB = new SimpleStringProperty(dob);
        this.Address = new SimpleStringProperty(address);
        this.EmailID = new SimpleStringProperty(email);
        this.PhoneNumber = new SimpleStringProperty(phonenumber);
        this.Salary = new SimpleStringProperty(salary);

    }
    //Getters and setters to access values of EmployeeData class from outside class
    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public StringProperty firstNameProperty() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public StringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public String getDOB() {
        return DOB.get();
    }

    public StringProperty DOBProperty() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
    }

    public String getEmailID() {
        return EmailID.get();
    }

    public StringProperty emailIDProperty() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        this.EmailID.set(emailID);
    }

    public String getAddress() {
        return Address.get();
    }

    public StringProperty addressProperty() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public String getPhoneNumber() {
        return PhoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber.set(phoneNumber);
    }

    public String getSalary() {
        return Salary.get();
    }

    public StringProperty salaryProperty() {
        return Salary;
    }

    public void setSalary(String salary) {
        this.Salary.set(salary);
    }
}




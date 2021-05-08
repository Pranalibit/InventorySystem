package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerData {
    private final StringProperty CustomerID;
    private final StringProperty CustomerFirstName;
    private final StringProperty CustomerLastName;
    private final StringProperty CustomerProduct;
    private final StringProperty CustomerQuantity;
    private final StringProperty CustomerPayment;
    private final StringProperty CustomerPhoneNumber;
    private final StringProperty CustomerAddress;
    private final StringProperty CustomerBuyDate;




    public CustomerData(String customerid, String customerfirstname, String customerlastname, String customerproduct, String customerquantity, String customerpayment, String customerphonenumber, String customeraddress, String customerbuydate) {
        this.CustomerID = new SimpleStringProperty(customerid);
        this.CustomerFirstName = new SimpleStringProperty(customerfirstname);
        this.CustomerLastName = new SimpleStringProperty(customerlastname);
        this.CustomerProduct = new SimpleStringProperty(customerproduct);
        this.CustomerQuantity = new SimpleStringProperty(customerquantity);
        this.CustomerPayment = new SimpleStringProperty(customerpayment);
        this.CustomerPhoneNumber = new SimpleStringProperty(customerphonenumber);
        this.CustomerAddress = new SimpleStringProperty(customeraddress);
        this.CustomerBuyDate = new SimpleStringProperty(customerbuydate);


    }

    public String getCustomerID() {
        return CustomerID.get();
    }

    public StringProperty customerIDProperty() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        this.CustomerID.set(customerID);
    }

    public String getCustomerFirstName() {
        return CustomerFirstName.get();
    }

    public StringProperty customerFirstNameProperty() {
        return CustomerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.CustomerFirstName.set(customerFirstName);
    }

    public String getCustomerLastName() {
        return CustomerLastName.get();
    }

    public StringProperty customerLastNameProperty() {
        return CustomerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.CustomerLastName.set(customerLastName);
    }

    public String getCustomerProduct() {
        return CustomerProduct.get();
    }

    public StringProperty customerProductProperty() {
        return CustomerProduct;
    }

    public void setCustomerProduct(String customerProduct) {
        this.CustomerProduct.set(customerProduct);
    }

    public String getCustomerQuantity() {
        return CustomerQuantity.get();
    }

    public StringProperty customerQuantityProperty() {
        return CustomerQuantity;
    }

    public void setCustomerQuantity(String customerQuantity) {
        this.CustomerQuantity.set(customerQuantity);
    }

    public String getCustomerPayment() {
        return CustomerPayment.get();
    }

    public StringProperty customerPaymentProperty() {
        return CustomerPayment;
    }

    public void setCustomerPayment(String customerPayment) {
        this.CustomerPayment.set(customerPayment);
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber.get();
    }

    public StringProperty customerPhoneNumberProperty() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.CustomerPhoneNumber.set(customerPhoneNumber);
    }

    public String getCustomerAddress() {
        return CustomerAddress.get();
    }

    public StringProperty customerAddressProperty() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.CustomerAddress.set(customerAddress);
    }

    public String getCustomerBuyDate() {
        return CustomerBuyDate.get();
    }

    public StringProperty customerBuyDateProperty() {
        return CustomerBuyDate;
    }

    public void setCustomerBuyDate(String customerBuyDate) {
        this.CustomerBuyDate.set(customerBuyDate);
    }
}

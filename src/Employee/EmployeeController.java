package Employee;

import admin.CustomerData;
import admin.EmployeeData;
import admin.ProductData;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeController {


    //Customer Pane
    @FXML
    private TextField customerid;
    @FXML
    private TextField customerfirstname;
    @FXML
    private TextField customerlastname;
    @FXML
    private TextField customerproduct;
    @FXML
    private TextField customerquantity;
    @FXML
    private TextField customerpayment;
    @FXML
    private TextField customerphonenumber;
    @FXML
    private TextField customeraddress;
    @FXML
    private DatePicker customerbuydate;
    @FXML
    private TableView<CustomerData> customerData;
    @FXML
    private TableColumn<CustomerData, String> customeridColumn;
    @FXML
    private TableColumn<CustomerData, String> customerfirstNameColumn;
    @FXML
    private TableColumn<CustomerData, String> customerlastNameColumn;
    @FXML
    private TableColumn<CustomerData, String> customerproductcolumn;
    @FXML
    private TableColumn<CustomerData, String> customerquantitycolumn;
    @FXML
    private TableColumn<CustomerData, String> customerpaymentcolumn;
    @FXML
    private TableColumn<CustomerData, String> customerphoneNumberColumn;
    @FXML
    private TableColumn<CustomerData, String> customeraddresscolumn;
    @FXML
    private TableColumn<CustomerData, String> customerbuydatecolumn;

    //Product Pane
    @FXML
    private TextField productid;
    @FXML
    private TextField productname;
    @FXML
    private TextField productquantity;
    @FXML
    private TextField productprice;
    @FXML
    private TextField productdiscount;
    @FXML
    private TableView<ProductData> productData;
    @FXML
    private TableColumn<ProductData, String> productidColumn;
    @FXML
    private TableColumn<ProductData, String> productNameColumn;
    @FXML
    private TableColumn<ProductData, String> productQuantityColumn;
    @FXML
    private TableColumn<ProductData, String> productpricecolumn;
    @FXML
    private TableColumn<ProductData, String> productdiscountcolumn;





    private dbConnection dc;
    private ObservableList<CustomerData> dataCustomer;
    private ObservableList<ProductData> dataProduct;

    public void initialize(URL url, ResourceBundle rb)
    {
        this.dc = new dbConnection();
    }


    @FXML
    private void loadCustomerData(ActionEvent actionEvent){

        System.out.println("Button Clicked");

        try
        {
            System.out.println("under try");
            Connection conn = dbConnection.getConnection();

            this.dataCustomer = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                this.dataCustomer.add(new CustomerData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error " + e);
        }

        //From CustomerData Class
        this.customeridColumn.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerID"));
        this.customerfirstNameColumn.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerFirstName"));
        this.customerlastNameColumn.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerLastName"));
        this.customerproductcolumn.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerProduct"));
        this.customerquantitycolumn.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerQuantity"));
        this.customerpaymentcolumn.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerPayment"));
        this.customerphoneNumberColumn.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("CustomerPhoneNumber"));
        this.customeraddresscolumn.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("CustomerAddress"));
        this.customerbuydatecolumn.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerBuyDate"));


        this.customerData.setItems(null);
        this.customerData.setItems(this.dataCustomer);
    }

    @FXML
    private void clearCustomerFields(ActionEvent actionEvent){

        this.customerid.setText("");
        this.customerfirstname.setText("");
        this.customerlastname.setText("");
        this.customerproduct.setText("");
        this.customerquantity.setText("");
        this.customerpayment.setText("");
        this.customerphonenumber.setText("");
        this.customeraddress.setText("");
        this.customerbuydate.setValue(null);

    }

    @FXML
    private void addCustomer(ActionEvent actionEvent){
        String sqlInsert = "INSERT INTO customer(id, fname, lname, product, quantity, payment, phoneNumber, address, buyingDate) VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?)";
        try
        {
            //Alert if any field is empty
            if (customerid.getText ().isEmpty () | customerfirstname.getText ().isEmpty () | customerlastname.getText ().isEmpty ()
                    | customerproduct.getText ().isEmpty () | customerquantity.getText ().isEmpty () | customerpayment.getText ().isEmpty ()
                    | customerphonenumber.getText ().isEmpty () | customeraddress.getText ().isEmpty () | customerbuydate.getEditor ().getText ().isEmpty ()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //Setting the title
                alert.setTitle("Error");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                //Setting the content of the dialog
                alert.setContentText("Field can't be empty");
                alert.show ();
            }
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, this.customerid.getText());
            stmt.setString(2, this.customerfirstname.getText());
            stmt.setString(3, this.customerlastname.getText());
            stmt.setString(4,this.customerproduct.getText());
            stmt.setString(5,this.customerquantity.getText());
            stmt.setString(6,this.customerpayment.getText());
            stmt.setString(7,this.customerphonenumber.getText());
            stmt.setString(8,this.customeraddress.getText());
            stmt.setString(9,this.customerbuydate.getEditor().getText());

            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            Alert alert = new Alert ( Alert.AlertType.INFORMATION );
            alert.setTitle ( "Information" );
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            //Setting the content of the dialog
            alert.setContentText("ID Should be unique");
            alert.show ();
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void addProduct(ActionEvent actionEvent){

        String sqlInsert = "INSERT INTO product(id, name, quantity, price, discount) VALUES (? , ?, ?, ?, ?)";
        try
        {
            //Alert if any field is empty
            if (productid.getText ().isEmpty () | productname.getText ().isEmpty () | productquantity.getText ().isEmpty ()
                    | productquantity.getText ().isEmpty () | productprice.getText ().isEmpty () | productdiscount.getText ().isEmpty ()
            ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //Setting the title
                alert.setTitle("Error");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                //Setting the content of the dialog
                alert.setContentText("Field can't be empty");
                alert.show ();
            }
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, this.productid.getText());
            stmt.setString(2, this.productname.getText());
            stmt.setString(3, this.productquantity.getText());
            stmt.setString(4,this.productprice.getText());
            stmt.setString(5,this.productdiscount.getText());


            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            Alert alert = new Alert ( Alert.AlertType.INFORMATION );
            alert.setTitle ( "Information" );
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            //Setting the content of the dialog
            alert.setContentText("ID Should be unique");
            alert.show ();
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void loadProduct(ActionEvent actionEvent){

        System.out.println("Button Clicked");

        try
        {
            System.out.println("under try");
            Connection conn = dbConnection.getConnection();

            this.dataProduct = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM product");
            while (rs.next()) {
                this.dataProduct.add(new ProductData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error " + e);
        }

        //From ProductData Class
        this.productidColumn.setCellValueFactory(new PropertyValueFactory<ProductData, String>("ProductID"));
        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<ProductData, String>("ProductName"));
        this.productQuantityColumn.setCellValueFactory(new PropertyValueFactory<ProductData, String>("ProductQuantity"));
        this.productpricecolumn.setCellValueFactory(new PropertyValueFactory<ProductData, String>("ProductPrice"));
        this.productdiscountcolumn.setCellValueFactory(new PropertyValueFactory<ProductData, String>("ProductDiscount"));


        this.productData.setItems(null);
        this.productData.setItems(this.dataProduct);

    }

    @FXML
    private void clearProduct(ActionEvent actionEvent){
        this.productid.setText("");
        this.productname.setText("");
        this.productquantity.setText("");
        this.productprice.setText("");
        this.productdiscount.setText("");
    }
}

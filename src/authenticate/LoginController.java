package authenticate;

import Employee.EmployeeController;
import admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    //Create instance of LoginModel Class
    LoginModel loginModel = new LoginModel();

    //Tag fields in FXML

    @FXML
    private Label userLabel;
    @FXML
    private Label passLabel;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private ComboBox<option> RolecomboBox;
    @FXML
    private Label loginStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginModel.isDBConnected()){
            System.out.println("Connected to DB");
        }
        else{
            System.out.println("Not Connected to DB");
        }

        this.RolecomboBox.setItems(FXCollections.observableArrayList(option.values()));
    }



    @FXML
    public void Login(ActionEvent actionEvent){
        try {
            if (this.loginModel.isLogin(this.username.getText(),
                    this.password.getText(),
                    ((option)this.RolecomboBox.getValue()).toString())
        ){
                System.out.println(this.username.getText());
                System.out.println(this.password.getText());
                System.out.println(((option)this.RolecomboBox.getValue()).toString());
                //login is loginButton id
                Stage stage = (Stage)this.loginButton.getScene().getWindow();
                stage.close();
                switch (((option)this.RolecomboBox.getValue()).toString()){
                    case "Admin":
                        adminLogin();
                        break;
                    case "Employee":
                        employeeLogin();
                        break;
                }


            }
            else {
                this.loginStatus.setText("Wrong Credentials");
                System.out.println(this.username.getText());
                System.out.println(this.password.getText());
                System.out.println(((option)this.RolecomboBox.getValue()).toString());

            }
        }
        catch (Exception localException){

        }
    }


    public void adminLogin(){
        try {
            Stage adminStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("admin.fxml").openStream());
            AdminController adminController = (AdminController)loader.getController();
            Scene scene = new Scene(root);
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Pannel");
            adminStage.setResizable(true);
            adminStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void employeeLogin(){
        try {
            Stage employeeStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("employee.fxml").openStream());
            //Attach controller to fxml
            EmployeeController employeeController = (EmployeeController)loader.getController();
            Scene scene = new Scene(root);
            employeeStage.setScene(scene);
            employeeStage.setTitle("Employee Dashboard");
            employeeStage.setResizable(true);
            employeeStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
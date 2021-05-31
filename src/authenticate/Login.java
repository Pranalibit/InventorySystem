//Import Package
package authenticate;

//Import JavaFx Packages
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Extend Login class to override
public class Login extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Auto Generated method
        // Load FXML
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));
        //Create scene which is at high level of hierarchy of application structure
        Scene scene = new Scene(root);
        //Set required attributes
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setResizable(true);
        //call show() method without which, the stage won't be shown
        primaryStage.show();
    }

    public static void main(String[] args) {
        //call launch() method and pass the command line arguments (args)
        launch(args);
    }
}

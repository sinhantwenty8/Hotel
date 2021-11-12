package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class RegisterController {
    @FXML
    private TextField userNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField confirmPasswordField;
    @FXML
    private Button registerbtn;

    public boolean registerUser(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connect();
        if(userNameField.getText().isBlank() || firstNameField.getText().isBlank() || lastNameField.getText().isBlank()
                || confirmPasswordField.getText().isBlank() || passwordField.getText().isBlank()){
            return alert("Please fill up everything");
        }
        if (!(passwordField.getText().equals(confirmPasswordField.getText()))){
            return alert("Password do not match!");
        };
        try{
            Statement statement = connection.createStatement();
            String query = "INSERT INTO hotel.account(firstname,lastname,username,password,type)VALUES(' " + firstNameField.getText() +
                    "' , '" +lastNameField.getText() +"' , '" + userNameField.getText() +"', '" + passwordField.getText() + "' ,'user')";
            int resultSet = statement.executeUpdate(query);
            if (resultSet ==1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Success");
                alert.setContentText("Registered successfully!");
                alert.showAndWait();
            }else{
                alert("Something went wrong.");
            }
        }catch(Exception e){
            alert("User name exist.");
            e.printStackTrace();
        }

        Stage stage = (Stage) registerbtn.getScene().getWindow();
        stage.close();
        return true;
    }

    public boolean alert(String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.setTitle("Warning");
        alert.showAndWait();
        return false;
    }
}

package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderStroke;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginScreenController {
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button registerBtn;
    @FXML
    private Button loginBtn;

    @FXML
    public boolean logIn() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connect();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT password,type FROM hotel.account WHERE username = '"
                    +userNameField.getText() +"'");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String type = resultSet.getString("type");
                if(passwordField.getText().equals(resultSet.getString("password"))){
                    if(((String) type).equals("admin")) {
                        Stage homeStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
                        homeStage.setTitle("");
                        homeStage.setScene(new Scene(root, 1480, 986));
                        homeStage.initStyle(StageStyle.TRANSPARENT);
                        homeStage.show();
                        Stage registerStage = (Stage) passwordField.getScene().getWindow();
                        registerStage.close();
                        return true;
                    }else if(type.equals("user")){
                        Stage homeStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                        homeStage.setTitle("");
                        homeStage.setScene(new Scene(root, 1480, 986));
                        homeStage.initStyle(StageStyle.TRANSPARENT);
                        homeStage.show();
                        Stage registerStage = (Stage) passwordField.getScene().getWindow();
                        registerStage.close();
                        return true;
                    }
                }else{
                    alert("Warning","Invalid input. Please try again.");
                    return false;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        if(userNameField.getText().isBlank() || passwordField.getText().isBlank()){
            alert("Warning","Please fill up everything 🥲");
        }else{
            alert("Warning","Invalid input. Please try again.");
        }
        return false;
    }

    @FXML
    public void register(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("");
            registerStage.setScene(new Scene(root, 487, 618));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void loginEnter(){
        loginBtn.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void loginExit(){
        loginBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void registerEnter(){
        registerBtn.setStyle("-fx-background-color:#5279D6 ;");
    }

    @FXML
    public void registerExit(){
        registerBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    public void alert(String title,String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}

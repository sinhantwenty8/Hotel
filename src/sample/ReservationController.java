package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ReservationController {
    @FXML
    private Button cancelBtn;
    @FXML
    private Button bookBtn;
    @FXML
    private Button printBtn;

    @FXML
    public void cancelEnter(){
        cancelBtn.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void cancelExit(){
        cancelBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void bookEnter(){
        bookBtn.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void bookExit(){
        bookBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void printEnter(){
        printBtn.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void printExit(){
        printBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void cancel(){
        Stage homeStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        homeStage.setTitle("");
        homeStage.setScene(new Scene(root, 1480, 986));
        homeStage.initStyle(StageStyle.TRANSPARENT);
        homeStage.show();
        Stage registerStage = (Stage) cancelBtn.getScene().getWindow();
        registerStage.close();
    }


}

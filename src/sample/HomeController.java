package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeController {
    @FXML
    private AnchorPane anchorPane1;
    @FXML
    private AnchorPane anchorPane2;
    @FXML
    private AnchorPane anchorPane3;
    @FXML
    private AnchorPane anchorPane4;
    @FXML
    private AnchorPane anchorPane5;

    @FXML
    public void hoverEnter1(){
        anchorPane1.setStyle("-fx-background-color:#9AABD4  ; -fx-border-color: blue");
    }

    @FXML
    public void hoverExit1(){
        anchorPane1.setStyle("-fx-background-color: white; -fx-border-color: #FAC766#FAC766");
    }

    @FXML
    public void hoverEnter2(){
        anchorPane2.setStyle("-fx-background-color: #9AABD4 ; -fx-border-color: blue");
    }

    @FXML
    public void hoverExit2(){
        anchorPane2.setStyle("-fx-background-color: white; -fx-border-color: #FAC766#FAC766");
    }

    @FXML
    public void exit(){
        Stage stage = (Stage) anchorPane1.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void hoverEnter3(){
        anchorPane3.setStyle("-fx-background-color: #9AABD4  ; -fx-border-color: blue");
    }

    @FXML
    public void hoverExit3(){
        anchorPane3.setStyle("-fx-background-color: white; -fx-border-color: #FAC766#FAC766");
    }

    @FXML
    public void hoverEnter4(){
        anchorPane4.setStyle("-fx-background-color: #9AABD4  ; -fx-border-color: blue");
    }

    @FXML
    public void hoverExit4(){
        anchorPane4.setStyle("-fx-background-color: white; -fx-border-color: #FAC766#FAC766");
    }

    @FXML
    public void hoverEnter5(){
        anchorPane5.setStyle("-fx-background-color: #9AABD4  ; -fx-border-color: blue");
    }

    @FXML
    public void hoverExit5(){
        anchorPane5.setStyle("-fx-background-color: white; -fx-border-color: #FAC766#FAC766");
    }

    @FXML
    public void logOut(){
        Stage stage = (Stage) anchorPane1.getScene().getWindow();
        stage.close();
        Stage loginStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginStage.setTitle("Welcome");
        loginStage.setScene(new Scene(root, 496, 660));
        loginStage.initStyle(StageStyle.TRANSPARENT);
        loginStage.show();
    }

    @FXML
    public void reservation(){
        Stage stage = (Stage) anchorPane1.getScene().getWindow();
        stage.close();
        Stage reservationStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("reservation.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        reservationStage.setTitle("Welcome");
        reservationStage.setScene(new Scene(root, 1607, 985));
        reservationStage.initStyle(StageStyle.TRANSPARENT);
        reservationStage.show();

    }

    @FXML
    public void availableRoom(){
        Stage stage = (Stage) anchorPane1.getScene().getWindow();
        stage.close();
        Stage availableRoomStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("availableRoom.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        availableRoomStage.setTitle("");
        availableRoomStage.setScene(new Scene(root, 1607, 985));
        availableRoomStage.initStyle(StageStyle.TRANSPARENT);
        availableRoomStage.show();
    }


}

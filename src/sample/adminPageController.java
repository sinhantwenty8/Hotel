package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class adminPageController {
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

}

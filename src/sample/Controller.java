package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
//    @FXML
//    private ImageView imageView;
//    @FXML
//    private AnchorPane overlay;
//    @FXML
//    private ProgressBar progressBar;
//    @FXML
//    private Label labelWelcome;
//
//    @Override
//
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000),imageView);
//        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(5000),overlay);
//        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(5000),progressBar);
//        FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(5000),labelWelcome);
//        fadeTransition.setFromValue(1.0);
//        fadeTransition.setToValue(0);
//        fadeTransition.play();
//        fadeTransition1.setFromValue(0.3);
//        fadeTransition1.setToValue(0);
//        fadeTransition1.play();
//
//
//
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            synchronized public void run() {
//                try {
//                    double i;
//                    for(i= 0; i <=1 ; i+=0.1 ){
//                        progressBar.setProgress(i);
//                        Thread.sleep(400);
//                        progressBar.setAccessibleText(i+"%");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//
//
//    }
//    public void newWindow(){
//        Stage newStage = new Stage();
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        newStage.setTitle("Hello World");
//        newStage.setScene(new Scene(root, 709, 468));
//        newStage.show();
//
//    }
private Label label;
    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        FadeTransition fadeTransition=new FadeTransition(Duration.millis(5000),imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage loginScreen=new Stage();
                Parent root=null;

                try {
                    root=FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Stage current=(Stage)imageView.getScene().getWindow();
                Scene scene=new Scene(root,495,660);

                loginScreen.setScene(scene);
                current.hide();
                loginScreen.show();

            }
        });
        fadeTransition.play();
    }

}

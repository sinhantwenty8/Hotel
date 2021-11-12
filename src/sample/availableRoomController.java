package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.stream.Collector;

public class availableRoomController implements Initializable {
    @FXML
    private Button searchBtn1;
    @FXML
    private Button searchBtn2;
    @FXML
    private Button allBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private TableColumn<Room,String> room_number_column;
    @FXML
    private TableColumn<Room,String> room_type_column;
    @FXML
    private TableColumn<Room,Integer> number_of_people_column;
    @FXML
    private TableColumn<Room,String> room_price_column;
    @FXML
    private TableColumn<Room,String>room_status_column;
    @FXML
    private TableView<Room> tableView;
    @FXML
    private ObservableList<Room> rooms = FXCollections.observableArrayList();
    @FXML
    private RadioButton busy_radio;
    @FXML
    private RadioButton available_radio;
    @FXML
    private TextField search_room_field;

    @FXML
    public void closeEnter(){
        closeBtn.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void closeExit(){
        closeBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void backEnter(){
        backBtn.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void backExit(){
        backBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void availableEnter(){
        allBtn.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void availableExit(){
        allBtn.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void search2Enter(){
        searchBtn2.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void search2Exit(){
        searchBtn2.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void searchEnter(){
        searchBtn1.setStyle("-fx-background-color: #5279D6;");
    }

    @FXML
    public void searchExit(){
        searchBtn1.setStyle("-fx-background-color: #35CD96 ;");
    }

    @FXML
    public void back() throws IOException {
        Stage homeStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        homeStage.setTitle("");
        homeStage.setScene(new Scene(root, 1480, 986));
        homeStage.initStyle(StageStyle.TRANSPARENT);
        homeStage.show();
        Stage registerStage = (Stage) allBtn.getScene().getWindow();
        registerStage.close();
    }

    @FXML
    public void close(){
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showRooms(getRooms());
    }

    @FXML
    public ObservableList<Room> getRooms(){
        rooms.clear();
        String query = "SELECT * from hotel.room";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Room room = new Room(resultSet.getInt("room_id"),
                        resultSet.getString("room_type")
                        , resultSet.getString("room_number"),
                        resultSet.getInt("number_of_people"),
                        resultSet.getInt("room_phone"),
                        resultSet.getString("room_price"),
                        resultSet.getString("room_status"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @FXML
    public void showRooms(ObservableList room_list){
        room_number_column.setCellValueFactory(new PropertyValueFactory<>("room_number"));
        room_price_column.setCellValueFactory(new PropertyValueFactory<>("room_price"));
        room_status_column.setCellValueFactory(new PropertyValueFactory<>("room_status"));
        room_type_column.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        number_of_people_column.setCellValueFactory(new PropertyValueFactory<>("number_of_people"));
        tableView.setItems(room_list);
    }

    @FXML
    public void availableRoom(){
        ObservableList<Room> room_list = getRooms();
        ObservableList<Room> filter = room_list.filtered(room -> room.getRoom_status().equals("Available"));
        showRooms(filter);
    }

    @FXML
    public void busyRoom(){
        ObservableList<Room> room_list = getRooms();
        ObservableList<Room> filter = room_list.filtered(room -> room.getRoom_status().equals("Busy"));
        showRooms(filter);
    }

    @FXML
    public void searchStatus(){
        if(available_radio.isSelected()){
            availableRoom();
        }else if(busy_radio.isSelected()){
            busyRoom();
        }
    }

    @FXML
    public void allRoom(){
        showRooms(getRooms());
    }

    @FXML
    public void searchRoom(){
        String room_number = search_room_field.getText();
        ObservableList<Room> room1 = rooms.filtered(room -> room.getRoom_number().equals(room_number));
        tableView.setItems(room1);
        search_room_field.setText("");
    }

}

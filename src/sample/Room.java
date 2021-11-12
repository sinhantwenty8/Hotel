package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Room {
    private SimpleIntegerProperty room_id;
    private SimpleStringProperty room_type;
    private SimpleStringProperty room_number;
    private SimpleIntegerProperty number_of_people;
    private SimpleIntegerProperty room_phone;
    private SimpleStringProperty room_price;
    private SimpleStringProperty room_status;

    public Room(int room_id, String room_type, String room_number, int number_of_people, int room_phone, String room_price, String room_status) {
        this.room_id = new SimpleIntegerProperty(room_id);
        this.room_type = new SimpleStringProperty(room_type);
        this.room_number = new SimpleStringProperty(room_number);
        this.number_of_people = new SimpleIntegerProperty(number_of_people);
        this.room_phone = new SimpleIntegerProperty(room_phone);
        this.room_price = new SimpleStringProperty(room_price);
        this.room_status = new SimpleStringProperty(room_status);
    }

    public int getRoom_id() {
        return room_id.get();
    }

    public SimpleIntegerProperty room_idProperty() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id.set(room_id);
    }

    public String getRoom_type() {
        return room_type.get();
    }

    public SimpleStringProperty room_typeProperty() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type.set(room_type);
    }

    public String getRoom_number() {
        return room_number.get();
    }

    public SimpleStringProperty room_numberProperty() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number.set(room_number);
    }

    public int getNumber_of_people() {
        return number_of_people.get();
    }

    public SimpleIntegerProperty number_of_peopleProperty() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people.set(number_of_people);
    }

    public int getRoom_phone() {
        return room_phone.get();
    }

    public SimpleIntegerProperty room_phoneProperty() {
        return room_phone;
    }

    public void setRoom_phone(int room_phone) {
        this.room_phone.set(room_phone);
    }

    public String getRoom_price() {
        return room_price.get();
    }

    public SimpleStringProperty room_priceProperty() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price.set(room_price);
    }

    public String getRoom_status() {
        return room_status.get();
    }

    public SimpleStringProperty room_statusProperty() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status.set(room_status);
    }
}


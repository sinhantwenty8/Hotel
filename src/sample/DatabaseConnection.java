package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection(){
    }

    public Connection connect(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",
                    "Deleted");

        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}

//    Group 1 (Server Class)
//    Member:
//    Chrisna Maulana Fatchurrochim (21523265)
//    Diva Ivani Arista Pangastuti (21523217)
//    Muhammad Farhan Machdi (21523072)
//    Naufal Ardiyanto (21523196)
    
//    Username: Admin
//    Password: 123

package infoshop_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Infoshop_Project extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML1Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Main Page");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

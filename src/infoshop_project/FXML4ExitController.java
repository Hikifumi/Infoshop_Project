package infoshop_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXML4ExitController implements Initializable {

    @FXML
    private void yesButtonAction(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXML1Main.fxml"));
        Scene scene = new Scene(scene2);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Page");
        stage.show();
        System.out.println("Exit to main menu");
    }
    
    @FXML
    private void noButtonAction(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXML3Edit.fxml"));
        Scene scene = new Scene(scene2);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Merchandise Table");
        stage.show();
        System.out.println("Back to Table");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

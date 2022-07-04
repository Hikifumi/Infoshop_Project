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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML2LoginController implements Initializable {

    @FXML
    private TextField tfUsername;
    
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML3Edit.fxml"));
        Parent scene2 = loader.load();
        
        FXML3EditController login = loader.getController();
        login.getData(tfUsername.getText());
        
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.setTitle("Merchandise Table");
        stage.show();
        System.out.println(tfUsername.getText());
        System.out.println("Masuk ke List Barang");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

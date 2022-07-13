package infoshop_project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML2LoginController implements Initializable {
    
    ArrayList<Admin> admin = new ArrayList();
    
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPw;
    @FXML private Label label1;
    
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        String user, pw;
        boolean next = false;
        user = tfUsername.getText();
        pw = pfPw.getText();
        
        for(int i=0; i<admin.size();i++){
            if (user.equals(admin.get(i).getUser()) && pw.equals(admin.get(i).getPw())){
                next = true;
            }else{
                label1.setText("Username or Password are Incorrect, please try again.");
            }
        }
        
        if(next){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML3Edit.fxml"));
            Parent scene2 = loader.load();

            FXML3EditController login = loader.getController();
            login.getData(tfUsername.getText());

            Stage stage = new Stage();
            stage.setScene(new Scene(scene2));
            stage.setTitle("Merchandise Table");
            stage.show();
            System.out.println("Admin: "+tfUsername.getText());
            System.out.println("Masuk ke List Barang");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        admin.add(new Admin("Admin","123"));
        admin.add(new Admin("Farhan","21523072"));
        admin.add(new Admin("Fatur","21523265"));
        admin.add(new Admin("Naufal","21523196"));
        admin.add(new Admin("Diva","21523217"));
    }    
    
}

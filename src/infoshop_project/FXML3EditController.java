package infoshop_project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXML3EditController implements Initializable {
    XStream xstream = new XStream(new StaxDriver());
    ObservableList<Item> data = FXCollections.observableArrayList();
    Item item = new Item();
    
    @FXML private Label lSeller;
    
    @FXML private TableView<Item> tvMerch;
    
    @FXML private TableColumn<Item, String> tcName;
    @FXML private TableColumn<Item, Integer> tcStock;
    @FXML private TableColumn<Item, String> tcType;
    @FXML private TableColumn<Item, Integer> tcPrice;
    
    @FXML private TextField tfName;
    @FXML private TextField tfStock;
    @FXML private TextField tfType;
    @FXML private TextField tfPrice;
    
    @FXML private ChoiceBox cbExpedition;
    
    @FXML private Button Badd;
    @FXML private Button Bedit;
    @FXML private Button Bdelete;
    @FXML private Button Bincome;
    
    void OpenXML() {
        FileInputStream cobi = null;
        try {
            cobi = new FileInputStream("barang.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya ="";
            
            while ((isi = cobi.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }
            data =  (ObservableList) xstream.fromXML(stringnya);
        }
        catch (Exception e){
            System.err.println("test: "+e.getMessage());
        }
        finally{
            if(cobi != null){
                try{
                    cobi.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
    }

    void SaveXML() {
        String xml = xstream.toXML(data);
        FileOutputStream coba = null;
        try {
            coba = new FileOutputStream("barang.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            coba.write(bytes);
            coba.close();
            System.out.println("Data Berhasil Disimpan");

        }catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    private void addtoshelfButton(ActionEvent event){
        String name = tfName.getText();
        String stock = tfStock.getText();
        String type = (String) cbExpedition.getValue();
        String price = tfPrice.getText();
        int stock2 = Integer.parseInt(stock);
        int price2 = Integer.parseInt(price);
        
        data.add(new Item(name, stock2, type, price2));
        
        tfName.setText("");
        tfStock.setText("");
        cbExpedition.setValue("External Expedition");
        tfPrice.setText("");
        
        SaveXML();
    }
    
    @FXML
    void tableClick(MouseEvent event) throws ParseException{
        Item clickedItem = (Item) tvMerch.getSelectionModel().getSelectedItem();
        tfName.setText(String.valueOf(clickedItem.getName()));
        tfStock.setText(String.valueOf(clickedItem.getStock()));
        cbExpedition.setValue(String.valueOf(clickedItem.getType()));
        tfPrice.setText(String.valueOf(clickedItem.getPrice()));
    }
    
    @FXML
    private void editButtonAction(ActionEvent event) {
        String name = tfName.getText();
        String stock = tfStock.getText();
        String type = (String) cbExpedition.getValue();
        String price = tfPrice.getText();
        int stock2 = Integer.parseInt(stock);
        int price2 = Integer.parseInt(price);
        
        int pick = tvMerch.getSelectionModel().getSelectedIndex();
        if (pick >= 0){
            tvMerch.getItems().remove(pick);
            tvMerch.getItems().add(pick,new Item(name, stock2, type, price2));
        }
        
        tfName.setText("");
        tfStock.setText("");
        cbExpedition.setValue("External Expedition");
        tfPrice.setText("");
        
        SaveXML();
    }
    
    @FXML
    private void clearButtonAction(ActionEvent event) {
        tfName.setText("");
        tfStock.setText("");
        cbExpedition.setValue("External Expedition");
        tfPrice.setText("");
    }
    
    @FXML
    private void deleteButtonAction(ActionEvent event) {
        int pick = tvMerch.getSelectionModel().getSelectedIndex();
        if (pick >= 0){
            tvMerch.getItems().remove(pick);
        }
        SaveXML();
    }
    
    @FXML
    private void incomeButtonAction(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXML6Chart.fxml"));
        Scene scene = new Scene(scene2);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Income Chart");
        stage.show();
        System.out.println("Charrt Penghasilan");
    }
    
    @FXML
    private void exitButtonAction(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXML4Exit.fxml"));
        Scene scene = new Scene(scene2);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Exit");
        stage.show();
        System.out.println("Exit");
    }
    
    public void getData(String d){
        lSeller.setText("Hi, " + d + "! How are you?");
        System.out.println("getData method is Invoked");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpenXML();
        
        cbExpedition.getItems().addAll("External Expedition","JNE","JNT","Tiki","Antareja","SiCepat");
        cbExpedition.setValue("External Expedition");
        
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tvMerch.setItems(data);
    }    
    
}

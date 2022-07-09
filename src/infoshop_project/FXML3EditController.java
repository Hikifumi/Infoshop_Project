package infoshop_project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXML3EditController implements Initializable {
    XStream xstream = new XStream(new StaxDriver());
    ItemList data;
    ArrayList<Item> ListItem = new ArrayList<Item>();
    ObservableList<Item> observableListItem = observableArrayList();
//    ArrayList<Item> ListItem = new ArrayList<Item>();
    
    @FXML
    private Label lSeller;
    
    @FXML
    private TableView<Item> tvMerch;
    
    @FXML
    private TableColumn<Item, String> tcName;
    
    @FXML
    private TableColumn<Item, Integer> tcStock;
    
    @FXML
    private TableColumn<Item, String> tcType;
    
    @FXML
    private TableColumn<Item, Integer> tcPrice;
    
    @FXML
    private TextField tfName;
    
    @FXML
    private TextField tfStock;
    
    @FXML
    private TextField tfType;
    
    @FXML
    private TextField tfPrice;
    
    @FXML
    private TextField tfIndex;
    
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
    
    @FXML
    private void incomeButtonAction(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXML5Income.fxml"));
        Scene scene = new Scene(scene2);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Income Table");
        stage.show();
        System.out.println("Penghasilan");
    }
    
    @FXML
    private void addtoshelfButton(ActionEvent event){
        String name = tfName.getText();
        String stock = tfStock.getText();
        String type = tfType.getText();
        String price = tfPrice.getText();
        int stock2 = Integer.parseInt(stock);
        int price2 = Integer.parseInt(price);
        data.setData(name, stock2, type, price2);
        tvMerch.setItems(data.getData());
        System.out.println("Barang telah ditambahkan");
        
        tfName.setText("");
        tfStock.setText("");
        tfType.setText("");
        tfPrice.setText("");
        
        Item dataBarang = new Item(name, stock2, type, price2);
        ListItem.add(dataBarang);
    }
    
    public void getData(String d){
        lSeller.setText("Hi, " + d + "! Sehat po?");
        System.out.println("getData method is Invoked");
    }
    
    @FXML
    private void saveButtonAction(ActionEvent event) {
        File f = new File("dataBarang.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }

        SaveAndCreate();
        System.out.println("Bismillah Save");
    }
    
    @FXML
    private void deleteButtonAction(ActionEvent event) {
        int selected = tvMerch.getSelectionModel().getSelectedIndex();
        tvMerch.getItems().remove(selected);
    }
    
    @FXML
    private void editButtonAction(ActionEvent event) {
        
    }
    
    void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("dataBarang.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            ListItem = (ArrayList<Item>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void SaveAndCreate() {
        FileOutputStream outputDoc;
        String xml = xstream.toXML(ListItem);
        File f = new File("dataBarang.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("dataBarang.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
    }
    
    void OpenData() {
        XStream xStream = new XStream(new StaxDriver());
        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("dataBarang.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }

            ListItem = (ArrayList<Item>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        data = new ItemList();
//        data.setDummy();
        tvMerch.setItems(data.getData());
        
        File f = new File("dataBarang.xml");
        if (f.exists() && !f.isDirectory()) {
            OpenData();
            for (int i = 0; i < ListItem.size(); i++) {
                observableListItem.add(ListItem.get(i));
            }

        }

        tvMerch.setItems(observableListItem);
    }    
    
}

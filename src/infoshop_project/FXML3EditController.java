package infoshop_project;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXML3EditController implements Initializable {
    ItemList data;
    ArrayList<String> dataList = new ArrayList<>();
    
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
        
//        if (tfIndex.getText().equals("")) {
//            dataList.add(tfName.getText());
//            dataList.add(tfStock.getText());
//            dataList.add(tfType.getText());
//            dataList.add(tfPrice.getText());
//        } else dataList.add(Integer.valueOf(tfIndex.getText(), tfName.getText(), tfStock.getText(), tfType.getText(), tfPrice.getText()));
//        
        tfName.setText("");
        tfStock.setText("");
        tfType.setText("");
        tfPrice.setText("");
    }
    
    public void getData(String d){
        lSeller.setText("Hi, " + d + "! Sehat po?");
        System.out.println("getData method is Invoked");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        data = new ItemList();
        data.setDummy();
        tvMerch.setItems(data.getData());
    }    
    
}

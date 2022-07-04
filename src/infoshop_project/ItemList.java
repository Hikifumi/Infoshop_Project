package infoshop_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemList {
    private ObservableList<Item> dataList;
    
    public ItemList(){
        dataList = FXCollections.observableArrayList();
    }
    
    public ObservableList<Item> getData(){
        return this.dataList;
    }
    
    public void setData(String name, int stock, String type, int price){
        dataList.add(new Item(name, stock, type, price));
    }
    
    public void setDummy(){
        dataList.add(new Item("Nama Barang", 99, "Tipe Barang", 999999999));
    }
}

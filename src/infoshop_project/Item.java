package infoshop_project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private SimpleStringProperty name;
    private SimpleIntegerProperty stock;
    private SimpleStringProperty type;
    private SimpleIntegerProperty price;
    
    public Item(){
        this("",0,"",0);
    }

    public Item(String name, int stock, String type, int price) {
        this.name = new SimpleStringProperty(name);
        this.stock = new SimpleIntegerProperty(stock);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleIntegerProperty(price);
    }
    
    public String getName(){
        return name.get();
    }
    
    public int getStock(){
        return stock.get();
    }
    
    public String getType(){
        return type.get();
    }
    
    public int getPrice(){
        return price.get();
    }
    
    public void setName(String n){
        this.name.set(n);
    }
    
    public void setStock(int s){
        this.stock.set(s);
    }
    
    public void setType(String t){
        this.type.set(t);
    }
    
    public void setPrice(int p){
        this.price.set(p);
    }
}

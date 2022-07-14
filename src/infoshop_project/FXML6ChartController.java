package infoshop_project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXML6ChartController implements Initializable {
    XStream xstream = new XStream(new StaxDriver());
    XYChart.Series<String, Integer> series = new XYChart.Series();
    ObservableList<Item> data = FXCollections.observableArrayList();
    
    Item item = new Item();
    
    @FXML private Label lExternal;
    @FXML private Label ljne;
    @FXML private Label ljnt;
    @FXML private Label ltiki;
    @FXML private Label lantareja;
    @FXML private Label lsicepat;
    
    @FXML private BarChart bcIncome;
    
    void OpenXML(){
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
    
    void barChart(){
        int ext, jne, jnt, tiki, antareja, sicepat;
        ext = 0;
        jne = 0;
        jnt = 0;
        tiki = 0;
        antareja = 0;
        sicepat = 0;
        
        for(int i=0; i<data.size();i++){
            if (data.get(i).getType().equals("External Expedition")){
                ext += 1;
            }else if (data.get(i).getType().equals("JNE")){
                jne += 1;
            }else if (data.get(i).getType().equals("JNT")){
                jnt += 1;
            }else if (data.get(i).getType().equals("Tiki")){
                tiki += 1;
            }else if (data.get(i).getType().equals("Antareja")){
                antareja += 1;
            }else if (data.get(i).getType().equals("SiCepat")){
                sicepat += 1;
            }
        }
        
        lExternal.setText(String.valueOf(": "+ext));
        ljne.setText(String.valueOf(": "+jne));
        ljnt.setText(String.valueOf(": "+jnt));
        ltiki.setText(String.valueOf(": "+tiki));
        lantareja.setText(String.valueOf(": "+antareja));
        lsicepat.setText(String.valueOf(": "+sicepat));
        
        series.getData().add(new XYChart.Data<>("External Expedition", ext));
        series.getData().add(new XYChart.Data<>("JNE", jne));
        series.getData().add(new XYChart.Data<>("JNT", jnt));
        series.getData().add(new XYChart.Data<>("Tiki", tiki));
        series.getData().add(new XYChart.Data<>("Antareja", antareja));
        series.getData().add(new XYChart.Data<>("SiCepat", sicepat));
        bcIncome.getData().add(series);
    }
    
    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
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
        OpenXML();
        this.barChart();
    }    
    
}

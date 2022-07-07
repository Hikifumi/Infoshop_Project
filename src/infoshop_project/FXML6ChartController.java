package infoshop_project;

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
import javafx.stage.Stage;

public class FXML6ChartController implements Initializable {
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    XYChart.Series data2 = new XYChart.Series<>();
    
    @FXML
    private PieChart pcIncome;
    
    @FXML
    private BarChart bcIncome;
    
    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("FXML5Income.fxml"));
        Scene scene = new Scene(scene2);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Income Table");
        stage.show();
        System.out.println("Penghasilan");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.add(new PieChart.Data("Sold",20));
        data.add(new PieChart.Data("Available",30));
        data.add(new PieChart.Data("Total Amount",50));
        data.add(new PieChart.Data("Percentage",100));
        pcIncome.setData(data);
        
        data2.getData().add(new XYChart.Data("Sold",20));
        data2.getData().add(new XYChart.Data("Available",30));
        data2.getData().add(new XYChart.Data("Total Amount",50));
        data2.getData().add(new XYChart.Data("Percentage",100));
        bcIncome.getData().add(data2);
    }    
    
}

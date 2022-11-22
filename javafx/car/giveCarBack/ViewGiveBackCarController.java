package javafx.car.giveCarBack;

import com.sun.deploy.net.MessageHeader;
import entities.GiveCar;
import entities.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewGiveBackCarController implements Initializable {
    public TableView tableGiveCar;
    public TableColumn clNameCus;
    public TableColumn clNameCar;
    public TableColumn clDate;
    public TableColumn clRetainedPapers;
    public TableColumn clAmountPaid;

    public static ObservableList<GiveCar> ls = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clNameCus.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        clNameCar.setCellValueFactory(new PropertyValueFactory<>("carName"));
        clDate.setCellValueFactory(new PropertyValueFactory<>("nkt"));
        clRetainedPapers.setCellValueFactory(new PropertyValueFactory<>("tl"));
        clAmountPaid.setCellValueFactory(new PropertyValueFactory<>("amountPaid"));

        tableGiveCar.setItems(ls);

    }
}

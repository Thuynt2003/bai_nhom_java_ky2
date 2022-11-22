package javafx.car.giveCarBack;

import com.sun.applet2.preloader.event.ConfigEvent;
import com.sun.deploy.net.MessageHeader;
import entities.Car;
import entities.GiveCar;
import entities.Order;
import javafx.car.listBill.ListBillController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.car.giveCarBack.ViewGiveBackCarController;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static helper.RootStage.rootStage;

public class GiveCarBackController implements Initializable {
    public static Car rentCar;
    public static Order rentOrder;
    public DatePicker date;
    public TextField nameCus;
    public TextField nameCar;
    public TextField amoutPaid;
    public TextField retainedPapers;
    public Button payBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCar.setText(rentCar.getName());
        nameCus.setText(rentOrder.getCusName());
        retainedPapers.setText(rentOrder.getGl());
    }

    public void pay(ActionEvent actionEvent) {
        Integer amountpaid =Integer.parseInt(amoutPaid.getText());
        LocalDate kt = date.getValue();
        Date date = Date.valueOf(kt);
        GiveCar gc =new GiveCar(date,nameCus.getText(),nameCar.getText(),retainedPapers.getText(),amountpaid);
        ViewGiveBackCarController.ls.add(gc);
    }
    public void giveView() throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../giveCarBack/viewGiveBackCar.fxml"));
        Scene sc = new Scene(listScene,1280,800);
        rootStage.setTitle("Give Back Car");
        rootStage.setScene(sc);
    }
}

package javafx.car.create;

import entities.Car;
import entities.Order;
import enums.RepoType;
import factory.Factory;
import impls.CarRepository;
import impls.OrderRepository;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import static helper.RootStage.rootStage;


public class CreateController implements Initializable {

    public static Car rentCar;

    public TextField txtName;
    public TextField txtEmail;

    public TextField txtTel;
    public TextField txtGl;
    public TextField txtCMT;
    public TextField carBrand;
    public TextField carName;
    public TextField carPrice;
    public DatePicker nbd;
    public DatePicker nkt;

    public static boolean patternMatchesEmail(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
                .matcher(emailAddress)
                .matches();
    }
    public void initialize(URL location, ResourceBundle resources) {
        carBrand.setText(rentCar.getBrand());
        carName.setText(rentCar.getName());
        carPrice.setText(rentCar.getPrice().toString());



    }
    public void submit(ActionEvent actionEvent) {
        try {
            if (!patternMatchesEmail(txtEmail.getText())){
                txtEmail.setText("");
                txtEmail.setStyle("-fx-border-color: #fc7373 ;-fx-border-radius:7;-fx-prompt-text-fill:  #fc7373;");
                txtEmail.setPromptText("! Email không hợp lệ");
            }else {
                txtEmail.setStyle("");
            }
            Integer cmt =Integer.parseInt(txtCMT.getText());
            Integer cpc =Integer.parseInt(carPrice.getText());
            LocalDate d = nbd.getValue();
            Date dd = Date.valueOf(d);
            LocalDate kt = nkt.getValue();
            Date ntt = Date.valueOf(kt);
            long noDay =Math.abs((ntt.getTime() - dd.getTime()) / (24 * 3600 * 1000));
            Integer k = rentCar.getPrice()*Math.toIntExact(noDay);
            if (txtTel.getText().startsWith("0")|| txtTel.getText().startsWith("+84")) {
                txtTel.setStyle("");
                Order s = new Order(null, txtName.getText(),txtTel.getText(),txtEmail.getText(),txtGl.getText(),cmt,k,carBrand.getText(),carName.getText(),cpc,dd,ntt, rentCar.getId());
                OrderRepository csc =(OrderRepository) Factory.createRepository(RepoType.ORDER);
                rentCar.setStatus(false);
                if (csc.create(s)) {
                    order();
                }

            }else {
                txtTel.setText("");
                txtTel.setStyle("-fx-border-color: #fc7373 ;-fx-border-radius:7;-fx-prompt-text-fill:  #fc7373;");
                txtTel.setPromptText("! Số điện thoại của bạn đã sai ");
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene sc = new Scene(listScene,1280,800);
        rootStage.setTitle("List Cars");
        rootStage.setScene(sc);
    }
    public void order() throws IOException {
        Parent listScene = FXMLLoader.load(getClass().getResource("../listBill/orderList.fxml"));
        Scene sc = new Scene(listScene,1280,800);
        rootStage.setTitle("List order");
        rootStage.setScene(sc);
    }

}

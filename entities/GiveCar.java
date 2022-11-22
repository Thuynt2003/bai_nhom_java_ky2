package entities;

import java.sql.Date;

public class GiveCar {
    public Date nkt;
    private String cusName;
    private String carName;
    private String tl;
    private Integer amountPaid;

    public GiveCar(Date nkt, String cusName, String carName, String tl, Integer amountPaid) {
        this.nkt = nkt;
        this.cusName = cusName;
        this.carName = carName;
        this.tl = tl;
        this.amountPaid = amountPaid;
    }

    public Date getNkt() {
        return nkt;
    }

    public void setNkt(Date nkt) {
        this.nkt = nkt;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }
}

package data.models;

import java.time.LocalTime;

public class OrderStatus {

    int orderStatusID;
String staffName;
    LocalTime expectlocalTime;
    private LocalTime localTime;
    private int sizes;
    private Orders order;

    public OrderStatus() {

    }

    public void setStaffName(String name){
        this.staffName = staffName;
    }
    public String getStaffName(){
        return staffName;
    }

    public String getStatus(){
    return toString();
    }


    @Override
    public String toString() {
        return "OrderStatus{" +
                "Logistic Staff Name=" + getStaffName() +
                "Delivery Time=" + getLocalTime() +
                "Expected Delivery Time=" +getExpectedTime() +
                "Orders Name=" + getOrderName().getOrderName() +
                "Orders Size=" + getOrderName().getOrderSize()+
                '}';
    }

    private LocalTime getExpectedTime() {
        return expectlocalTime;
    }

    public void setExpectedTime(LocalTime time) {
        this .expectlocalTime = time;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    private LocalTime getLocalTime() {
        return localTime;
    }

    public void setOrderName(Orders name){
        this.order = name;
    }
    public Orders getOrderName(){
        return order;
    }


    public String getGeneratedStatus(){
        return toString();
    }
}

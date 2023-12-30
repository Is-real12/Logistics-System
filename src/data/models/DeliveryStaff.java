package data.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DeliveryStaff {
    private  String staffName;

    private Orders ordersName;
    private final List<Orders> toDeliver = new ArrayList<>();
    private boolean isConfirm;
    private boolean isLogIn;
    private List<OrderStatus> orderStatuses = new ArrayList<OrderStatus>();
//    OrderStatus status = new OrderStatus(staffName, ordersName);

    private LocalTime localTime;






    private LocalTime expectedTime;


    public boolean isLogIn() {
        return isLogIn;
    }

    public void setLogIn(boolean logIn) {
        isLogIn = true;
    }



    public void isConfirm(OrderStatus orderStatus) {
        this.isConfirm = true;
        localTime = LocalTime.now();
        orderStatus.setLocalTime(localTime);
       orderStatuses.add(orderStatus);
    }


    public LocalTime getLocalTime()  {
        return localTime;
    }


    public String getStaffName() {
        return staffName;
    }

    public Orders getOrderName() {
        return ordersName;
    }

    public List<Orders> getToDeliver() {
        return toDeliver;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setOrderName(Orders ordersName) {
        this.ordersName = ordersName;
    }

    public void setToDeliver(Orders toDeliver) {
        this.toDeliver.add(toDeliver);
    }

    public void setExpectedTime(LocalTime expectedTime) {
        this.expectedTime = expectedTime;
    }

    public void logisticsToDeliver(Orders orders,  String staffName) {
        this.toDeliver.add(orders);
        this.setOrderName(orders);
        this.setStaffName(staffName);
    }

    public List<OrderStatus> getOrderStatuses() {
        return orderStatuses;
    }

    public OrderStatus getStatusByOrderName(String orderName){
        for (OrderStatus o: orderStatuses) {
            if (o.getOrderName().getOrderName().equals(orderName)){
                return o;
            }
        }

        return null;
    }



    public LocalTime getExpectedTime() {
        return expectedTime;
    }


}
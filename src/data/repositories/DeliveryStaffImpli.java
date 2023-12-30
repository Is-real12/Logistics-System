package data.repositories;

import data.models.DeliveryStaff;
import data.models.LogisticsStaffCo;
import data.models.OrderStatus;
import data.models.Orders;

import java.util.List;
import java.util.Random;

public class DeliveryStaffImpli implements DeliveryStaffRepo{
    public  LogisticsStaffCo logisticsStaffCo = new LogisticsStaffCo();
    Random random  = new Random();
DeliveryStaff deliveryStaff = new DeliveryStaff();
    public  DeliveryStaffImpli(){
//deliveryStaff.validate();
    }


    @Override
    public void finishDelivery() {
//        deliveryStaff.validate();
        int finishDelivery = random.nextInt(0, deliveryStaff.getToDeliver().size());
        Orders orders = deliveryStaff.getToDeliver().get(finishDelivery);
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderName(orders);
        orderStatus.setStaffName(deliveryStaff.getStaffName());
        orderStatus.setExpectedTime(logisticsStaffCo.getLocalTime());
        deliveryStaff.isConfirm(orderStatus);
        deliveryStaff.getToDeliver().remove(orders);
    }

    @Override
    public void viewStatus(String name) {
    deliveryStaff.getStatusByOrderName(name);
    }

    @Override
    public void removeDelivery(Orders name) {
        deliveryStaff.getToDeliver().remove(name);
        logisticsStaffCo.setAcceptedOrder(name);

    }

    public void determinToFinish(){
        if (deliveryStaff.getOrderStatuses().isEmpty() && !deliveryStaff.getToDeliver().isEmpty()){
            finishDelivery();
        }
    }

    @Override
    public void logIn() {
        deliveryStaff.setLogIn(true);
    }

    @Override
    public void logOut() {
        deliveryStaff.setLogIn(false);
    }

    @Override
    public Orders findToOrder(String orderName) {
//        Orders orders = new Orders()
        for (Orders d : deliveryStaff.getToDeliver()) {
            if (orderName.equals(d.getOrderName()))  {
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Orders> findAll() {
        return deliveryStaff.getToDeliver();
    }

    @Override
    public OrderStatus findStatusByOrderName(String name) {
       return deliveryStaff.getStatusByOrderName(name);

    }

    public List<OrderStatus> findAllStatus(){
        return deliveryStaff.getOrderStatuses();
    }

    @Override
    public void logisticsToDeliver(Orders orders, String s) {
        deliveryStaff.logisticsToDeliver(orders,  s);
    }


}

package services;

import data.models.OrderStatus;
import data.models.Orders;
import data.repositories.DeliveryStaffImpli;
import data.repositories.LogiStaffImpli;

import java.util.ArrayList;
import java.util.List;

public class StaffServiceImpli implements DeliveryStaffService{
    boolean aBoolean = false;
    //    DeliveryStaff deliveryStaff1 = new DeliveryStaff();
    DeliveryStaffImpli deliveryStaff = new DeliveryStaffImpli();
//    LogisticsServiceImpli logisticsServiceImpli = new LogisticsServiceImpli();

    @Override
    public void loginAsDeliveryStaff(String name, String pin) {
        for (String d : deliveryStaff.logisticsStaffCo.getDeliveryStaff()) {
            if (d.equals(name) && pin.equals(deliveryStaff.deliveryStaff.getPin())) {
                aBoolean = true;
//                StaffServiceImpli s = new StaffServiceImpli();
//                s.deliveryStaff.deliveryStaff.setStaffName(name);
//                return s;
            } else {

                throw new RuntimeException("Cresidentials id not correct ");
            }
        }
    }

    @Override
    public List<String> getListOfOrders() {
        List<String> listOrder  = new ArrayList<>();
        for (int i = 0; i <= deliveryStaff.findAll().size(); i ++) {
            listOrder.add(deliveryStaff.findAll().get(i).getOrderName());
        }
        return listOrder;
    }

    @Override
    public List<String> getListedOfDeliveredStatus() {
        if (aBoolean) {
            List<String> orderStatus = new ArrayList<>();
            for (OrderStatus o : deliveryStaff.findAllStatus()) {
                orderStatus.add(o.getGeneratedStatus());
            }
            return orderStatus;
        }else throw new RuntimeException("You are not logged in");
    }

    @Override
    public String findAnOrderStatus(String statusName) {
        String orderStatus = null;
        for (OrderStatus o: deliveryStaff.findAllStatus()) {
            if (o.getStaffName().equals(statusName)){
                orderStatus = (o.getGeneratedStatus());
                break;
            }
        }
        return orderStatus;
    }

    @Override
    public void deliverOrder() {
        if (aBoolean) {
            deliveryStaff.finishDelivery();
        }else throw new RuntimeException("You are not logged in");

    }

    @Override
    public void rejectOrder(String name, int sizes) {
        if (aBoolean) {
            Orders orders = new Orders(sizes);
            orders.setOrderName(name);
            deliveryStaff.removeDelivery(orders);
        }else throw new RuntimeException("You are not logged in");

    }


    @Override
    public void logOut() {
        aBoolean = false;
    }
}




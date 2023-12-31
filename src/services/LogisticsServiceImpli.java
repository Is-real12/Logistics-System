package services;

import data.models.Orders;
import data.repositories.LogiStaffImpli;

import java.util.ArrayList;
import java.util.List;

public class LogisticsServiceImpli implements LogisticsCoService{
    StaffServiceImpli s = new StaffServiceImpli();
    LogiStaffImpli staffImpli = new LogiStaffImpli();
    boolean aBoolean;
    @Override
    public void joinDeliveryStaffs(String name) {
        staffImpli.addStaff(name);
    }

    @Override
    public void assignStaffForDelivery() {
        if (aBoolean){
            staffImpli.assignStaffForDelivery();
        }else throw new RuntimeException("You are not a Logistic Staff");

    }

    @Override
    public void loginAsLogisticStaff(String pin) {
        if (staffImpli.logisticsStaffCo.getPin().equals(pin)){
            aBoolean = true;
    }
    }

    public boolean staffExist(String name) {
        if (aBoolean){
            return staffImpli.findStaffByName(name);
        }else throw new RuntimeException("You are not a Logistic Staff");
    }

    @Override
    public void fireStaff(String name) {
        if (aBoolean){
        staffImpli.removeStaff(name);
    }else throw new RuntimeException("You are not a Logistic Staff");

    }

    @Override
    public String getAllStaffAvailable() {
        if (aBoolean){
         return staffImpli.getAllStaff().toString();
        }else throw new RuntimeException("You are not a Logistic Staff");

    }

    @Override
    public void placeAnOrder(String name, int size) {
        Orders orders = new Orders(size);
        orders.setOrderName(name);
        staffImpli.aceptOrdrDetermination(orders);
    }

    @Override
    public void findIfOrderIsConfirmed(String name) {
        List<String> one = new ArrayList<>();
        for (Orders o:  staffImpli.allAcceptedOrder()) {
            if (o.getOrderName().equals(name)) {
                one.add(o.getOrderName());
            }
        }throw new RuntimeException("Order not Found");


    }


}

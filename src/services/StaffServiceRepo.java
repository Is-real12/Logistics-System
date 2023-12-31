package services;

import data.repositories.DeliveryStaffImpli;

import java.util.List;

public class StaffServiceRepo implements DeliveryStaffService{

    DeliveryStaffImpli deliveryStaff = new DeliveryStaffImpli();

    @Override
    public boolean loginAsDeliveryStaff(String name, String pin) {

        return false;
    }

    @Override
    public List<String> getListOfOrders() {
        return null;
    }

    @Override
    public List<String> getListedOfDeliveredStatus() {
        return null;
    }

    @Override
    public String findAnOrderStatus(String statusName) {
        return null;
    }

    @Override
    public void deliverOrder() {

    }

    @Override
    public void rejectOrder() {

    }

    @Override
    public void logIn(String name, String pin) {
        deliveryStaff.logIn();
    }

    @Override
    public void logOut() {
        deliveryStaff.logIn();
    }
}

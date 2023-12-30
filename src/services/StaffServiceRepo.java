package services;

import data.models.DeliveryStaff;
import data.repositories.DeliveryStaffImpli;

public class StaffServiceRepo implements DeliveryStaffService{

    DeliveryStaffImpli deliveryStaff = new DeliveryStaffImpli();
    @Override
    public void logIn(String name, String pin) {
        deliveryStaff.logIn();
    }

    @Override
    public void logOut() {
        deliveryStaff.logIn();
    }
}

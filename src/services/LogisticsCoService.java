package services;

import data.repositories.DeliveryStaffImpli;

import java.util.List;

public interface LogisticsCoService {
    boolean staffExist(String name);
    void loginAsLogisticStaff(String pin);
    void joinDeliveryStaffs(String name);
    DeliveryStaffImpli assignStaffForDelivery();
    void fireStaff(String name);
    List<String> getAllStaffAvailable();
    void placeAnOrder(String name, int size);
    void findIfOrderIsConfirmed(String name);


}

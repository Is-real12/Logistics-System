package services;

public interface LogisticsCoService {
    boolean staffExist(String name);
    void loginAsLogisticStaff(String pin);
    void joinDeliveryStaffs(String name);
    void assignStaffForDelivery();
    void fireStaff(String name);
    String getAllStaffAvailable();
    void placeAnOrder(String name, int size);
    void findIfOrderIsConfirmed(String name);


}

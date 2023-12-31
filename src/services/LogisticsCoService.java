package services;

public interface LogisticsCoService {
    void findStaff();
    boolean loginAsLogisticStaff(String pin);
    void joinDeliveryStaffs(String name);
    void placeAnOrder(String name, int size);
    void findIfOrderIsConfirmed(String name);
    void findOrderStatus(String order);

}

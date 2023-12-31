package services;

import java.util.List;

public interface DeliveryStaffService {

    void loginAsDeliveryStaff(String name, String pin);
    List<String> getListOfOrders();
    List<String> getListedOfDeliveredStatus();
    String findAnOrderStatus(String statusName);
    void deliverOrder();
    void rejectOrder(String name, int sizes);
    void logOut();

}

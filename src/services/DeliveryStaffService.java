package services;

import java.util.List;

public interface DeliveryStaffService {

    boolean loginAsDeliveryStaff(String name, String pin);
    List<String> getListOfOrders();
    List<String> getListedOfDeliveredStatus();
    String findAnOrderStatus(String statusName);
    void deliverOrder();
    void rejectOrder();
    void logIn(String name, String pin);
    void logOut();

}

package data.repositories;

import data.models.Orders;

import java.util.List;

public interface LogiStaffRepo {
    void addStaff(String name);
    void removeStaff(String name);
    void acceptOrder(Orders ordersName);
    void rejectOrder(Orders orders);
    void aceptOrdrDetermination(Orders orders);
    void assignStaffForDelivery();
    List<String> getStaffAssignedForDelivery();
    boolean checkIfAssignedByName(String name);
    List<String> getAllStaff();
    boolean findStaffByName(String name);




}
